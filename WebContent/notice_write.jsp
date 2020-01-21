<%@page import="com.lntegrated.notice.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	.noticeboardinsertWrap{width: 1000px; height:100% margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.noticeboardinsertWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>

</head>
<% NoticeDto dto = (NoticeDto)request.getAttribute("dto"); %>
<body>

<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="NoticeServlet?command=list">공지사항</a></li>
			<li><a href="InquiryServlet?command=list">1:1 문의</a></li>
			<li><a href="FAQ.jsp">FAQ</a></li>
		</ul>
	</div>
	
	<div class="noticeboardinsertWrap">
		<h1>공지사항 작성</h1>
			<form action="NoticeServlet" method="post">
			<input type="hidden" name="command" value="write">
				<table border="1">
					<colgroup>
						<col width="192px">
						<col width="*">
					</colgroup>	
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer"> </td>
					</tr>
					<tr>
						<th>병원이름</th>
						<td><input type="text" name="medical"> </td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea id = "editor_ck" rows="10" cols="60" name="content"></textarea> </td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="write"/>
							<input type="button" value="back" onclick="location.href='NoticeServlet?command=list'"/>
				</table>
			
			
			</form>
	
	</div>
	<script>
		CKEDITOR.replace('editor_ck', {
		});
	</script>
	
	
</body>
</html>