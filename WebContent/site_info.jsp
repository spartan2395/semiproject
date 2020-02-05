<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/menu.css?after">
<link rel="stylesheet" type="text/css" href="css/reset.css">

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">

$(function(){
	tapBox();

	function tapBox(){
		if($('.infoTap').length != 0){
			$('.infoTap li a').click(function(){
				if($(this).closest('.infoTap').siblings('.tapView').length){
					var idx = $(this).parent().index();
					$(this).parent().addClass('on').siblings().removeClass('on');
					$(this).closest('.infoTap').siblings('.tapView').eq(idx).show().siblings('.tapView').hide();
					return false;
				}
			});		
		};
	};
	
});
</script>
<style type="text/css">
	
	.indiinfoView {margin-bottom: 20px;}
	.docinfoView {margin-bottom: 20px;}
	.tapView >p { font-size: medium; font-weight: bold;}
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
	
	<div class="siteinfoWrap">
		<h1><span>당근병원소개</span>당근병원을 소개합니다.</h1>
		<div class="infoTap">
			<ul>
				<li class="on">
					<a href="#">
						개인을 위한 당근병원
					</a>
				</li>
				<li>
					<a href="#">
						의사를 위한 당근병원
					</a>
				</li>
			</ul>
		</div>
		
		<!-- 개인 -->
		<div class="tapView" style="display: block;">
			<div class="indiinfoView"></div>
			<p>당신의 위치 기준으로 병원정보를 나타내 주고 위치지도로 손쉬운 위치 확인이 가능합니다. </p>
			<p>병원에 직접 방문하기 어려운 당신을 위해 방문 전 병원에 대한 정보를 미리 확인할 수 있고 왕진진료와 원격진료를 신청하여 병원에 방문할 필요 없이 진료를 받을 수 있습니다.
			</p>
		</div>
		<!-- 의사 -->
		<div class="tapView">
			<div class="docinfoView"></div>
			<p>환자에게 병원에 대한 정확한 정보를 전달할 수 있으며 예약일정, 진료정보를 데이터화하여 손쉽게 사용 할 수 있습니다. </p>
		</div>
	</div>

</body>
</html>