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
	.approvalWrap{width: 1000px; height:840px;  margin: 0 auto; padding: 0 110px 150px; margin-bottom:10px; margin-top: 14%; border-radius: 10px; border: 1px solid rgb(210,210,210);}
	
	
	.cliniclist {width: 38%; height: 66%; background-color: red; position: relative; float: left; overflow: scroll; overflow-x:hidden;  }
	#clinic {padding: 30px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange; width: 53%; float: left;}
	.tellist{width: 20%; height: 66%; background-color: black;overflow: scroll; overflow-x:hidden;}
	#tel{padding: 30px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.inquirylist {width: 30%; height:74%; background-color: yellow; position: absolute; float: left; margin-left: 32%;width: 27%; float: left; overflow: scroll; overflow-x:hidden;}
	#inquiry {padding: 30px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	
</style>

</head>
<body>
<%@ include file="form/header.jsp" %>

	<div class="headMenu">
		<h1>예약 확인</h1>
		<ul>
			<li><a href="calendarServlet?command=doc_schedule&id_d=${dto.id_u }">예약 일정</a></li>
			<li><a href="">원격 진료</a></li>
			<li><a href="">환자 관리</a></li>
		</ul>
	</div>
	
	<div class="approvalWrap">
		<h3 id="clinic">예약/왕진 승인목록</h3>
		<h3 id="tel">원격승인목록</h3>
		<h3 id="inquiry">문의답변목록</h3>
			<div class="cliniclist">
			
			</div>
			<div class="tellist">
			
			</div>
			<div class="inquirylist">
				
			</div>
			<div class="btn_group" align="right">
				<button type = "button" onclick="location.href=''">승인</button>
				<button type = "button" onclick = "location.href = 'InquiryServlet?command=chk'">승인</button>
			</div>
			
	</div>

</body>
</html>