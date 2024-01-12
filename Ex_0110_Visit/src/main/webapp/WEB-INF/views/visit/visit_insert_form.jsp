<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		let name = f.name.value;
		if (name == '') {
			alert("작성자 이름을 입력하세요");
			return;
		}
		f.action = "insert.do";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<table border="1" align="center">
			<caption>:::새 글 작성:::</caption>
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="pwd" name="pwd"></td>
			</tr>
			<tr>
				<th>내용</th>
				<!-- wrap : textarea에서 글이 길어져 자동으로 다음줄로 넘어갔을 때 이것을 엔터값으로 인지하도록 함 -->
				<td><textarea name="content" rows="5" cols="50"
						style="resize: none;" wrap="on"></textarea></td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td><input type="file" name="photo"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="글쓰기"
					onclick="send(this.form);"> <input type="button"
					value="목록으로" onclick="history.go(-1);"></td>
			</tr>
		</table>
	</form>
</body>
</html>