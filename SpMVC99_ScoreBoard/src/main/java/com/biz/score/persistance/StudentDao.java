package com.biz.score.persistance;

import java.util.List;

import com.biz.score.domain.StudentVO;

public interface StudentDao {
	
	public List<StudentVO> selectAll();
	
	
	
}
