<%@page import="com.lntegrated.doctor.dto.DoctorDto"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="net.sf.json.JSON"%>
<%@page import="com.lntegrated.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" type="text/css" href="css/menu.css">
<style type="text/css">
.hiuser {
	width: 300px;
	height: 50px;
	float: right;
}

.hiuser h4 {
	color: white;
	padding-top: 10px;
	padding-left: 20px;
}
</style>

<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/main.js">
	
</script>
</head>

<body>

	<header id="headerWrap">
		<c:catch>
			<c:set var="id_u" value="${dto.id_u }"></c:set>
		</c:catch>
		<c:catch>
			<c:set var="id_d" value="${dto.id_d }"></c:set>
		</c:catch>
		<c:choose>
			<c:when test="${not empty id_u }">
				<a href="patientmain.jsp"> <img alt="메인으로" src="image/logo.png">
				</a>
			</c:when>
			<c:when test="${not empty id_d }">
				<a href="doctormain.jsp"> <img alt="메인으로" src="image/logo.png">
				</a>
			</c:when>
			<c:otherwise>
				<a href="login.html"> <img alt="메인으로" src="image/logo.png">
				</a>
			</c:otherwise>
		</c:choose>
		<nav class="menu">
			<ul>
				<li><a href="hello.jsp">사이트소개</a>
					<div class="menuDepth" style="display: none;">
						<ul>
							<li><a href="hello.jsp">인사말</a></li>
							<li><a href="site_info.jsp">당근병원 소개</a></li>
						</ul>
					</div></li>
				<li><a href="BoardFrServlet?command=boardlist">커뮤니티</a>
					<div class="menuDepth" style="display: none;">
						<ul>
							<li><a href="BoardFrServlet?command=boardlist">자유게시판</a></li>
							<li><a href="BoardShServlet?command=boardlist">병원정보공유</a></li>
						</ul>
					</div></li>
				<li><a href="#">고객센터</a>
					<div class="menuDepth" style="display: none;">
						<ul>
							<li><a href="NoticeServlet?command=list">공지사항</a></li>
							<li><a href="InquiryServlet?command=list">1:1 문의</a></li>
							<li><a href="FAQ.jsp">FAQ</a></li>
						</ul>
					</div></li>
			</ul>

		</nav>
		<div class="hiuser">

			<h4>
				안녕하세요
				<c:catch> ${dto.name_u}</c:catch>
				<c:catch> ${dto.name_d } </c:catch>
				님 당근병원입니다.
			</h4>
			<h4><a id="logout">로그아웃</a></h4>

		</div>
		<div class="bgDepth"
			style="display: none; height: 220px; padding-top: 0px; margin-top: 0px;">

		</div>
	</header>

</body>
</html>
