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

	.frboardselectWrap{width: 1000px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.frboardselectWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.frboardselectWrap h2{position: relative; width: 100%; font-size: 24px; color: #333; font-weight: 400;
						  float: left; line-height: 1.3; border-top: 1px solid #7e7e7e; background-color: #f9f9f9;
						  padding: 37px 27px 30px; word-break: break-all;}
	.frboardselectWrap .meminfo{float: left; width: 100%; height: 35px; border-top: 1px solid #e3e3e3; border-bottom: 1px solid #e3e3e3;}
	.frboardselectWrap .meminfo span{float: left; margin-left: 27px; height: 100%; font-size: 13px;}
	.frboardselectWrap .meminfo .sysinfo{float: right;}
	.frboardselectWrap .meminfo .sysinfo p{float: left; font-size: 12px; color: #aaa; margin-right: 25px; line-height: 1; margin-top: 10px;}
	.frboardselectWrap .meminfo .sysinfo p img{margin-right: 4px; vertical-align: middle; margin-bottom: 2px;}
	.frboardselectWrap .meminfo .sysinfo p.last{margin-right: 27px;}
	.frboardselectWrap .text{float: left; width: 1000px; margin-top: 40px; margin-left: 27px; font-size: 16px;
   							 color: #333; line-height: 26px;margin-bottom: 40px; word-break: break-all; display: block;}
	
</style>
</head>
<body>
	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>커뮤니티</h1>
		<ul>
			<li><a href="">자유게시판</a></li>
			<li><a href="">약제정보공유</a></li>
		</ul>
	</div>
	
	<div class="frboardselectWrap">
		<h1>자유게시판</h1>
		
		<h2>글제목 넣어주세요</h2>
		<div class="meminfo">
			<span>아이디자리</span>
			<div class="sysinfo">
				<p>
					<img alt="조회수" src="image/eye_new.png">
					조회수자리
				</p>
				<p class="last">
					<img alt="작성시간" src="image/sub_date_new.png">
					시간자리
				</p>
			</div>
		</div>
		<div class="text">
			<p>글내용</p>
			
		</div>
		
		
	</div>

</body>
</html>