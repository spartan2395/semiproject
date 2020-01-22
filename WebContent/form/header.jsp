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
<style type="text/css"></style>

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/main.js">

<script type="text/javascript">

$(function(){
	menuHeader();


function menuHeader(){
	$('#headerWrap .menu>ul>li>a').hover(function(){
		$(this).parent().addClass('on');
		$('#headerWrap').addClass('on');
		$('#headerWrap .menuDepth').not($(this).next('.menuDepth')).stop().hide();
		//$(this).next('.menuDepth').stop().slideDown('fast');
		$('.menuDepth').stop().slideDown('fast');
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
								<a href="">자유게시판</a>
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
								<a href="NoticeServlet?command=list">공지사항</a>
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
		<div class="bgDepth" style="display: none; height: 230px; padding-top: 0px; margin-top: 0px; 
		padding-bottom: 0px; margin-bottom: 0px;">
		</div>
	</header>

</body>
</html>