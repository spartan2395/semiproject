<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/menu.css">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>

</head>
<body>

<%@ include file="form/header.jsp" %>

	<div class="headMenu">
		<h1>사이트소개</h1>
		<ul>
			<li><a href="hello.jsp">인사말</a></li>
			<li><a href="site_info.jsp">당근병원소개</a></li>
		</ul>
	</div>
	
	<div class="helloWrap">
		<h1><span>인사말</span>당근병원에 오신것을 환영합니다.</h1>
		<div class="helloView">
			<h2>The Hospital near You</h2>
			<p>당신 근처의 병원</p>
		</div>
		<div class="helloDetail">
			<p>대충 당근병원좋다는글~~~~</p>
		</div>
	</div>
	

</body>
</html>



