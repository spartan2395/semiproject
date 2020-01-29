<%@page import="com.lntegrated.inquiry.dto.InquiryDto"%>
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
	.inquiryupdateWrap{width: 1000px; height:100%; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.inquiryupdateWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>
</head>
<% InquiryDto dto = (InquiryDto)request.getAttribute("dto"); %>
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
	<div class="inquiryupdateWrap">
		<h1>1:1문의 수정</h1>
			<form action="InquiryServlet" method="post">
			<input type="hidden" name="command" value="update"/>
			<input type="hidden" name="no" value="<%=dto.getBoard_no() %>"/>
				<table border="1">
					<colgroup>
						<col width="192px">
						<col width="*">
					</colgroup>
						<tr>
							<th>작성자</th>
							<td><input type="text" name="writer" value="<%=dto.getId_u()%>"></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" value="<%=dto.getTitle()%>"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea id = "editor_ck" rows="10" cols="60" name="content"><%=dto.getContent() %></textarea> </td>
						</tr>
						<tr>
							<td colspan="4" align="right">
							<input type="submit" value="수정"/>
							<input type="button" value="목록" onclick="location.href='InquiryServlet?command=list'"> 
							</td>
						</tr>
				</table>
			</form>
	</div>
	<script>
		CKEDITOR.replace('editor_ck', {
		});
	</script>
	<%@ include file="./form/footer.jsp" %>
</body>
</html>