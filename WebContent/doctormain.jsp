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
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<style type="text/css">
	.mainVisual{overflow: hidden; position: relative; min-width: 1280px; margin-right: 64px;}
	.main>.left{background: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ),url("image/doc_left.jpg") no-repeat center bottom; background-size: cover;}
	.main>.right{background: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ),url("image/doc_right.jpg") no-repeat center bottom; background-size: cover;}
	.mainVisual>div{position: absolute; top: 0; background-size: cover;}
	.main{display: table; position: absolute; top: 0; left: 0; z-index: 2; width: 100%; min-height: 500px;}
	.main>div{display: table-cell; position: relative;}
	.textbox{position: absolute; bottom: 50%; left: 60px; right: 60px; min-height:  150px; z-index: 1;}
	.textview{display:none; position: absolute; bottom: 0; left: 0; right: 0; z-index: 1; background: white;}
	.textview>a{text-decoration: none; color: #FE8633; display: block; position: relative; min-height: 100px; 
				padding: 28px 90px 20px 32px; border-bottom: 1px solid #FE8633; box-sizing: border-box;}
	.textbox>p{font-family: 서울남산 장체L; font-size: 60px; color: white;  }
	
	@font-face {
		font-family: "서울남산 장체L";
		src:url("font/서울남산 장체L.ttf") format("truetype");
		font-style: normal;
		font-weight: normal;
	}
	@font-face {
		font-family: "NANUMBARUNGOTHIC";
		src:url("font/NANUMBARUNGOTHIC.TTF") format("truetype");
		font-style: normal;
		font-weight: normal;
	}
	
</style>
<script type="text/javascript">
	
	
</script>
</head>
<body>
	<%@ include file="form/header.jsp" %>
	
	<div class="mainVisual">
		<div class="left" style="width: 50%; height:100%; left: 0%;">
		</div>
		<div class="right" style="width: 50%; height:100px; left: 50%">
		</div>
	</div>
	
	<div class="main" style="height: 100%;">
		<div class="left">
			<div class="textbox" style="top: 221.5px;">
				<p>내 병원 정보</p>
			</div>
			<div class="textview">
				<a href="hos_info.jsp">
					<h2>병원 정보</h2>
				</a>
				<a href="hos_update.jsp">
					<h2>정보 수정</h2>
				</a>
			</div>
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