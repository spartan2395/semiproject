<%@page import="com.lntegrated.tel_result.dto.TelResultDto"%>
<%@page import="com.lntegrated.tel_result.dao.TelResultDao"%>
<%@page import="com.lntegrated.telemedicine.dto.TeleDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">
<style type="text/css">
	
	.contentWrap{width: 1100px; height:694px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.contentWrap h1{padding: 59px 0 30px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.contentWrap .nonreserve{background-color: lightgray; width: 200px; height: 250px; float: left;}
	.contentWrap .nonreserve>div:nth-of-type(1) {height: 30px; border-bottom: 1px solid gray; text-align: center; padding-top: 5px;}
	.contentWrap .nonreserve>div:nth-of-type(2) {overflow: scroll; overflow-x: hidden; height: 220px;}
	.contentWrap .nonreserve div ul li{cursor: pointer;}
	.contentWrap .nonreserve div ul li:hover{background-color: silver;}
	.contentWrap .basic{background-color: #f9f9f9; width: 710px; height:250px; padding: 20px 10px 10px 10px; margin-bottom: 30px; float: right; }
	.contentWrap .basic h2{text-align: center; font-size: 23px; color: #666666; padding-top: 80px;}
	.contentWrap .uploadform{background-color: #f9f9f9; width: 710px; padding: 20px 10px 10px 10px; margin-bottom: 30px; float: right; }
	.contentWrap .resulthead{width: 100%; height: 70px; float: left;}
	.contentWrap .resulthead input{height: 32px; border: 1px solid #e6e6e6;line-height: 32px; font-size: 15px;padding-left: 13px;
									margin: 0 10px 10px 10px;}
	.contentWrap .result{text-align: center;}
	.contentWrap .result input{width: 644px;height: 32px;border: 1px solid #e6e6e6;line-height: 32px;
    					padding-left: 13px; font-size: 16px; color: #666666; margin-top: 13px;}
	.contentWrap .dx_content_input{width: 620px; height:350px; border: 1px solid #e6e6e6; margin-top: 13px; font-size: 16px;
									padding: 13px 13px;}
	.contentWrap .remarks_input{width: 620px; height:100px; border: 1px solid #e6e6e6; margin-top: 13px; font-size: 16px;
									padding: 13px 13px;}
							
	.contentWrap .btn button{min-width: 53px;font-size: 16px;color: #fff;text-align: center; background-color: orange;
    				border-radius: 2px;padding: 12px 16px 12px 16px; border: 1px solid orange;display: inline-block; margin: 10px 10px 10px 10px;}
	
	
</style>
<script type="text/javascript">
$(function(){
	   $('.nonreserve>div>ul>li').click(function(){
	      $('.uploadform').css('display','');
	      $('.basic').css('display','none');
	      var telseq = $(this).attr('name');
	      $.ajax({
	         method: "POST",
	         url: "TeleServlet",
	         data: {"command":"select","tel_seq":telseq},
	         dataType: "json",
	         async: true,
	         success: function(data){
	            $('#reserv_date_input').val(data.reserv_date);
	            $('#name_u_input').val(data.name_u);
	            $('#tel_seq').val(data.tel_seq);
	            
	         },
	         error : function() {
	            alert("정보를 불러오는데 실패하였습니다.");
	         }
	         
	      });
	   });
	});   

</script>

</head>
<% List<TeleDto> list = (List<TeleDto>)request.getAttribute("list"); 
	//List<TelResultDto> resultlist = new 
TelResultDao resultdao = new TelResultDao();
	//System.out.println(list);
%>
<body>
	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>예약 확인</h1>
		<ul>
			<li><a href="calendarServlet?command=doc_schedule&id_d=nexon">예약 일정</a></li>
			<li><a href="">원격 진료</a></li>
			<li><a href="">환자 관리</a></li>
		</ul>
	</div>
	
	<div class="contentWrap">
		<h1>진단서 업로드</h1>
		<div class="nonreserve">
			<div>진단서 미업로드 환자</div>
			<div>
<%					
					if(list.size()==0){
%>
				<span>진단서를 모두 업로드 하셨습니다.</span>	
<%
					}else{
%>						
				<ul>	<!-- onclick 이벤트 ajax로 만들어야 할까요 -->
<%
						for(int i=0;i<list.size();i++){
						//	TelResultDto resultdto = resultdao.telResultInfo(list.get(i).getTel_seq());
						//	if(resultdto==null){
%>					
					<li name="<%=list.get(i).getTel_seq() %>">
						<%=list.get(i).getName_u() %>
					</li>
<%
						//	}
						}
					}	
%>
				</ul>
			</div>
		</div>
		<div class="basic">
			<h2>환자를 선택해 주세요</h2>
		</div>
		
		<div class="uploadform" style="display: none;">
			<form action="TeleResultServlet" method="post">
				<input type="hidden" name="command" value="insert">
				<input type="hidden" name="tel_seq" id="tel_seq" value="">
				<div class="resulthead"> 
					진료일자
					<input type="text" id="reserv_date_input" value="" readonly="readonly"><br>
					환자이름
					<input type="text" id="name_u_input" value="" readonly="readonly">
					의사아이디
					<input type="text" id="id_d_input" value="nexon" readonly="readonly">
				</div>	
				<div class="result">
					<input type="text" placeholder="진단명" name="dx_name"><br>
					<textarea  class="dx_content_input" rows="9" cols="40" placeholder="진단내역" name="dx_content"></textarea><br>
					<textarea class="remarks_input" rows="9" cols="40" placeholder="비고" name="remarks"></textarea><br>
					<input type="text" placeholder="제출용도" name="purpose">
				</div>
				<div class="btn" align="center">
					<button type="submit">업로드</button>
				</div>
			</form>
		</div>
	</div>
	
	
	
<%@ include file="./form/footer.jsp" %>	

</body>
</html>