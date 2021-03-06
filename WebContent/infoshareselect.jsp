<%@page import="com.lntegrated.board_sh_comm.dto.BoardShCommDto"%>
<%@page import="java.util.List"%>
<%@page import="com.lntegrated.board_sh_comm.dao.BoardShCommDao"%>
<%@page import="com.lntegrated.board_sh.dto.BoardShDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">
<style type="text/css">

	.infoselectWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.infoselectWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.infoselectWrap>h2{position: relative; width: 100%; font-size: 24px; color: #333; font-weight: 400;
						  float: left; line-height: 1.3; border-top: 1px solid #7e7e7e; background-color: #f9f9f9;
						  padding: 37px 27px 30px; word-break: break-all;}
	.infoselectWrap>h2 span{color: orange; margin-right: 10px;}
	.infoselectWrap .meminfo{float: left; width: 100%; height: 35px; border-top: 1px solid #e3e3e3; border-bottom: 1px solid #e3e3e3;}
	.infoselectWrap .meminfo span{float: left; margin-left: 17px; height: 100%; font-size: 13px; margin-top: 7px;}
	.infoselectWrap .meminfo span img{height: 20px; width: 20px; margin-right: 8px;}
	.infoselectWrap .meminfo .sysinfo{float: right;}
	.infoselectWrap .meminfo .sysinfo p{float: left; font-size: 12px; color: #aaa; margin-right: 25px; line-height: 1; margin-top: 10px;}
	.infoselectWrap .meminfo .sysinfo p img{margin-right: 4px; vertical-align: middle; margin-bottom: 2px;}
	.infoselectWrap .meminfo .sysinfo p.last{margin-right: 27px;}
	.infoselectWrap .text{float: left; width: 1000px; margin-top: 40px; margin-left: 27px; font-size: 16px;
   							 color: #333; line-height: 26px;margin-bottom: 40px; word-break: break-all; display: block;}
	.infoselectWrap .text>button{border: 1px solid orange; background-color: rgba(0,0,0,0);color: orange; padding:20px; position: relative; left: 400px; top: 90px;}
	.infoselectWrap .text>button:hover{background-color: orange;color: white;}
	.infoselectWrap .btn_group button{border: 1px solid orange; background-color: rgba(0,0,0,0); color: orange; padding: 5px; position:relative; top: 90px;}
	.infoselectWrap .btn_group button:hover{background-color: orange; color: white;}
	.reply_wrap{float: left; width: 100%; position: relative; top: 110px;}
	.reply_title{float: left; width: 100%; height: 44px; 
				 border-top: 1px solid #e3e3e3;background-color: #f9f9f9;line-height: 45px; padding: 10px 0;}
	.reply_title h2 {float: left;margin-left: 27px;font-size: 16px;color: #333333;}
	.reply_title h2 span {font-size: 16px; color: #f68400; margin-left: 5px;}
	.reply_wrap .reply_ul{float: left; width: 100%;}
	.reply_wrap .bottom_reply{float: left; margin-top: 40px; width: 100%; height: 205px; background-color: #e8eaee;
   							  border: 1px solid #dcdde1;}
   	.reply_wrap .bottom_reply .txar {float: left;padding: 20px; width: 868px;height: 90px; margin-top: 10px;
    								 margin-left: 10px;background-color: #fff; resize: none; overflow: hidden; overflow-y: auto;}
	.bottom_reply .btn01_g{min-width: 53px; font-size: 16px; color: #fff !important; text-align: center; background-color: #747a86;
						 border-radius: 2px; padding: 9px 17px 9px 17px; border: 1px solid #747a86; display: inline-block; line-height: 1; float: right;
						 position: relative; top: 10px; right: 10px;}

</style>
<script type="text/javascript">

$(function(){
	$("#btnReply").click(function() {
		$.ajax({
			method: "POST",
			url: "BoardShCommServlet",
			data: {"command":"insert" ,"board_sh_no":$("input[id=board_sh_no]").val() , "content":$("#textReply").val() },

			success: function(data) {
				alert("댓글성공");
				location.href = "BoardShServlet?command=select&board_sh_no="+$("input[id=board_sh_no]").val();
			}
		});
	});	
});

</script>
</head>
<%
	BoardShDto dto = (BoardShDto)request.getAttribute("dto");
	BoardShCommDao dao = new BoardShCommDao();
	List<BoardShCommDto> list = dao.selectList(dto.getBoard_sh_no());
%>
<body>

	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>커뮤니티</h1>
		<ul>
			<li><a href="BoardFrServlet?command=boardlist">자유게시판</a></li>
			<li><a href="BoardShServlet?command=boardlist">병원정보공유</a></li>
		</ul>
	</div>
	
	<div class="infoselectWrap">
		<h1>병원정보공유</h1>
		
		<h2><span>[<%=dto.getMedical_name() %>]</span><%=dto.getTitle() %></h2>
		<div class="meminfo">
			<span><img alt="" src="image/doctorcarrot.png"><%=dto.getId_u() %></span>
			<div class="sysinfo">
				<p>
					<img alt="조회수" src="image/eye_new.png">
					<%=dto.getViews() %>
				</p>
				<p class="last">
					<img alt="작성시간" src="image/sub_date_new.png">
					<fmt:formatDate value="${dto.regdate }" pattern="yyyy.MM.dd a hh:mm"/>
				</p>
			</div>
		</div>
		<input type="hidden" id="board_sh_no" value="<%=dto.getBoard_sh_no() %>">
		<div class="text">
			<p><%=dto.getContent() %></p>
			<button onclick="location.href='BoardShServlet?command=boardlist'">목록</button>
		</div>
		<div class="btn_group" align="right">
			<button onclick="location.href = 'BoardShServlet?command=update&board_sh_no=<%=dto.getBoard_sh_no() %>'">수정</button>
			<button onclick="location.href = 'BoardFrServlet?command=delete&board_sh_no=<%=dto.getBoard_sh_no() %>&id_u=<%=dto.getId_u()%>'">삭제</button>
		</div>
		<div class="reply_wrap">
			<div class="reply_title">
				<h2>댓글 <span><%=list.size() %></span></h2>
			</div>
			<ul class="reply_ul">
<%	
					if(list.size()>0){
						for(int i=0;i<list.size();i++){
%>				
				<li>
					<div class="reply">
						<p><%=list.get(i).getId_u() %><span><%=list.get(i).getRegdate() %></span></p>
						<div class="reply_text">
							<%=list.get(i).getContent() %>
						</div>					
					</div>
				</li>
					
<%
						}
					}
%>			
			</ul>
			<div class="bottom_reply">
				<textarea id="textReply" rows="10" cols="30" class="txar" name="comment"></textarea>
				<span><button type = "button" id = "btnReply" class="btn01_g">등록</button></span>
			</div>
			
		</div>
	</div>

</body>
</html>