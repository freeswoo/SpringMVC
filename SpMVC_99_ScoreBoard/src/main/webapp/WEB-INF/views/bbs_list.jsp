<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
	<script>
	$(function(){
		$("button.btn-writer").click(function(){
			document.location.href="${rootPath}/insert";
		})
	})
	</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<section class="container-fluid">
		<article>
			<table class="table table-striped table-hover">
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>학년</th>
					<th>반</th>
				</tr>
				<c:forEach items="${BBS_LIST}" 
							var="BBS" varStatus="i">
				<tr>
					<td>${SCORE.st_num}</td>
					<td>${BBS.b_writer}</td>
					<td>${BBS.b_date_time}</td>
					<td>
					<a href="${rootPath}/detail?b_id=${BBS.b_id}">
					${BBS.b_subject}
					</a></td>
				</tr>
				</c:forEach>
			</table>
		</article>
		<article class="d-flex justify-content-end">
			<button class="btn btn-primary text-white btn-writer">글쓰기</button>		
		</article>
	</section>
</body>
</html>
