package com.biz.score.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ScoreVO {
	
	private String s_num;
	private String s_subject;
	private int s_score;
    
	private int kor;
	private int eng;
	private int math;
	private int sci;
	private int k_his;
	
	private int sum;
	private int avg;
	private int rank;
	
}
