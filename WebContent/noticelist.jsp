<%@page import="com.lntegrated.notice.dto.NoticeDto"%>
<%@page import="com.lntegrated.notice.dao.NoticeDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");%>
<%	response.setContentType("text/html; charset=UTF-8");%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	.headMenu{position: relative; top: 30%;}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">
	.noticeboardWrap{width: 1000px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.noticeboardWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>

</head>
<%
	//NoticeDao dao = new NoticeDao();
//	List<NoticeDto> list = dao.notice_List();
	List<NoticeDto> list = (List<NoticeDto>)request.getAttribute("list");
%>
<body>

<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="noticelist.jsp">공지사항</a></li>
			<li><a href="#">1:1 문의</a></li>
			<li><a href="#">FAQ</a></li>
		</ul>
	</div>
	
	<div class="noticeboardWrap">
		<h1>공지사항</h1>
		<div>
			<table border="1">
				<col width="50px"/>
				<col width="100px"/>
				<col width="100px"/>
				<col width="300px"/>
				<col width="100px"/>
				
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>병원이름</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
				
<%
	if(list == null || list.size() == 0) {
%>		
				<tr>
					<td colspan="5" >---------작성된 글이 없습니다.---------</td>
				</tr>	
<%
	}else{
		
		for(int i = 0; i <list.size(); i++) {
%>		
				<tr>
					<td><%=list.get(i).getNt_seq() %></td>		
					<td><%=list.get(i).getId_d() %></td>		
					<td><%=list.get(i).getMedical_d() %></td>		
					<td><a href="NoticeServlet?command=one&nt_seq=<%=list.get(i).getNt_seq() %>"><%=list.get(i).getTitle() %></a></td>	
					<td><%=list.get(i).getRegdate() %></td>	
					
<%
		}
		
	}
%>		
				<tr>
					<td colspan="5" align="right">
						<button onclick="location.href='NoticeServlet?command=writeform'">글쓰기</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
</body>
</html>