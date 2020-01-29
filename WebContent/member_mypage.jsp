<%@page import="com.lntegrated.calendar.Util"%>
<%@page import="com.lntegrated.telemedicine.dto.TeleDto"%>
<%@page import="com.lntegrated.telemedicine.dao.TeleDao"%>
<%@page import="com.lntegrated.clinic.dto.ClinicDto"%>
<%@page import="java.util.List"%>
<%@page import="com.lntegrated.clinic.dao.ClinicDao"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#calendar {
	border-collapse: collapse;
	border: 1px solid gray;
}

#calendar th {
	width: 80px;
	border: 1px solid gray;
}

#calendar td {
	width: 80px;
	height: 80px;
	border: 1px solid gray;
	text-align: left;
	vertical-align: top;
	position: relative;
}

#clist>p {
	font-size: 5px;
	margin: 1px;
	background-color: skyblue;
}

#cpreview {
	position: absolute;
	top: -30px;
	left: 10px;
	background-color: pink;
	width: 40px;
	height: 40px;
	text-align: center;
	line-height: 40px;
	border-radius: 40px 40px 40px 1px;
}
	.calendarWrap{width: 1000px; height:100%; margin: 0 auto; padding: 0 80px 160px; margin-bottom: 130px;}
	.calendarWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}

</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "post",
			url : "calendarServlet",
			data : {"yyyyMMdd": yyyyMMdd,"command":"calendar_ajax"},
			dataType : "json",
			async : false, //동기
			success : function(msg) {
				
			//	var count = msg.calcount;
			//	cdate.after("<div class='cpreview'>" + count + "</div>");
			},
			error : function() {
				alert("통신실패")
			}
		}, function() {
			$(".cpreview").remove();

		});

	});
</script>
<link href = "css/reset.css" rel="stylesheet" type="text/css"/>
<link href = "css/membermain.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/main.js">
   

</script>

</head>
<body>

	<%
		Calendar cal = Calendar.getInstance(); //오늘날짜

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		String paramYear = request.getParameter("year");
		String paramMonth = request.getParameter("month");

		if (paramYear != null) {
			year = Integer.parseInt(paramYear);
		}
		if (paramMonth != null) {
			month = Integer.parseInt(paramMonth);
		}
		//다음연도 1월
		if (month > 12) {
			month = 1;
			year++;
		}
		//이전연도 12월
		if (month < 1) {
			month = 12;
			year--;
		}
		//1. 현재년도, 현재 월 , 1일로 달력 설정
		cal.set(year, month - 1, 1);

		//2. 1일의 요일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		//3. 현재 월의 마지막 일 
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		//달력의 일정표현
		List<ClinicDto> clist = (List<ClinicDto>) request.getAttribute("clist");
		List<TeleDto> tlist = (List<TeleDto>) request.getAttribute("tlist");
	%>
	<%@ include file="form/header.jsp" %>
	
	<div class="calendarWrap">
		<h1 style="width: 50%;">예약확인</h1>
		<div style="float: left margin-top: 14%; margin-left: 39%;">
		<input type="button" value="진단서출력 " onclick="location.href='medicalreport.jsp'" style="width: 30%; float:right;">
		</div>
		<table id="calendar" >
			<caption>
				<a href="calendarServlet?command=schedual&year=<%=year - 1%>&month<%=month%>&id_u=UID">◁◁</a>
				<a href="calendarServlet?command=schedual&year=<%=year%>&month=<%=month - 1%>&id_u=UID">◁</a>
				<span class="Y"><%=year%></span>년 <span class="M"><%=month%></span>월
				<a href="calendarServlet?command=schedual&year=<%=year%>&month=<%=month + 1%>&id_u=UID">▷</a>
				<a href="calendarServlet?command=schedual&year=<%=year + 1%>&month<%=month%>&id_u=UID">▷▷</a>
			</caption>
	
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
			<tr>
				<%
					for (int i = 0; i < dayOfWeek - 1; i++) {
						out.print("<td>&nbsp;</td>");
					}
				%>
				<%
					for (int i = 1; i <= lastday; i++) {
				%>
				<td><a class="countview" href=""><%=i%></a>
					<div class="clist">
						<%=Util.getCalView(month,i,clist,tlist)%>
					</div></td>
				<%
					if ((dayOfWeek - 1 + i) % 7 == 0) {
							out.print("</tr><tr>");
						}
					}
	
					for (int i = 0; i < (7 - (dayOfWeek - 1 + lastday) % 7) % 7; i++) {
						out.print("<td>&nbsp;</td>");
	
					}
				%>
	
			</tr>
		</table>
	</div>
	<%@ include file="./form/footer.jsp" %>

</body>
</html>