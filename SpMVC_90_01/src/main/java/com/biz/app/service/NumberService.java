package com.biz.app.service;

import org.springframework.stereotype.Service;

import com.biz.app.ScoreVO;

/*
 * Service 클래스
 * @Service Annotation을 설정한 클래스
 * 
 * Controller가 사용자의 요청을 받았는데
 * 단순한 연산을 수행해서 결과를 보낼 사안이 아닐때
 * 1. 조금 복잡한 무언가를 수행해야할때
 * 		Controller의 기능을 보조하는 역할을 수행한다.
 * 
 * 
 */
@Service
public class NumberService {

	public int add(int num1, int num2) {
		int sum = 0;
		sum = num1 + num2;
		return sum;
	}

	public int enen(int start, int end) {
		int sum = 0;
		for(int i = start; i <= end ; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public int total(int kor, int eng, int mat, int sc, int mu) {
		int total = kor + eng + mat + sc + mu;
		
		return total;
	}
	
	public int avg(int kor, int eng, int mat, int sc, int mu) {
		int total = kor + eng + mat + sc + mu;
		int avg = total / 5;
		return avg;
	}

	public void score(ScoreVO scoreVO) {
		
		int sum = scoreVO.getKor();
		sum += scoreVO.getEng();
		sum += scoreVO.getMat();
		sum += scoreVO.getSc();
		sum += scoreVO.getMu();
		
		scoreVO.setTotal(sum);
		scoreVO.setAvg(sum/5);
		
	}
	
	
}
