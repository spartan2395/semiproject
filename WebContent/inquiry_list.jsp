<%@page import="com.lntegrated.inquiry.dto.InquiryDto"%>
<%@page import="java.util.List"%>
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
	.inquiryboardWrap{width: 1000px; height:100%;  margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.inquiryboardWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>

</head>
<% List<InquiryDto> list = (List<InquiryDto>)request.getAttribute("list"); %>
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
		<div>
			<table border="1">
				<colgroup>
						<col width="192px">
						<col width="*">
				</colgroup>	
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
<%
	if(list == null || list.size() ==0) {
%>

				<tr>
					<td colspan="4">----------작성된 글이 없습니다.----------</td>
				</tr>			
<%
	}else{
		for(int i =0; i < list.size(); i++) {
%>	
				<tr>
					<td><%=list.get(i).getBoard_no() %></td>
					<td><%=list.get(i).getId_u() %></td>
					<td><a href="InquiryServlet?command=one&no=<%=list.get(i).getBoard_no() %>"><%=list.get(i).getTitle() %></a></td>
					<td><%=list.get(i).getRegdate() %></td>
				</tr>
<%
		}
	}
%>
				<tr>
					<td colspan="4" align="right">
						<button onclick="location.href='InquiryServlet?command=writeform'">글쓰기</button>
			</table>
		</div>
	</div>

</body>
</html>