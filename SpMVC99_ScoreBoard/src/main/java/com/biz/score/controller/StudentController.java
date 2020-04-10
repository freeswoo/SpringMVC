package com.biz.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.score.domain.StudentVO;
import com.biz.score.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {

	@Autowired
	StudentService sService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("STUDENT-LIST");
		List<StudentVO> stdList = sService.getStdAllList();
		model.addAttribute("STDLIST",stdList);
		
		return "home";
	}
	
}
