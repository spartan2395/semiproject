<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">
	.medicalreportWrap{width: 100%; height:100%;  padding: 0 80px 160px; margin-top: 10px;}
	.medicalreportWrap h1{padding: 39px 0 38px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.reportlist {text-align:center; border-radius: 5%; border: 1px solid gray; width: 30%; height: 70%; position: absolute; float: left;}
	 p {margin-top: 5px;}
	.reportlist >textarea {display: inline-block;}
	.reportlist >textarea::-webkit-scrollbar {width: 5px;}
	.report {text-align:center;border-radius: 5%; border: 1px solid gray; width: 60%; height: 90%;  float: right;}
	.payment {text-align:center; width: 20%; height: 10%; float: right; border-radius: 5%; background: rgb(255,255,204);margin-top: 10px; margin-left: 58%;}
</style>


</head>
<body>
<%@ include file="./form/header.jsp" %>

	<div class="medicalreportWrap">
		<h1>진단서 출력 </h1>
		<div class="reportlist" >
			<p>진단서 미출력 리스트</p>
			<textarea rows="20" cols="50" ></textarea>
		</div>
		<div class="report">
			<p>여기는 진단서pdf파일 띄어주는 곳</p>
		</div>
		<div class="payment">
			<a>결제하기</a>
		</div>
	</div>



<%@ include file="./form/footer.jsp" %>
	
</body>
</html>