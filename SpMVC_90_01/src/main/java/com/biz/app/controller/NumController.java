package com.biz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.app.ScoreVO;
import com.biz.app.service.NumberService;

@RequestMapping(value="/number")
@Controller
public class NumController {
	
	@Autowired //NumberService 초기화 작업
	NumberService nService; // NumberService 선언
	
	@ResponseBody
	@RequestMapping(value="/add", produces = "text/html;charset=UTF-8")
	public String add() {
		
		// NumberService num = new NumberService();
		// int ret = num.add(30, 40);
		
		int ret = nService.add(30, 40);
		return "두수의 덧셈 : " + ret;
	}
	
	/*
	 * 사용자가 /number/even 이라고 요청을 하면
	 * 1~100까지 숫자 중에서 짝수의 덧셈만 수행하여 결과를 알려주겠다
	 */
	@ResponseBody
	@RequestMapping(value="/even", produces = "text/html;charset=UTF-8")
	public String even() {
		
		int start = 1;
		int end = 100;
		// service에게 요청을 해서 짝수 덧셈을 수행해달라고 할것
		int even = nService.enen(start,end);
		String res = 
				String.format("%d 부터 %d까지의 숫자중 "
						+ "짝수의 합 : %d",start,end,even);
		return res;
	}
	//http://localhost:8080/app/number/num2even?start=30&end=50 <-- 주소창 입력
	/*
	 * 사용자가 요청한 변수=값의 형태는 무조건 값이 문자열이다
	 * 만약 매개변수 type int 형으로 선언을 하면
	 * spring은 사용자의 변수를 수신한 후 Integer.valueOf(변수) 코드를 실행하여
	 * 문자열을 숫자로 변환 시키려 시도를 한다.
	 * 
	 * 그련데 수신한 값이 숫자로 변환이 불가능하면
	 * 사용자에게 400 오류를 전송한다
	 */
	@ResponseBody
	@RequestMapping(value="/num2even", produces = "text/html;charset=UTF-8")
	public String even(String start, String end) {
		int intstart = 0;
		int intend = 0;
		try {
			intstart = Integer.valueOf(start);
			intend = Integer.valueOf(end);
		} catch (Exception e) {
			return "전송된 값을 숫자로 변환할수 없습니다.";
		}
		
		
		// service에게 요청을 해서 짝수 덧셈을 수행해달라고 할것
		int even = nService.enen(intstart,intend);
		String res = 
				String.format("%d 부터 %d까지의 숫자중 "
						+ "짝수의 합 : %d",intstart,intend,even);
		return res;
	}
	
	/*
	 * 국어, 영어, 수학, 과학, 음악 점수를 request로 받아서
	 * 총점과 평균을 계산후
	 * response 하고자 한다.
	 */
	@ResponseBody
	@RequestMapping(value="/score", produces = "text/html;charset=UTF-8")
	public String score(int kor, int eng, int mat, int sc, int mu) {
		int total = nService.total(kor, eng, mat, sc, mu);
		int avg = nService.avg(kor, eng, mat, sc, mu);
		
		String res = String.format("총점 : %d\n평균 : %d" ,total,avg);
		return res;
	}
	
	/*
	 * 매개변수로 Model 클래스를 설정하고
	 * model 객체에 addAttribute("변수명",값) 형식으로 내용을 추가하고
	 * jsp 파일을 return 하면
	 * 렌더링
	 * spring, tomcat은
	 * 		model 에 담겨 있는 값과
	 * 		jsp 파일을 비교하여 연관 변수들을 변환하여 html 코드로 생성
	 */
	//@ResponseBody
	@RequestMapping(value="/score_jsp", produces = "text/html;charset=UTF-8")
	public String score_jsp(int kor, int eng, int mat, int sc, int mu, Model model) {
		
		int total = nService.total(kor, eng, mat, sc, mu);
		int avg = nService.avg(kor, eng, mat, sc, mu);
		
		// TOTAL이라는 이름의 변수에 total(총점)값을 담아서 전달 하겠다
		model.addAttribute("TOTAL",total);
		
		// AVG라는 이름의 변수에 avg(평균)값을 담아서 전달하겠다
		model.addAttribute("AVG",avg);
		
		//String res = String.format("총점 : %d\n평균 : %d" ,total,avg);
		//return res;
		
		//
		return "score";  // score.jsp
	}
	
	/*
	 * 사용자는 학생의 점수를 입력하여
	 * 총점과 계산을 하고 싶다고 요청을 한다.
	 * 
	 * 그러면 학생의 과목 점수를 입력할수 
	 * 있는 화면을 보내는 역할을 수행한다.
	 */
	@RequestMapping(value="/score_input",method=RequestMethod.GET)
	public String score_input() {
		return "score_input";
	}
	
	@RequestMapping(value="/score_input",method=RequestMethod.POST)
	public String score_input(ScoreVO scoreVO, Model model) {
		
		nService.score(scoreVO);
		model.addAttribute("scoreVO",scoreVO);
		
		return "score_input";
	}
}
