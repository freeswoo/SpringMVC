package com.biz.score.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.score.domain.StudentVO;
import com.biz.score.persistance.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<StudentVO> getStdAllList() {
		
		StudentDao stdDao = sqlSession.getMapper(StudentDao.class);
		List<StudentVO> stdList = stdDao.selectAll();
		return stdList;
	}

}
