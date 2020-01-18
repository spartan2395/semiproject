<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>

	
<script type="text/javascript">
	
	
</script>
</head>
<body>
	<%@ include file="form/header.jsp" %>
	
	<div class="mainVisual">
		<div class="left" style="width: 50%; height:100%; left: 0%;">
			<span id="left2" style=""></span>
		</div>
		<div class="right" style="width: 50%; height:100px; left: 50%">
		</div>
	</div>
	
	<div class="main" style="height: 100%;">
		<div class="left">
			<div class="textbox" style="top: 221.5px;">
				<p>내 병원 정보</p>
			</div>
<!--		<div class="textview">
				<a href="hos_info.jsp">
					<h2>병원 정보</h2>
				</a>
				<a href="hos_update.jsp">
					<h2>정보 수정</h2>
				</a>
			</div>		-->
		</div>
		<div class="right">
			<div class="textbox" style="top: 221.5px;">
				<p>예약 확인</p>
			</div>
			<div class="textview">
				<a href="calendar.jsp">
					<h2>예약 일정</h2>
				</a>
				<a href="">
					<h2>원격 진료</h2>
				</a>
				<a href="">
					<h2>환자 관리</h2>
				</a>
			</div>
		</div>
	</div>
	
	

</body>
</html>