<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 홈페이지 □□□</title>
<script>
	$(function() {
		$(".content-body").click(function() {
			let b_code = $(this).attr("id")
			document.location.href = "${rootPath}/book/view?b_code=" + b_code
		})
	})
</script>
</head>
<header>
	<h2>도서정보</h2>
</header>
<body>
	<div>
		<table>
			<tr>
				<th>도서코드</th>
				<th>도서제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>출판년도</th>
				<th>가격</th>
			</tr>
			<tr>
				<c:if test ="${!empty b_List}">
					<c:forEach items="${b_List}" var="book">
					<tr class="content-body" id="${bookVO.b_code}">
						<td>${book.b_code}</td>
						<td>${book.b_name}</td>
						<td>${book.b_auther}</td>
						<td>${book.b_comp}</td>
						<td>${book.b_year}</td>
						<td>${book.b_iprice}</td>
					</tr>
					</c:forEach>
				</c:if>
			</tr>
		</table>
		<button><a href="${rootPath}/insert">추가</a></button>
	</div>
</body>
</html>