<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String ykiho = (String)request.getAttribute("ykiho");
	String hosName = (String)request.getAttribute("hosName");
	String addr = (String)request.getAttribute("addr");
	
	System.out.println(addr);
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src ="js/hospitol.js"></script>
<script type="text/javascript">
	window.onload = function(){
		hospitolinfo("<%=ykiho%>");
		document.getElementById("hname").innerHTML = "<%=hosName%>";
		document.getElementsByClassName("addr").innerHTML = "<%=addr%>";
	}
</script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">

	.detatilWrap{width: 1000px; height:940px;  margin: 0 auto;  margin-bottom:10px;  border-radius: 10px; border: 1px solid rgb(210,210,210);}
	.detatilWrap h1{padding: 30px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	
	.gg {margin-top: 15%;}
	.medical_name{width: 50%; height: 5%;  margin-left: 11%; position:  absolute; }
	#appointment {width: 30px; height: 50px;margin-left: 75%; margin-bottom: 6px;  }
	#appointment > img {width: 200px; height: 50px;position: relative; z-index: 1; }
	#appointment >span {position: absolute; z-index: 9999; top: 23.5%; left: 58%; width: 200px; color: white; letter-spacing: 2px; font-weight: bold; font-size: 20px;}
	.photo {width: 40%; height:50%; margin-left:1%; margin-top:2%; margin-right:1%; background: pink; float: left;  }
	.info{ width: 57%; height:50%; background: rgb(255,255,204); left:50%; margin-top:2%;  float: left; }
	.addr {width: 98%; height: 5%; background: orange; margin-top: 1%; margin-left: 1%; float: left;}
	.map{width: 98%; height: 40%; background: blue; margin-top: 2px; margin-left: 1%; ; float: left;}
	
	
</style>

</head>
<body>

<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>진료예약</h1>
		<ul>
			<li><a href="#">예약하기</a></li>
			<li><a href="#">왕진신청</a></li>
			<li><a href="#">원격신청</a></li>
		</ul>
	</div>
	<div class="gg">
	 <div class="medical_name">
			<h2 id = "hname">여기에 병원이름 넣고싶음</h2>
		</div>
		<div>
			<button id="appointment" value="진료예약" style="z-index:1; position: relative;" onclick="location.href='HosSelected?command=insertclinicform&id'">
				<img alt="진료예약" src="./resources/imgs/appointment.svg" />
				<span style="z-index: 999; position: absolute;">진료예약</span>
			</button>
		</div>
	</div>
	
	<div class="detatilWrap">
		<div class="photo">
			<span>병원사진</span>
		</div>
		<div class="info">
			<span id = "hosName"> 병원이름 </span>
			<br/>
			<span id = "time">  </span>
			<br>
			<span id = "info"> </span>
			<br>
		</div>
		<div class="addr">
			<h3>주소 : 서울시어쩌구</h3>
		</div>
		<div class="map">
			<h2>지도어떻게넣는건지몰라서자리만잡아놈</h2>
		</div>
	</div>

 	<%@ include file="./form/footer.jsp" %>
</body>
</html>