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

	.frboardinsertWrap{width: 1000px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.frboardinsertWrap h1{padding: 59px 0 58px; font-weight: 100; font-size: 30px; line-height: 40px;}
    .frboardinsertWrap h1 span{display: block; padding-bottom: 13px; font-size: 16px; color:orange; font-weight: 450;}
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
	
	<div class="frboardinsertWrap">
		<h1><span>자유게시판</span>새 글을 작성해 주세요</h1>
			<form action="BoardFrServlet" method="post">
				<input type = "hidden" name = "command" value = "insertres"/>
				<table>
					<colgroup>
						<col width="192px">
						<col width="*">
					</colgroup>	
						<tr>
							<th>ID</th>
							<td><input type = "text" name = "id_u" value = "788" readonly="readonly"/></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea id = "editor_ck" name="content"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input type="submit" value="작성">	
								<input type="button" value="취소" onclick="">	
							</td>
						</tr>
				
				
				</table>			
			</form>
	</div>
	<script>
		CKEDITOR.replace('editor_ck', {
		});
	</script>
	
	

</body>
</html>