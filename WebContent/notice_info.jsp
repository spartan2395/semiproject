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
	.noticeinfoboardWrap{width: 1000px; height:100%; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.noticeinfoboardWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>
</head>
<% NoticeDto list = (NoticeDto)request.getAttribute("dto"); %>
<body>

<%@ include file="form/header.jsp" %>
	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="NoticeServlet?command=list">공지사항</a></li>
			<li><a href="InquiryServlet?command=list">1:1 문의</a></li>
			<li><a href="FAQ.jsp">FAQ</a></li>
		</ul>
	</div>

	<div class="noticeinfoboardWrap">
		<h1>공지사항</h1>
		<h2><%=list.getTitle() %></h2>
			<div class="meminfo">
				<span><img alt="" src="image/happycarrot.png">${dto.id_d }</span>
				<div class="sysinfo">
					<p>
						<img alt="조회수" src="image/eye_new.png">
						<%=list.getViews() %>
					</p>
					<p class="last">
						<img alt="작성시간" src="image/sub_date_new.png">
						<fmt:formatDate value="<%=list.getRegdate() %>" pattern="yyyy.MM.dd a hh:mm"/>
					</p>
				</div>
				
				<div class="text">
				<p><%=list.getContent() %></p>
				<button onclick="location.href='NoticeServlet?command=list'">목록</button>
				</div>
				
				<div class="btn_group" align="right">

					<button type = "button" onclick="location.href='NoticeServlet?command=updateform&nt_seq=<%=list.getNt_seq()%>&id_d=${dto.id_d }'">수정</button>
					<button type = "button" onclick = "location.href = 'BoardFrServlet?command=delete&board_no=<%=list.getNt_seq()%>&id_d=${dto.id_d }'">삭제</button>

		</div>

	</div>
	<%@ include file="./form/footer.jsp" %>

</body>
</html>
