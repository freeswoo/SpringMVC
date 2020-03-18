package com.biz.naver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NaverVO {

	// 뉴스
	private String title;//": "신천지 신도 <b>코로나</b>19 확진…이번에는 충주",
	private String originallink;//": "http://news.mk.co.kr/newsRead.php?no=281053&year=2020",
	private String link;//": "https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=102&oid=009&aid=0004538950",
	private String description;//": "충청북도 충주에 사는 신천지 교회 신도가 <b>코로나</b>19 검사에서 확진 판정을 받았다. 충북 지역 내 신천지 신도의 <b>코로나</b>19 확진은 처음이다. 충북도 등은 18일 온라인 매체 기자 A(30)씨가 지난 17일 건국대 충주병원 선별... ",
	private String pubDate;//":
	
	// 영화
	private String image;
	private String subtitle;
	private String director;
	private String actor;
	private String userRating;
	
	// 도서
	private String author;
	private String price;
	private String discount;
	private String publisher;
	private String pubdate;
	private String isbn;
}
