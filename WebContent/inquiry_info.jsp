<%@page import="com.lntegrated.inquiry.dto.InquiryDto"%>
<%@page import="com.lntegrated.inquiry.dao.InquiryDao"%>
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
	.inquiryinfoWrap{width: 1000px; height:100%;  margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.inquiryinfoWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>
</head>
<% InquiryDto dto = (InquiryDto)request.getAttribute("dto"); %>
<body>

<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="NoticeServlet?command=list">공지사항</a></li>
			<li><a href="InquiryServlet?command=list">1:1 문의</a></li>
			<li><a href="#">FAQ</a></li>
		</ul>
	</div>
	
	<div class="inquiryboardWrap">
		<h1>1:1문의</h1>
			<table border="1">
				<colgroup>
					<col width="192px">
					<col width="*">
				</colgroup>
				<tr>
					<th>작성자</th>
					<td><%=dto.getId_u() %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=dto.getTitle() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="60" readonly="readonly"> <%=dto.getContent() %></textarea></td>
				</tr>
				<tr>
					<td>
						<input type="button" value="수정" onclick="location.href='InquiryServlet?command=updateform&no='<%=dto.getBoard_no()%>">
						<input type="button" value="답글작성" onclick="location.href='InquiryServlet?command=answer'">
						<input type="button" value="목록" onclick="location.href='InquiryServlet?command=list'">
					</td>
				</tr>
			</table>
	</div>
</body>
</html>