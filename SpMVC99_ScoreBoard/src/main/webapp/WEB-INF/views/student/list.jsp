<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
	<style>
table {
	/* 
	table을 표시할때
    table의 바깥쪽 라인과
    각 칼럼의 라인간의 간격을 없애고자 할때
    표를 실선모양으로 외부 라인 설정
    */
	border-collapse: collapse;
	border-spacing: 0;
	width: 90%;
	border: 1px solid blue;
	border: 1px dotted blue;
	/* top, botton 여백을 20px로 하고 */
	/* 
	left와 right 여백을 자동으로 하세요
	좌우 중앙에 물체(box)를 위치하라 
	*/
	margin: 20px auto;
}
table tr {
	border: 1px dotted red;
}
/* td, th : td tag와 th tag에 공통된 속성을 부여 */
table td, table th {
	padding: 8px;
	vertical-align: top;
}
table th {
	text-align: left;
}
table tr:nth-child(odd) {
	background-color: #fff;
}
table tr:nth-child(even) {
	background-color: #ccc;
}
/*
table row에 마우스가 위치하면
바탕색을 gray로 설정하고
마우스커서를 손가락 모양으로
*/
table tr:hover {
	background-color: gray;
	cursor: pointer;
}
</style>
<table>
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>학년</th>
		<th>반</th>
	</tr>
	<c:choose>
		<c:when test="${STDLIST == NULL}">
			<tr>
				<td colspan="5">데이터가 없습니다</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${STDLIST}" var="vo">
				<tr>
					<td>${vo.st_num}</td>
					<td>${vo.st_name}</td>
					<td>${vo.st_grade}</td>
					<td>${vo.st_class}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>


</table>