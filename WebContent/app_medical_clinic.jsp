<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String ykiho = (String)request.getAttribute("ykiho");
	String hosName = (String)request.getAttribute("hosName");
	String addr = (String)request.getAttribute("addr");
	String x = (String)request.getAttribute("x");
	String y = (String)request.getAttribute("y");
	System.out.println(addr);
%>

<script type="text/javascript" src="js/kakaomaps.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src ="js/hospitol.js"></script>
<script type="text/javascript">
	window.onload = function(){
		hospitolinfo("<%=ykiho%>");
		document.getElementById("hname").innerHTML = "<%=hosName%>";
		document.getElementById("addr").innerHTML = "<%=addr%>";
		var x = <%=x%>;
		var y = <%=y%>;
		if(x == null){
			x = <%=x%>;
			y = <%=y%>;
		}
		
		map(x,y);
	}
	
	function goInsertClinicForm(){
		var hname = $("#hname").text();
		console.log(hname);
		location.href="HosSelected?command=insertclinicform&hosName="+hname;
	}
</script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">

	.detatilWrap{margin-bottom: 35px; width: 1000px; height:500px;  margin: 0 auto;  margin-bottom:10px;  border-radius: 10px; border: 1px solid rgb(210,210,210);}
	.detatilWrap h1{padding: 30px 0 58px; ma font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	
	.gg {margin-top: 15%; margin-bottom: 15px;}
	.medical_name{left:11%; margin-bottom:20px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange; position:  absolute; }
	#hname {margin-top:5%; font-weight: bold;}
	#appointment {width: 30px; height: 50px;margin-left: 75%; margin-bottom: 6px;  }
	#appointment > img {width: 200px; height: 50px;position: relative; z-index: 1; }
	#appointment >span {position: absolute; z-index: 9999; top: 23.5%; left: 58%; width: 200px; color: white; letter-spacing: 2px; font-weight: bold; font-size: 20px;}
	.addr {width: 98%; height: 5%; font-size:medium;  margin-left: 1%; margin-bottom:30px; float: left;}
	.addr >span {width: 45px; font-size: medium; margin-left: 1%; margin-bottom: 30px; float: left; margin-top: 19px; font-weight: 500;}
	.addr >h3 {margin-top: 20px; margin-left: 10px; font-weight: 500; float: left;}
	.info{width: 25%; height: 30%; background-color: rgba(210,210,210,0.8); z-index:9999; position: absolute; margin-left: 53.2%; margin-top: 57px;}
	.map{width: 98%; height: 430px; background: blue; margin-top: 2px; margin-left: 1%; z-index:1 position:relative; float: left;}
	
	
</style>

</head>
<body>

<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>진료예약</h1>
		<ul>
			<li><a href="appointment.jsp">예약하기</a></li>
			<li><a href="appointment.jsp">왕진신청</a></li>
			<li><a href="appointment_tel.jsp">원격신청</a></li>
		</ul>
	</div>
	<div class="gg">
	 <div class="medical_name">
			<h2 id = "hname">여기에 병원이름 넣고싶음</h2>
		</div>
		<div>
			<button id="appointment" value="진료예약" style="z-index:1; position: relative;"  onclick="goInsertClinicForm();" >
				<img alt="진료예약" src="./resources/imgs/appointment.svg" />
				<span style="z-index: 999; position: absolute;"  >진료예약</span>
			</button>
		</div>
	</div>
	
	<div class="detatilWrap">
		
		<div class="addr">
			<span>주소 : </span>
			<h3 id = "addr">주소 : 서울시어쩌구</h3>
		</div>
		<div class="info">
			<p style="color: black; font-weight: 600;">안녕ㅇ난녕</p>
		</div>
		<div class="map" id = "map">
			
		</div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ccb039f1009ae7fadcb5d4bcf333ef15&libraries=services"></script>
	</div>

 	<%@ include file="./form/footer.jsp" %>
</body>
</html>