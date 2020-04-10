package com.biz.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class ScoreController {

	@RequestMapping(value="/score_input",method=RequestMethod.GET)
	public String score_input() {
		return "score_input";
	}
}
