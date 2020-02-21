package com.biz.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Controller(클래스)
 * @Controller Annotation을 설정하여
 * 프로젝트가 서버에 의해 실행되면(Run as Servier)
 * 사용자(Web browser를 통해 접속한)가 서버에 접속을 하면
 * 어떤 요청을 하는지 기다리는 역할
 * 
 * 스프링 프로젝트의 문지기 클래스
 */
@Controller
public class HomeController {
	/*
	 * request : 사용자가 보는는 요청
	 * 1. request를 사용자가 보내면 보낸 정보중에서 url 주소에 포함된 문자들을 검사한다
	 * 2. 그리고 그 문자들과 일치하는 @RequestMapping 정보를 찾는다
	 * 3. @RequestMapping을 찾으면 해당 method를 실행하는 코드가 작동된다
	 * 4. return "문자열" 이 있으면 /WEB-INF/view/문자열.jsp 파일을 찾는다
	 * 5. 파일을 찾으면 tomcat에게 해당 파일을 전달하고
	 * 6. 사용자에게 응답을 보내도록 한다.
	 * 		response
	 */
	 
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/name")
	public String name() {
		return "name";
	}
	
	/*
	 * @ResponseBody
	 * request받아서 모든 요청을 끝낸 후
	 * return "문자열" statement를 만나면
	 * WEB-INF/views/문자열.jsp 파을을 찾는 것이 아니라
	 * 
	 * 문자열 자체를 response 하라(대한민국 이라는 문자를 보내라)
	 */
	@ResponseBody
	@RequestMapping("/korea")
	public String korea() {
		return "대한민국";
	}
	
	@ResponseBody
	@RequestMapping("/num_add")
	public String num_add() {
		
		int num1 = 30;
		int num2 = 40;
		int sum = num1 + num2;
		
		return "Add Num : " + sum;
	}
	
	@ResponseBody
	@RequestMapping("/nums")
	public String nums() {
		
		int sum = 0;
		for(int i = 1; i <= 100 ; i++) {
			sum += i;
		}
		return "1~100까지 덧셈 : " + sum;
	}
}
