<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript" src = "js/hospitol.js"></script>


<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">

	.appointmentWrap{width: 1000px; height:940px;  margin: 0 auto; padding: 0 110px 150px; margin-bottom:10px; margin-top: 100px; border-radius: 10px; border: 1px solid rgb(210,210,210);}
	.appointmentWrap h1{padding: 30px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.medicalinfo {width: 30%; float: left; margin-right: 30px; margin-bottom: 15px; }
	.medicalinfo_3 {width: 217px; float: left; margin-right: 0; margin-bottom: 15px;}
	.medical_info{width: 217px; text-align: center; margin-top: 15px; margin-bottom: 0; font-size: medium; font-weight: bold; }
	.medical_photo >img{width: 217px; height: 200px; border-radius: 5px;}

	.appointmentWrap .paginate{width:100%; float:left; text-align: center;}
	.appointmentWrap .paginate a{display: inline-block; width: 24px; height: 24px; padding: 0 3px; font-size: 14px; color: #999;
							 font-weight: 300; line-height: 23px; vertical-align: top; box-sizing: unset;}
	.appointmentWrap .paginate a.direction{background: url(image/btn_paging.png) center no-repeat; text-indent: -9999px;}
	.appointmentWrap .paginate a.direction{background-position: 0 0;}
	.appointmentWrap .paginate a.direction:nth-of-type(2){background-position: 0 -24px; margin-right: 10px;}
	.appointmentWrap .paginate a.next{background-position: 0 -48px; margin-left: 10px;}
	.appointmentWrap .paginate a.direction:last-of-type{background-position: 0 -74px; margin-left: 0;}

	.search{padding-top: 5%; padding-left: 55%; }
	.search >input {width: 400px; height: 40px;}
	#search_button {width: 40px; height: 40px;}
	#search_button >img {width: 40px; height: 40px;}
</style>


<script type="text/javascript">
	window.onload = function(){
		thispos();
	}
</script>

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
		<div class="search">
			<input id="searchInput" type="text" name="search_input" placeholder="병원이름, 진료과목 등을 검색해보세요.">
			<button id="search_button">
				<img class="search_icon" alt="search" src="./image/search_icon.svg">
			</button>
		</div>
	</div>


	<div class="appointmentWrap">

		<h1>병원목록</h1>


		<!--


		<div id="1">

		<article class="medicalinfo">
			<a class="medical_link" onclick = "send(0)">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>
		<article class="medicalinfo">
			<a class="medical_link" onclick = "send(1)">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>

		<article class="medicalinfo_3">
			<a class="medical_link" onclick = "send(2)">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>
		</div>
		<article class="medicalinfo">
			<a class="medical_link" onclick = "send(3)">
				<div class="medical_photo">
				<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>

		<article class="medicalinfo">
			<a class="medical_link" onclick = "send(4)">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>

		<article class="medicalinfo_3">
			<a class="medical_link" href="#">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>

		<article class="medicalinfo">
			<a class="medical_link" href="#">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>

		<article class="medicalinfo">
			<a class="medical_link" href="#">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>

		<article class="medicalinfo_3">
			<a class="medical_link" href="#">
				<div class="medical_photo">
					<img alt="병원사진" src="./image/errorphoth.png">
				</div>
				<div class="medical_info">
					<p class="medical_name">
						영원한등대
					</p>
				</div>
			</a>
		</article>
		 -->
		<article class="paginate" >
			<a href="" class="direction prev"></a>
			<a href="" class="direction prev"></a>
			<a href="" class="num active">1</a>
			<a href="" class="direction next"></a>
			<a href="" class="direction next"></a>
		</article>
	</div>

	<%@ include file="./form/footer.jsp" %>



</body>

</html>
