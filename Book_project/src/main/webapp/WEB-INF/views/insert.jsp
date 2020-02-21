<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 홈페이지 □□□</title>
</head>
<body>
<h3>도서정보 입력</h3>
<form action = "/book/insert" method=POST>
	<label>도서코드</label>
	<input name="b_code" placeholder="도서코드"/><br>
	<label>도서제목</label>
	<input name="b_name" placeholder="도서제목"/><br>
	<label>저자</label>
	<input name="b_auther" placeholder="저자"/><br>
	<label>출판사</label>
	<input name="b_comp" placeholder="출판사"/><br>
	<label>출판연도</label>
	<input name="b_year" placeholder="출판연도"/><br>
	<label>가격</label>
	<input name="b_iprice" placeholder="가격"/><br>
	<button>저장</button>
</form>
	
</body>
</html>