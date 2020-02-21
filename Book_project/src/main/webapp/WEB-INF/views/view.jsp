<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<body>
<h2>세부정보</h2>
<section>
	<table>
		<tr>
			<th>도서코드</th><td>${bookVO.b_code}</td>
		</tr>
		<tr>
			<th>도서제목</th><td>${bookVO.b_code}</td>
		</tr>
		<tr>
			<th>저자</th><td>${bookVO.b_code}</td>
		</tr>
		<tr>
			<th>출판사</th><td>${bookVO.b_code}</td>
		</tr>
		<tr>
			<th>출판년도</th><td>${bookVO.b_code}</td>
		</tr>
		<tr>
			<th>가격</th><td>${bookVO.b_code}</td>
		</tr>
		<tr>
			<td>
				<div>
					<button>수정</button>
					<button>삭제</button>
				</div>
			</td>
		</tr>
	</table>
</section>
</body>
</html>