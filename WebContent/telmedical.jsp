<%@page import="com.lntegrated.telemedicine.dto.TeleDto"%>
<%@page import="java.util.List"%>
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
	.telmediWrap{width: 1100px; height:auto; overflow:hidden; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.telmediWrap h1{padding: 59px 0 30px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.telmediWrap .telelist{background-color: lightgray; width: 200px; height: 250px; float: left;}
	.telmediWrap .telelist>div:nth-of-type(1) {height: 30px; border-bottom: 1px solid gray; text-align: center; padding-top: 5px;}
	.telmediWrap .telelist>div:nth-of-type(2) {overflow: scroll; overflow-x: hidden; height: 220px;}
	.telmediWrap .telelist div ul li{cursor: pointer;}
	.telmediWrap .telelist div ul li:hover{background-color: silver;}
	.telmediWrap .teleform{background-color: #f9f9f9; width: 710px; height:350px; padding: 20px 10px 10px 10px; margin-bottom: 30px; float: right; }
	.telmediWrap .chat{background-color: #f9f9f9; width: 710px; height:200px; padding: 20px 10px 10px 10px; margin-bottom: 30px; float: right; }
	
</style>

</head>
<%
	List<TeleDto> list = (List<TeleDto>)request.getAttribute("list");

%>
<body>
<%@ include file="./form/header.jsp" %>
	<div class="headMenu">
		<h1>예약 확인</h1>
		<ul>
			<li><a href="calendarServlet?command=doc_schedule&id_d=${dto.id_d }">예약 일정</a></li>
			<li><a href="TeleServlet?command=telmedical&id_d=${dto.id_d }">원격 진료</a></li>
		</ul>
	</div>
	<div class="telmediWrap">
		<h1>원격 진료</h1>
		<div class="telelist">
			<div>환자목록</div>		
			<div>
<%					
					if(list.size()==0){
%>
				<span>예약된 환자가 없습니다.</span>	
<%
					}else{
%>
				<ul>
<%
						for(int i=0;i<list.size();i++){
%>
					<li><%=list.get(i).getName_u() %></li>
<%
						}
					}	
%>					
				</ul>
			</div>
		</div>
		<div class="teleform">
			
		</div>
		<div class="chat">
		
		</div>
	
	</div>
	
	
<%@ include file="./form/footer.jsp" %>
</body>
</html>