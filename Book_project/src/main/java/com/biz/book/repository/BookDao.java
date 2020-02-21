package com.biz.book.repository;

import java.util.List;

import com.biz.book.domain.BookVO;

public interface BookDao {

	public List<BookVO> selectAll();
	
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(String b_code);

	public BookVO findByBCode(String b_code);
	
}
