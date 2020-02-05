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
	.noticeboardupdateWrap{width: 1000px; height:100%; margin: 0 10% auto; padding: 0 80px 160px; margin-top: 130px;}
	.noticeboardupdateWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
</style>

</head>
<% NoticeDto dto = (NoticeDto)request.getAttribute("dto"); %>
<body>
	
	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="noticelist.jsp">공지사항</a></li>
			<li><a href="InquiryServlet?command=list">1:1 문의</a></li>
			<li><a href="FAQ.jsp">FAQ</a></li>
		</ul>
	</div>
	
	<div class="noticeboardupdateWrap">
		<h1>공지사항 수정</h1>
			<form action="NoticeServlet" method="post">
			<input type="hidden" name="command" value="update"/>
			<input type="hidden" name="nt_seq" value="<%=dto.getNt_seq()%>">
				<table border="1">
					<colgroup>
						<col width="192px">
						<col width="*">
					</colgroup>
						<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="<%=dto.getId_d()%>" readonly="readonly"> </td>
					</tr>
					<tr>
						<th>병원이름</th>
						<td><input type="text" name="medical" value="<%=dto.getMedical_d()%>" readonly="readonly"> </td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" value="<%=dto.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea id = "editor_ck" rows="10" cols="60" name="content"><%= dto.getContent() %></textarea> </td>
					</tr>	
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="수정">
							<input type="button" value="취소" onclick="location.href='NoticeServlet?command=one&nt_seq=${dto.nt_seq }'">
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