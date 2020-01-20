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

	.frboardselectWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.frboardselectWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.frboardselectWrap>h2{position: relative; width: 100%; font-size: 24px; color: #333; font-weight: 400;
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
	.frboardselectWrap .text>button{border: 1px solid orange; background-color: rgba(0,0,0,0);color: orange; padding:20px; position: relative; left: 350px; top: 90px;}
	.frboardselectWrap .text>button:hover{background-color: orange;color: white;}
	.btn_group button{border: 1px solid orange; background-color: rgba(0,0,0,0); color: orange; padding: 5px; position:relative; top: 90px;}
	.btn_group button:hover{background-color: orange; color: white;}
	.reply_wrap{float: left; width: 100%; position: relative; top: 110px;}
	.reply_title{float: left; width: 100%; height: 44px; 
				 border-top: 1px solid #e3e3e3;background-color: #f9f9f9;line-height: 45px;}
	.reply_title h2 {float: left;margin-left: 27px;font-size: 16px;color: #333333;}
	.reply_title h2 span {font-size: 16px; color: #f68400; margin-left: 5px;}
	.reply_wrap .reply_ul{float: left; width: 100%;}
	.reply_wrap .bottom_reply{float: left; margin-top: 40px; width: 100%; height: 205px; background-color: #e8eaee;
   							  border: 1px solid #dcdde1;}
   	.reply_wrap .bottom_reply .txar {float: left;padding: 20px; width: 868px;height: 90px; margin-top: 10px;
    								 margin-left: 10px;background-color: #fff; resize: none; overflow: hidden; overflow-y: auto;}
	.reply_wrap .btn01_g{min-width: 53px; font-size: 16px; color: #fff !important; text-align: center; background-color: #747a86;
						 border-radius: 2px; padding: 9px 17px 9px 17px; border: 1px solid #747a86; display: inline-block; line-height: 1; float: right;
						 position: relative; top: 10px; right: 10px;}
	
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
		
		<h2>${dto.title }</h2>
		<div class="meminfo">
			<span>${dto.id_u }</span>
			<div class="sysinfo">
				<p>
					<img alt="조회수" src="image/eye_new.png">
					${dto.views }
				</p>
				<p class="last">
					<img alt="작성시간" src="image/sub_date_new.png">
					${dto.regdate }
				</p>
			</div>
		</div>
		<div class="text">
			<p>${dto.content }</p>
			<button>목록</button>
		</div>
		<div class="btn_group" align="right">
			<button>수정</button>
			<button>삭제</button>
		</div>
		<div class="reply_wrap">
			<div class="reply_title">
				<h2>댓글 <span>댓글개수</span></h2>
			</div>
			<ul class="reply_ul">
			
			</ul>
			<div class="bottom_reply">
				<textarea rows="10" cols="30" class="txar" name="comment"></textarea>
				<span><a class="btn01_g" href="">등록</a></span>
			</div>
			
		</div>
		
		
	</div>

</body>
</html>