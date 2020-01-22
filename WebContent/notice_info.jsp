<%@page import="com.lntegrated.notice.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">
	.noticeinfoboardWrap{width: 1000px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.noticeinfoboardWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>
</head>
<% NoticeDto dto = (NoticeDto)request.getAttribute("dto"); %>
<body>

<%@ include file="form/header.jsp" %>
	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="noticelist.jsp">공지사항</a></li>
			<li><a href="#">1:1 문의</a></li>
			<li><a href="#">FAQ</a></li>
		</ul>
	</div>
	
	<div class="noticeinfoboardWrap">
		<h1>공지사항</h1>
			<table border="1">
				<colgroup>
						<col width="192px">
						<col width="*">
					</colgroup>
				<tr>
					<th>병원이름</th>
					<td><%=dto.getMedical_d() %></td>
				</tr>
				<tr>
				<tr>
					<th>병원이름</th>
					<td><%=dto.getName_d() %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=dto.getTitle() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="">
						<input type="button" value="삭제" onclick="">
						<input type="button" value="목록" onclick="location.href='NoticeServlet?command=list'">
			</table>
	
	</div>


</body>
</html>