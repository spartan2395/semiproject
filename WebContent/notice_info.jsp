<%@page import="com.lntegrated.notice.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	.noticeinfoboardWrap>h2{position: relative; width: 100%; font-size: 24px; color: #333; font-weight: 400;
						  float: left; line-height: 1.3; border-top: 1px solid #7e7e7e; background-color: #f9f9f9;
						  padding: 37px 27px 30px; word-break: break-all;}
	.noticeinfoboardWrap .meminfo{float: left; width: 100%; height: 35px; border-top: 1px solid #e3e3e3; border-bottom: 1px solid #e3e3e3;}
	.noticeinfoboardWrap .meminfo span{float: left; margin-left: 17px; height: 100%; font-size: 13px; margin-top: 7px;}
	.noticeinfoboardWrap .meminfo span img{height: 20px; width: 20px; margin-right: 8px;}
	.noticeinfoboardWrap .meminfo .sysinfo{float: right;}
	.noticeinfoboardWrap .meminfo .sysinfo p{float: left; font-size: 12px; color: #aaa; margin-right: 25px; line-height: 1; margin-top: 10px;}
	.noticeinfoboardWrap .meminfo .sysinfo p img{margin-right: 4px; vertical-align: middle; margin-bottom: 2px;}
	.noticeinfoboardWrap .meminfo .sysinfo p.last{margin-right: 27px;}
	.noticeinfoboardWrap .text{float: left; width: 1000px; margin-top: 40px; margin-left: 27px; font-size: 16px;
   							 color: #333; line-height: 26px;margin-bottom: 40px; word-break: break-all; display: block;}
	.noticeinfoboardWrap .text>button{border: 1px solid orange; background-color: rgba(0,0,0,0);color: orange; padding:20px; position: relative; left: 400px; top: 90px;}
	.noticeinfoboardWrap .text>button:hover{background-color: orange;color: white;}
	.btn_group > input{margin-top:8%; border: 1px solid orange; background-color: rgba(0,0,0,0); color: orange; padding: 5px; position:relative; top: 90px;}
	.btn_group > input:hover{background-color: orange; color: white;}
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
				<button onclick="location.href='NoticeServlet?command=boardlist'">목록</button>
				</div>
				
				<div class="btn_group" align="right">
					<input type = "button" value="수정" onclick="location.href='NoticeServlet?command=updateform&nt_seq=<%=list.getNt_seq()%>&id_d=${dto.id_d }'">
					<input type = "button" value="목록" onclick = "location.href = 'BoardFrServlet?command=delete&board_no=<%=list.getNt_seq()%>&id_d=${dto.id_d }'">
				</div>
		</div>
	</div>
	<%@ include file="./form/footer.jsp" %>

</body>
</html>
