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
<script type="text/javascript" ></script>


</head>
<%
	List<NoticeDto> list = (List)request.getAttribute("list");
%>
<body>

<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="#">공지사항</a></li>
			<li><a href="#">1:1 문의</a></li>
			<li><a href="#">FAQ</a></li>
		</ul>
	</div>
	
	<div class="middle">
		<h1><span>공지사항</span>notice</h1>
		<div>
			<table border="1">
				<col width="50px"/>
				<col width="100px"/>
				<col width="100px"/>
				<col width="300px"/>
				<col width="100px"/>
				
				<tr>
					<th>번호</th>
					<th>진료과목</th>
					<th>병원이름</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
				
<%
	if(list.size() == 0) {
%>		
				<tr>
					<td colspan="5">**작성된 글이 없습니다.**</td>
				</tr>	
<%
	}else{
		
		for(int i = 0; i <list.size(); i++) {
%>		
				<tr>
					<td><%=list.get(i).getNt_seq() %></td>		
					<td><%=list.get(i).getDepartment() %></td>		
					<td><%=list.get(i).getMedical_d() %></td>		
					<td><%=list.get(i).getTitle() %></td>		
					<td><%=list.get(i).getRegdate() %></td>	
					
<%
		}
		
	}
%>		
				<tr>
					<td colspan="5" align="right">
						<button onclick="">글쓰기</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
</body>
</html>