<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<caption>사원테이블</caption>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직종</th>
			<th>입사일</th>
			<th>급여</th>
		</tr>
		<c:forEach var="vo" items="${list}" >
			<tr>
				<td>${vo.sabun}</td>
				<td>${vo.saname}</td>
				<td>${vo.sajob}</td>
				<%-- <td><fmt:${vo.sahire}></td> --%>
				<td>${vo.sapay}</td>
			</tr>
		</c:forEach>
		
	
	</table>

</body>
</html>