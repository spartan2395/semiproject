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
<style type="text/css">
	#headerWrap{width: 100%; height: 94px; background: none; transistion: background .3s ease; z-index: 10; position: absolute;}
	#headerWrap.on { background:rgb(255,224,157);}
	#headerWrap a img{float: left; width: 151px; height: 34px; margin-top: 30px; margin-left: 3%;}
	#headerWrap .menu{float: left; position: relative; margin-top: 25px; margin-left: 45px;}
	#headerWrap .menu>ul>li{float: left; margin-right: 50px;}
	#headerWrap .menu > ul > li > a { color:orange; font-size:18pt; line-height:55px;}
	#headerWrap .menuDepth{margin-top: 20px;}
	#headerWrap .menuDepth ul>li>a{color: white; font-size: 12pt; padding-top: 15px;}

</style>

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/main.js">


	


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