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
		나는 dept.jsp	<br>
		${ip}<br>
		<c:forEach var="g" items="${msg}">
			${g}<br>
		</c:forEach>
	</body>
</html>