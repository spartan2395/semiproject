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
<script type="text/javascript" src= "/semi_prj/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">
<style type="text/css">

	.frboardinsertWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.frboardinsertWrap h1{padding: 59px 0 58px; font-weight: 100; font-size: 30px; line-height: 40px;}
    .frboardinsertWrap h1 span{display: block; padding-bottom: 13px; font-size: 16px; color:orange; font-weight: 450;}
	.frboardinsertWrap .boardtitle{width: 100%; height: 60px; float: left; background-color: #f9f9f9;
								   border-top: 1px solid #7e7e7e;}
	.frboardinsertWrap .board_title_input{width: 874px;height: 32px;border: 1px solid #e6e6e6;line-height: 32px;
    					padding-left: 13px; font-size: 16px; color: #666666; margin-top: 13px; margin-left: 27px;}							   
	.frboardinsertWrap .boardcontent{position: relative;border: 1px solid #e3e3e3; border-left: none; 
									   height: 550px; float:left; background-color: #fff;
   									   border-right: none; background-color: #ffffff; margin: 0 auto; width: 100%; }
	.frboardinsertWrap .btn_wrap{width: 100%;float: left;margin-top: 20px;text-align: center; height: 42px;
    								padding-bottom: 180px; }
    .frboardinsertWrap .btn_wrap button:nth-of-type(1){min-width: 53px; font-size: 16px; color: #fff; text-align: center;
   					 background-color: #747a86; border-radius: 2px;padding: 12px 16px 12px 16px;border: 1px solid #747a86;display: inline-block; line-height: 1;}			
    .frboardinsertWrap .btn_wrap button:nth-of-type(2){min-width: 53px;font-size: 16px;color: #fff;text-align: center; background-color: orange;
    				border-radius: 2px;padding: 12px 16px 12px 16px; border: 1px solid orange;display: inline-block; line-height: 1;}
	

</style>
</head>
<body>
	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>커뮤니티</h1>
		<ul>
			<li><a href="BoardFrServlet?command=boardlist">자유게시판</a></li>
			<li><a href="BoardShServlet?command=boardlist">병원정보공유</a></li>
		</ul>
	</div>
	
	<div class="frboardinsertWrap">
		<h1><span>자유게시판</span>새 글을 작성해 주세요</h1>
			<form action="BoardFrServlet" method="post">
				<input type = "hidden" name = "command" value = "insertres"/>
				<input type="hidden" name="id_u" value="788">
				<div class="boardtitle">
					<input type="text" name="title" required="required" class="board_title_input" placeholder="제목을 입력해주세요">
				</div>
				<div class="boardcontent">
					<textarea class="editWindow" name="content" id="editor_ck" rows="9" cols="40" style="display: none;"></textarea>
				</div>
				<div class="btn_wrap">
					<button>취소</button>
					<button type="submit">등록</button>
				</div>
							
			</form>
	</div>
	<script>
		CKEDITOR.replace('editor_ck', {
			height: 450
		});
	</script>
	
	

</body>
</html>