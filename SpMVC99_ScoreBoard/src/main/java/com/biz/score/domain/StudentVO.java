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
public class StudentVO {
	
	private String st_num;
	private String st_name;
	private int st_grade;
	private int st_class;
	
}
