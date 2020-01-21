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
	.frboardupdateWrap{width: 1000px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.frboardupdateWrap h1{padding: 59px 0 58px; font-weight: 100; font-size: 30px; line-height: 40px;}
    .frboardupdateWrap h1 span{display: block; padding-bottom: 13px; font-size: 16px; color:orange; font-weight: 450;}

</style>
</head>
<body>

<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>커뮤니티</h1>
		<ul>
			<li><a href="">자유게시판</a></li>
			<li><a href="">병원정보공유</a></li>
		</ul>
	</div>
	
	<div class="frboardupdateWrap">
		<h1><span>자유게시판</span>수정하는중입니다</h1>
			<form action="BoardFrServlet" method="post">
				<input type = "hidden" name = "command" />
				<input type = "hidden" name = "board_no" />
				<table>
					<colgroup>
						<col width="192px">
						<col width="*">
					</colgroup>	
						<tr>
							<th>ID</th>
							<td><input type = "text" name = "id_u" value = "${dto.id_u }" readonly="readonly"/></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" required="required" value="${dto.title }" ></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea id = "editor_ck" name="content" required="required">${dto.content }</textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input type="submit" value="수정완료">	
								<input type="button" value="취소" onclick="">	
							</td>
						</tr>
				
				
				</table>			
			</form>
	</div>
	<script>
	
	</script>
	

</body>
</html>