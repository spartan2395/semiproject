<%@page import="com.lntegrated.clinic.dto.ClinicDto"%>
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

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">
	.appointmentwriteWrap{width: 1000px; height:100% margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.appointmentwriteWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	
</style>

</head>
<% List<ClinicDto> list = (List<ClinicDto>)request.getAttribute("list"); %>
<body>
<%@ include file="./form/header.jsp" %>

	

	<div class="appointmentwriteWrap">
		<h1>예약하기</h1>
		<form action="TeleServlet" method="post">
			<input type="hidden" name="command" value="inserttel">
			<table border="1">
				<col width="60px;"/>
				<col width="200px;"/>
				<tr>
					<th>병원명</th>
					<td><input type="text" name="medical_d" value="<%= %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>예약자명</th>
					<td><input type="text" name="name_u"> </td>
				</tr>
				<tr>
					<th>예약일자</th>
					<td>
					<select name = "year">

						<option>2020</option>
					
					</select>년
					<select name = "month">
<%
						for(int i = 1; i <= 12; i++){
%> 
						<option><%=i %></option>
<%
						}
%>
					</select>월
					<select name = "date">
<%
						for(int i = 1; i <= 31; i++){
%> 
						<option><%=i %></option>
<%
						}
%>
					</select>일
					<select name = "hour">
<%
						for(int i = 1; i <= 24; i++){
%> 
						<option ><%=i %></option>
<%
						}
%>
					</select>시
					<select name="minute">
						<option>00</option>
						<option>30</option>
					</select>분
					
				</tr>
				<tr>
					<th>증상</th>
					<td><textarea rows="10" cols="60" name="disease" placeholder="증상을입력해주세요"></textarea> </td>
				</tr>
				<tr>
					<td colspan="2" align="right">
					<input type="submit" value="예약하기">
					<input type="button" value="취소" onclick="location.href='app_medical_detatil.jsp'">
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="./form/footer.jsp" %>
</body>
</html>