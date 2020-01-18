<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.dochosinfoWrap{position: relative; width: 1000px; margin: 0 auto; padding-bottom: 130px; padding-top: 130 }
	.dochosinfoWrap h1{padding: 59px 0 58px; font-weight: 100px; font-size: 30px; line-height: 40px; color: orange; }

</style>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">
</head>
<body>
	<%@ include file="form/header.jsp" %>
	
	<div class="dochosinfoWrap">
		<h1>내 병원 정보</h1>
	</div>

</body>
</html>