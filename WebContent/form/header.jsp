<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<style type="text/css">

	#headerWrap{width: 100%; height: 94px; background: none; transistion: background .3s ease; z-index: 10; position: absolute;}
	#headerWrap.on { background:rgba(33,32,30,0.85);}
	#headerWrap a img{float: left; width: 151px; height: 34px; margin-top: 30px; margin-left: 30px;}
	#headerWrap .menu{float: left; position: relative; margin-top: 25px; margin-left: 45px;}
	#headerWrap .menu>ul>li{float: left; margin-right: 50px;}
	#headerWrap .menu > ul > li > a { color:orange; font-size:18pt; line-height:55px;}
	#headerWrap .menuDepth{margin-top: 20px;}
	#headerWrap .menuDepth ul>li>a{color: white; font-size: 12pt; padding-top: 15px;}
	#headerWrap .bgDepth {top: 94px; background: rgba(33,32,30,0.85);}

</style>
<script type="text/javascript">

$(function(){
	menuHeader();


function menuHeader(){
	$('#headerWrap .menu>ul>li>a').hover(function(){
		$(this).parent().addClass('on');
		$('#headerWrap').addClass('on');
		$('#headerWrap .menuDepth').not($(this).next('.menuDepth')).stop().hide();
		$(this).next('.menuDepth').stop().slideDown('fast');
		$('#headerWrap .bgDepth').stop().slideDown('fast');
		
	});
	
	$('#headerWrap .menu').mouseleave(function(){
		gnbNone();
	});
	
	function gnbNone(){
		$('#headerWrap .menu > ul > li').removeClass('on');
		$('#headerWrap .menuDepth').stop().slideUp('fast');
		// $('#headerWrap .menuDepth').hide();
		$('#headerWrap .bgDepth').stop().slideUp('fast');
		$('#headerWrap').removeClass('on');
	}
	
}
});
	

</script>
</head>
<body>
	
	<header id="headerWrap">
			<a href="#">
				<img alt="메인으로" src="image/logo.png">
			</a>
		<nav class="menu">
			<ul>
				<li>
					<a href="#">사이트소개</a>
					<div class="menuDepth" style="display: none;">
							<ul>
								<li>
									<a href="#">인사말</a>
								</li>
								<li>
									<a href="#">당근병원 소개</a>
								</li>
							</ul>
					</div>
				</li>
				<li>
					<a href="#">커뮤니티</a>
					<div class="menuDepth" style="display: none; ">
						<ul>
							<li>
								<a href="#">자유게시판</a>
							</li>
							<li>
								<a href="#">병원정보공유</a>
							</li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#">고객센터</a>
					<div class="menuDepth" style="display: none;">
						<ul>
							<li>
								<a href="#">공지사항</a>
							</li>
							<li>
								<a href="#">1:1 문의</a>
							</li>
							<li>
								<a href="#">FAQ</a>
							</li>
						</ul>
					</div>
				</li>
			</ul>		
		</nav>
		<div class="bgDepth" style="display: none; height: 200px; padding-top: 0px; margin-top: 0px; 
		padding-bottom: 0px; margin-bottom: 0px;">
		</div>
	</header>

</body>
</html>