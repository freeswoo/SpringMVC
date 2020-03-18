package com.biz.book.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.book.domain.BookVO;
import com.biz.book.repository.BookDao;

@Service
public class BookService {
	
	@Autowired // 초기화
	SqlSession sqlSession; //선언
	
	BookDao bDao;
	
	@Autowired
	public void bDao() {
		this.bDao = sqlSession.getMapper(BookDao.class);
	}
	
	public List<BookVO> selectAll() {
		return bDao.selectAll();
	}

	public int insert(BookVO bookVO) {
		return bDao.insert(bookVO);
	}
	
	public int update(BookVO bookVO) {
		return bDao.update(bookVO);
		
	}

	public int delete(String b_code) {
		return bDao.delete(b_code);
	}

	public BookVO findByBCode(String b_code) {
		return bDao.findByBCode(b_code);
	}

	
	
	

	
}
