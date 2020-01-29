<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src= "/semi_prj/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">
	.videochatWrap{width: 80%; height:100% margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.videochatWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	
</style>

</head>
<body>
<%@ include file="./form/header.jsp" %>
	<div class="videochatWrap">
		<h1>원격진료</h1>
			<div class="video" style="background: red; widows:80%; height: 70%"></div>
	</div>
	
<%@ include file="./form/footer.jsp" %>
</body>
</html>