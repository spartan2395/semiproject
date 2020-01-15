<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MemberServlet" method="post">
		<input type = "text" name = "id">
		<input type = "text" name = "pw">
		<input type = "text" name ="name">
		<input type = "text" name="gender">
		<input type = "text" name = "number">
		<input type = "text" name = "addr">
		<input type = "text" name = "email">
		<input type = "submit" value = "전송">
		<input type = "reset" value = "취소">
	</form>
</body>
</html>