<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/vs/resources/css/visit.css">
<style type="text/css">
</style>
<!-- scr="${pageContext.request.contextPath}/resources/js/... "-->
<script type="text/javascript" src="/vs/resources/js/httpRequest.js"></script>
<script type="text/javascript">
	function del(f) {
		let pwd = f.pwd.value;
		let c_pwd = f.c_pwd.value;
		if (!confirm('정말로 삭제하시겠습니까?')) {
			return;
		}
		let url = "delete.do";
		let param = "idx=" + f.idx.value + "&pwd=" + f.pwd.value + "&c_pwd="
				+ f.c_pwd.value;
		sendRequest(url, param, resultFn, "POST");
	}//del
	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let data = xhr.responseText;
			if (data == "3") {
				alert("삭제가능");
			} else if (data == "1") {
				alert("삭제성공");
				location.href = "list.do";
				return;
			} else {
				alert("삭제실패");
			}
		}
	}
	function modify(f) {
		let pwd = f.pwd.value;
		let c_pwd = f.c_pwd.value;
		let url = "modify_form.do";
		let param = "idx=" + f.idx.value + "&pwd=" + pwd + "&c_pwd=" + c_pwd;
		sendRequest(url, param, resModify, "POST");
	}//modify

	function resModify() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let data = xhr.responseText;
			if (data == "0") {
				return;
			} else if (data == "1") {
				location.href = "modify.do";
				return;
			} else {
				alert("비밀번호 불일치");

			}
		}
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1>:::방명록 리스트:::</h1>
		<div align="center">
			<input type="button" value="글쓰기"
				onclick="location.href='insert_form.do'">
		</div>
		<c:forEach var="vo" items="${list}">
			<div class="visit_box">
				<div class="type_content">
					<pre>${vo.content}</pre>
					<c:if test=${vo.filename ne 'no_file'}>
						<img src="resources/upload/${vo.filename}" width="200">
					</c:if>
				</div>
				<div class="type_name">${vo.name}</div>
				<div class="type_regdate">${vo.regdate}</div>
				<div>
					<form>
						<input type="hidden" name="idx" value="${vo.idx}"> <input
							type="hidden" name="pwd" value="${vo.pwd}"> 비밀번호<input
							type="password" name="c_pwd"> <input type="button"
							value="수정" onclick="modify(this.form);"> <input
							type="button" value="삭제" onclick="del(this.form);">
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>