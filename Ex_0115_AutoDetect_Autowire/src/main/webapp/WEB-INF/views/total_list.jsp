<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서위치</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.deptno}</td>
				<td>${vo.dname}</td>
				<td>${vo.loc}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<table border="1" align="center">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직책</th>
			<th>급여</th>
		</tr>
		<c:forEach var="vo" items="${list2}">
			<tr>
				<td>${vo.sabun}</td>
				<td>${vo.saname}</td>
				<td>${vo.sajob}</td>
				<td>${vo.sapay}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>