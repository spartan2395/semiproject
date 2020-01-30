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
	.telmediWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.telmediWrap h1{padding: 59px 0 30px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	
</style>

</head>
<body>
<%@ include file="./form/header.jsp" %>
	<div class="headMenu">
		<h1>예약 확인</h1>
		<ul>
			<li><a href="calendarServlet?command=doc_schedule&id_d=nexon">예약 일정</a></li>
			<li><a href="">원격 진료</a></li>
			<li><a href="">환자 관리</a></li>
		</ul>
	</div>
	<div class="telmediWrap">
		<h1>원격 진료</h1>
	
	
	</div>
	
	
<%@ include file="./form/footer.jsp" %>
</body>
</html>