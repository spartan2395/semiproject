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
			개인
		</div>
		<!-- 의사 -->
		<div class="tapView">
			<div class="docinfoView"></div>
			의사
		</div>
	</div>

</body>
</html>