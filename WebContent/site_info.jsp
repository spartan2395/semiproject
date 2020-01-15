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
	.siteinfoWrap .infoTap{margin-bottom: 48px;}
	.infoTap ul{display: table; height: 48px; overflow: hidden; width: 100%; table-layout: fixed; border-left: 1px solid #e6e3df; }
	.infoTap li{display: table-cell; height: 48px; vertical-align: top;}
	.infoTap li.on a{color: #FFE09D; border-bottom-color: transparent; border-top: 1px solid #FFE09D; }
	.infoTap li a{display: block; position: relative; height: 48px; padding: 12px 0; border-top: 1px solid #e6e3df;
				  border-bottom: 1px solid #FFE09D; line-height: 22px; text-align: center; color: #666; vertical-align: top;}
	.infoTap li.on a:before{content: ''; display: block; position: absolute; top: 0; left: 0;
							bottom: -1px; width: 1px; background: #FFE09D;}
	.infoTap li.on a:after{content: ''; display: block; position: absolute; top: 0; right: 0;
							bottom: -1px; width: 1px; background: #FFE09D;}
	.infoTap li a:after{content: ''; display: block; position: absolute; top: 0; right: 0; bottom: 0; width: 1px; background:#e6e3df;}
	.tapView{display: none;}	
	.siteinfoWrap .indiinfoView{background: linear-gradient(to right, rgba(108, 127, 61, 0.8),  rgba(255, 255, 255, 0)),
   									  url("image/indi_info_img.jpg") no-repeat center;
						  background-size: 1000px 302px; height: 302px; padding: 84px 0 0 40px;}
	
	
</style>
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
					$(this).closest('.infoTap').siblings('.tapView').eq(idx).find('.slick-slider').slick('reinit');
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
			<li><a href="">인사말</a></li>
			<li><a href="">당근병원소개</a></li>
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
			의사
		</div>
	</div>

</body>
</html>