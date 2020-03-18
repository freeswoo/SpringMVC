package com.biz.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bService;
	
	/*
	 * home.jsp 파일로 이동
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String list(Model model) {
		List<BookVO> bookList = bService.selectAll();
		model.addAttribute("b_List",bookList);
		return "home";
	}
	/*
	 * home.jsp에서 추가 버튼을 클릭하면 여기로 옴
	 * 그리고 insert.jsp로 넘어감
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "insert";
	}
	/*
	 * insert.jsp 내용 입력후 저장 버튼 누르면 
	 * 여기로 옴
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		int ret = bService.insert(bookVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String b_code, Model model) {		
		BookVO bookVO = bService.findByBCode(b_code);
		model.addAttribute("bookVO",bookVO);
		return "update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BookVO bookVO) {		
		bService.update(bookVO);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(String b_code) {
		bService.delete(b_code);
		return "redirect:/";
	}
}
