<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">
<style type="text/css">

	.infoboardWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.infoboardWrap h1{padding: 59px 0 30px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}

</style>
</head>
<body>

	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>커뮤니티</h1>
		<ul>
			<li><a href="">자유게시판</a></li>
			<li><a href="">병원정보공유</a></li>
		</ul>
	</div>
	
	<div class="infoboardWrap">
		<h1>병원정보공유</h1>
		<!-- 병원으로 검색 -->
		
	</div>
	

</body>
</html>