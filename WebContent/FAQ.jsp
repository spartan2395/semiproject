<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">
	.FAQlist{width: 1000px; height:100%;  margin: 0 auto; padding: 0 80px 160px; margin-top: 130px; }
	.FAQlist h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.acodian_area {position: relative;}
	.acodian_area ul {margin: 0; padding: 0; list-style: none; border-bottom: 1px solid #ddd;}
	.acodian_area .aco_li {position: relative; margin: 0; border-top: 1px solid #ddd;}
	.acodian_area .hide .aco_li a.trigger {padding: 14px 350px 14px 30px; background: none; line-height: 22px;}
	.acodian_area .aco_li a.trigger {display: block; padding: 14px 350px 14px 30px; background: #f9f9f9; text-align: left; line-height: 30px;}
	.acodian_area .aco_li a.trigger:hover {background: #f9f9f9;}
	
	
	
</style>

</head>
<body>
<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="NoticeServlet?command=boardlist">공지사항</a></li>
			<li><a href="InquiryServlet?command=boardlist">1:1 문의</a></li>
			<li><a href="FAQ.jsp">FAQ</a></li>
		</ul>
	</div>
	
	<div class="FAQlist">
		<h1>FAQ</h1>
			<div class="acodian_area">
				<ul>
					<li class="article hide">
						<div class="aco_li">
							<a class="trigger">자주묻는질문1</a>
						</div>
						<div class="aco_view" style="display: none;">
							<p>자주답변하는답변1</p>
						</div>
					</li>
					<li class="article hide">
						<div class="aco_li">
							<a class="trigger">자주묻는질문2</a>
						</div>
						<div class="aco_view" style="display: none;">
							<p>자주답변하는답변2</p>
						</div>
					</li>
					<li class="article hide">
						<div class="aco_li">
							<a class="trigger">자주묻는질문3</a>
						</div>
						<div class="aco_view" style="display: none;">
							<p>자주답변하는답변3</p>
						</div>
					</li>
					<li class="article hide">
						<div class="aco_li">
							<a class="trigger">자주묻는질문4</a>
						</div>
						<div class="aco_view" style="display: none;">
							<p>자주답변하는답변4</p>
						</div>
					</li>
				</ul>
			
			</div>
	</div>
		<%@ include file="./form/footer.jsp" %>

</body>
<script type="text/javascript">
	var article = $('arcodian_area .article');
	article.addClass('hide');
	article.find('.aco_view').slideUp(0);
	$('.acodian_area .article .trigger').click(function () {
		var myArticle = $(this).parents('.article:first');
		if(myArticle.hasClass('hide')){
			article.addClass('hide').removeClass('show');
			article.find('.aco_view').slideUp(100);
			myArticle.removeClass('hide').addClass('show');
			myArticle.find('.aco_view').slideDown(100);
		}else{
			myArticle.removeClass('show').addClass('hide');
			myArticle.find('.aco_view').slideUp(100);
		}
	});
</script>


</html>