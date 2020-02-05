<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lntegrated.inquiry.dto.InquiryDto"%>
<%@page import="com.lntegrated.telemedicine.dto.TeleDto"%>
<%@page import="com.lntegrated.clinic.dto.ClinicDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "css/reset.css" rel="stylesheet" type="text/css"/>
<link href = "css/menu.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/main.js">
   

</script>

<style type="text/css">
	.approvalWrap{width: 1000px; height:600px;  margin: 0 auto; padding: 0 110px 150px; margin-bottom:10px; margin-top: 14%; border-radius: 10px; border: 1px solid rgb(210,210,210);}
	
	
	.cliniclist {width: 31%; margin-right:30px; height: 60%; background-color: rgb(210,210,210); position: relative; float: left; overflow: scroll; overflow-x:hidden;  }
	#clinic {padding: 30px 0 58px; font-weight: 300; font-size: 24px; line-height: 40px; float:left; color: orange; width: 39%; float: left;}
	.tellist{width: 32%; height: 60%; background-color: rgb(210,210,210); float:left; overflow: scroll; overflow-x:hidden;}
	#tel{padding: 30px 0 58px; font-weight: 30px; font-size: 24px; width:25%; float:left; line-height: 40px; color: orange;}
	.inquirylist {width: 20%; margin-left:45%; height:44%; background-color: rgb(210,210,210); position: absolute; float: left; margin-left: 32%;width: 27%; float: left; overflow: scroll; overflow-x:hidden;}
	#inquiry {padding: 30px 0 58px; font-weight: 30px; font-size: 24px;  line-height: 40px; color: orange; width: 25%; margin-left: 73%; top:10px;}
	
	.btn_group {margin-top: 40%; width: 100%; height:60px; }
	.btn_group >button {border: 1px solid orange; background-color: rgba(0,0,0,0);color: orange; padding:20px; position: relative; }
</style>

</head>
<%
	List<ClinicDto> clist = (List<ClinicDto>) request.getAttribute("clist");
	List<TeleDto> tlist = (List<TeleDto>) request.getAttribute("tlist");
	List<InquiryDto> list = (List<InquiryDto>)request.getAttribute("list");
	
%>
<body>
<%@ include file="form/header.jsp" %>

	<div class="headMenu">
		<h1>예약 확인</h1>
		<ul>
			<li><a href="calendarServlet?command=doc_schedule&id_d=${dto.id_d }">예약 일정</a></li>
			<li><a href="">원격 진료</a></li>
			<li><a href="">환자 관리</a></li>
		</ul>
	</div>
	
	<div class="approvalWrap">
		<h3 id="clinic">예약/왕진 승인목록</h3>
		<h3 id="tel">원격승인목록</h3>
		<h3 id="inquiry">문의답변목록</h3>
			<div class="cliniclist">
			<%
				if(clist.size() == 0 || clist == null ) {
			%>
			<span>미승인 목록이 없습니다.</span>
			<% }else { %>
			<ul>
				<%
					for(int i =0; i <clist.size(); i++) {
						SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
				%>
				<li >
						<%=clist.get(i).getName_d()%>
						<%=df.format(clist.get(i).getReserv_date())%>
				</li>
			<%
					}
			}
			%>
					
			
			</ul>
			</div>
			<div class="tellist">
			
			</div>
			<div class="inquirylist" style="width: 20%; margin-left: 44%;">
				
			</div>
			<div class="btn_group" align="right">
				<button type = "button" style="float: left;left: 11%;" onclick="location.href=''">승인</button>
				<button type = "button" style="float: left;left: 37%;" onclick="location.href=''">승인</button>
				<button type = "button" style="float: left; left: 65%" onclick = "location.href = 'InquiryServlet?command=chk'">승인</button>
				
			</div>
			
	</div>
<%@ include file="./form/footer.jsp" %>
</body>
</html>