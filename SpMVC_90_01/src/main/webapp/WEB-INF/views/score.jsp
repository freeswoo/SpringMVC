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
<h2>학생점수</h2>
<div><b>총점:</b>${TOTAL}</div>
<div><b>평균:</b>${AVG}</div>
</body>
</html>