<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert form</title>
<script>
	function send(f){
		let photo = f.photo.value;
		if(photo == ''){
			alert("사진을 추가하세요");
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<form method="POST" enctype="multipart/form-data" action="upload.do">
		제목 : <input name="title"><br>
		사진 : <input type="file" name="photo"><br>
		<input type="button" value="전송" onclick="send(this.form);">
	</form>
</body>
</html>