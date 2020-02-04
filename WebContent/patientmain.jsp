<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "css/reset.css" rel="stylesheet" type="text/css"/>
<link href = "css/membermain.css" rel="stylesheet" type="text/css"/>
<style type="text/css">

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/main.js">


</script>
</head>
<body>
	<div class="wrap">
		<%@include file="form/header.jsp" %>

	   <div class="mainVisual">
	      <div class="left">
	      	<span id="left2" style="width: 1249px; height: 840px;"></span>
	      </div>
	      <div class="right" style="width: 50%; height:840px; left: 50%">
	      	<span id="right2" style="width: 1249px; height: 840px; left: -100%;"></span>
	      </div>
	   </div>
	 

      <div class="main" >
         <div class="left">
            <div class="textbox">
               <p>마이페이지</p>
            </div>
            <div class="textview">
               <a href="patient_schedule.jsp">
                  <h2>예약확인</h2>
               </a>
               <a href="#">
                  <h2>개인정보수정</h2>
               </a>
               <a href="#">
                  <h2>즐겨찾는병원</h2>
               </a>
               <a href="#">
                  <h2>원격 진료</h2>
               </a>
            </div>
         </div>
         <div class="right">
            <div class="textbox">
               <p>진료예약</p>
            </div>
            <div class="textview">
               <a href="appointment.jsp">
                  <h2>예약하기</h2>
               </a>
               <a href="appointment.jsp">
                  <h2>왕진신청</h2>
               </a>
               <a href="appointment_tel.jsp">
                  <h2>원격진료신청</h2>
               </a>
            </div>
         </div>
      </div>
   </div>
   <%@ include file="./form/footer.jsp" %>


</body>
</html>
