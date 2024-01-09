<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
			function send1(f){
				f.action = "insert1.do";
				f.method="post";
				f.submit();
				/* location.href="aa.do?name="+f.name.value... */
			}
			function send2(){
				f.action = "insert2.do";
				f.submit();
			}
		</script>
	</head>
	<body>
		<form>
			<table border="1" align = "center">
				<tr>
					<th>이름</th>
					<td><input name="name"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input name="age"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input name="addr"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="낱개로 전송" onclick="send1(this.form);">
						<input type="button" value="객체로 전송" onclick="send2(this.form);">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>