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
<style type="text/css">
	.helloDetail > p {font-size: medium;font-weight: bold;}
</style>
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
			<p>당근병원은 ‘당신 근처의 병원’이라는 뜻으로 의료소외계층을 포함한 모두가 가까운 곳에서 의료서비스를 사용 할 수 있게 만들고자 하는 마음으로 시작하였습니다. </p>
			<p>우리 사회에서는 고령화, 장애, 도서벽지 등의 이유로 의료서비스에 소외되는 집단의 문제가 끊임없이 화두 되고 있습니다. 이에 정부는 </p>
			<p>왕진 시범사업을 실행하기 시작하였고 저희도 이러한 사회적 움직임에 발 맞추어 의료소외계층에게 적합한 서비스를 시작하였습니다.</p>
			<p>저희 당근병원은 사회적 문제를 극복하고 의료서비스의 접근성을 높이도록 더욱 노력할 것을 약속드립니다.</p>

		</div>
	</div>
	

</body>
</html>



