package com.biz.shop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.biz.shop.domain.AuthorityVO;
import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.persistance.AuthoritiesDao;
import com.biz.shop.persistance.UserDao;
import com.biz.shop.utils.PbeEncryptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserServiceImp implements UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final AuthoritiesDao authDao;

	@Autowired
	public UserServiceImp(PasswordEncoder passwordEncoder, 
					UserDao userDao,
					AuthoritiesDao authDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.authDao = authDao;

		String create_user_table = " CREATE TABLE IF NOT EXISTS tbl_users ("
				+ "	id bigint  PRIMARY KEY AUTO_INCREMENT, " 
				+ "	user_name varchar(50) UNIQUE, "
				+ "	user_pass varchar(125), " 
				+ " enabled boolean default true, "
				+ "	nickname varchar(50), "
				+ "	email varchar(50), "
				+ "	phone varchar(20), " 
				+ "	address varchar(125) " + " ) ";

		String create_auth_table = " CREATE TABLE IF NOT EXISTS authorities ("
				+ "	id bigint PRIMARY KEY AUTO_INCREMENT," 
				+ "    username varchar(50)," + "    authority varchar(50)"
				+ " ) ";

		userDao.create_table(create_user_table);
		userDao.create_table(create_auth_table);

	}

	@Transactional
	public int insert(String username, String password) {

		// 회원가입 form에서 전달받은 password 값을 암호화 시키는 과정
		String encPassword = passwordEncoder.encode(password);
		UserDetailsVO userVO = UserDetailsVO.builder().username(username).password(encPassword).build();

		int ret = userDao.insert(userVO);
		List<AuthorityVO> authList = new ArrayList<>();

		authList.add(AuthorityVO.builder()
				.username(userVO.getUsername())
				.authority("ROLE_USER").build());
		
		authList.add(AuthorityVO.builder()
				.username(userVO.getUsername())
				.authority("USER").build());
		
		authDao.insert(authList);
		return ret;

	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED,
				rollbackFor = Exception.class )
	public int insert(UserDetailsVO userVO) {

		// 회원정보에 저장할 준비가 되지만
		// 로그인을 했을때 접근금지가 된 사용자가 된다.
		userVO.setEnabled(false);
		userVO.setAuthorities(null);
		log.debug(userVO.getPassword());
		
		// 회원가입 form에서 전달받은 password 값을 암호화 시키는 과정
		String encPassword 
			= passwordEncoder.encode(userVO.getPassword());
		userVO.setPassword(encPassword);
		
		int ret = userDao.insert(userVO);
		return ret ;
	}
	
	public boolean isExistsUserName(String username) {

		UserDetailsVO userVO = userDao.findByUserName(username);
		// 이미 DB에 회원정보(username)이 저장되어 있다.
		if (userVO != null && userVO.getUsername().equalsIgnoreCase(username)) {
			return true;
		}
		return false;

	}

	public UserDetailsVO findById(long id) {

		UserDetailsVO userVO = userDao.findById(id);
		return userVO;
	}

	public boolean check_password(String password) {
		UserDetailsVO userVO = (UserDetailsVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		log.debug(userVO.toString());
		return passwordEncoder.matches(password, userVO.getPassword());
	}

	@Transactional
	public int update(UserDetailsVO userVO,String[] authList) {
		
		int ret = userDao.update(userVO);
		if (ret > 0) {
			List<AuthorityVO> authCollection = new ArrayList();
			for(String auth : authList) {
				if(!auth.isEmpty()) {
					AuthorityVO authVO = AuthorityVO.builder()
							.username(userVO.getUsername())
							.authority(auth).build();
					authCollection.add(authVO);
				}
			}
			authDao.delete(userVO.getUsername());
			authDao.insert(authCollection);
		}
		return ret;
	}
	
	@Transactional
	public int update(UserDetailsVO userVO) {

		Authentication oldAuth 
			= SecurityContextHolder
			.getContext()
			.getAuthentication();
		
		UserDetailsVO oldUserVO 
			= (UserDetailsVO) oldAuth.getPrincipal();
		
		oldUserVO.setEmail(userVO.getEmail());
		oldUserVO.setPhone(userVO.getPhone());
		oldUserVO.setAddress(userVO.getAddress());

		int ret = userDao.update(oldUserVO);
		// DB update가 성공하면
		// 로그인된 session정보를 update 수행
		if (ret > 0) {
			Authentication newAuth 
					= new UsernamePasswordAuthenticationToken(
					oldUserVO, 	// 변경된 사용자 정보 
					oldAuth.getCredentials(),
					oldAuth.getAuthorities()); // 변경된 ROLE 정보
			SecurityContextHolder.getContext()
						.setAuthentication(newAuth);
		}
		return ret;

	}

	private Collection<GrantedAuthority> getAuthorities(String[] authList) {

		List<GrantedAuthority> authorities 
			= new ArrayList<GrantedAuthority>();
		for (String auth : authList) {
			
			if(!auth.isEmpty()) {
				SimpleGrantedAuthority sAuth 
				= new SimpleGrantedAuthority(auth);
				authorities.add(sAuth);
			}
		}
		return authorities;
	
	}
	
	@Transactional
	public List<UserDetailsVO> selectAll() {
		return userDao.selectAll();
	}

	@Transactional
	public UserDetailsVO findByUserName(String username) {
		return userDao.findByUserName(username);
	}
	
	@Transactional
	public boolean emailok(String username, String email) {

		String strUserName = PbeEncryptor.getDecrypt(username);
		UserDetailsVO userVO 
				= userDao.findByUserName(strUserName);
		
		String strEmail = PbeEncryptor.getDecrypt(email);
		if(strEmail.equalsIgnoreCase(userVO.getEmail())) {
		
			userVO.setEnabled(true);
			userDao.update(userVO);
			
			List<AuthorityVO> authList = new ArrayList<>();
			authList.add(AuthorityVO.builder()
					.username(userVO.getUsername())
					.authority("ROLE_USER").build());
			
			authList.add(AuthorityVO.builder()
					.username(userVO.getUsername())
					.authority("USER").build());
			authDao.insert(authList);
			return true;
		}
		return false;
		
		
	}


}



