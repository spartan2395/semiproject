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
	.hos_infoWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.hos_infoWrap h1{padding: 59px 0 30px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.hos_infoWrap .hos_info{background-color: orange; width: 100%; height: 800px;}

</style>
</head>
<body>
<%@ include file="form/header.jsp" %>
	<div class="headMenu">
	</div>
	
	<div class="hos_infoWrap">
		<h1>내 병원 정보</h1>
		
		<div class="hos_info">
		
		</div>
		
	</div>

</body>
</html>