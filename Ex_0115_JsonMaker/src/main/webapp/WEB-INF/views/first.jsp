<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/jm/resources/js/httpRequest.js">
	
</script>
<script type="text/javascript">
	function send(f) {
		url = "vo_json.do";
		sendRequest(url, null, resultFn, "get");
	}
	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//{"name":"홍길동","addr":"서울시 관악구","age":20}
			//let data = xhr.responseText;
			//let json = eval("["+data+"]");
			let json = JSON.parse(this.responseText);
			let pName = document.getElementById("name").innerHTML= json.name;
			let pAge= document.getElementById("age").innerHTML= json.addr;
			let pAddr = document.getElementById("addr").innerHTML= json.age;
		}
	}
</script>
</head>
<body>
	<form>
		<input type="button" value="json 가져오기" onclick="send(this.form);">
		<p id="name"></p>
		<p id="age"></p>
		<p id="addr"></p>
	</form>
</body>
</html>