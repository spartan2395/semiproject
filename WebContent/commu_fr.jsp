<%@page import="com.lntegrated.board_fr.dto.BoardFrDto"%>
<%@page import="java.util.List"%>
<%@page import="com.lntegrated.board_fr.dao.BoardFrDao"%>
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
	.frboardWrap{width: 1000px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.frboardWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.board_search_wrap {float: right;margin-right: 29px; padding-top: 100px; padding-right: 140px;}
	.word_input input {width: 169px; height: 38px; line-height: 38px; background-color: #fff; border: 1px solid #e3e3e3;
    				   padding: 0 29px 0 20px; float: left;}
	.word_input span.btn {position: absolute;right: 8px; top: 8px;height: 21px;}
	.word_input span.btn img {float: left;}
	.headMenu .head_search {float: right; padding: 0 30px 0 10px; font-size: 13px; color: #333;height: 38px; line-height: 38px; border: 1px solid #e3e3e3;
   								border-right: 0; min-width: 67px;position: relative; }
	
</style>
</head>
<%
	BoardFrDao dao = new BoardFrDao();
	List<BoardFrDto> list=dao.boardFrList();
	
%>
<body>
	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>커뮤니티</h1>
		
		<div class="board_search_wrap">
   			<span class="word_input" style="margin-top:0;">
        		<input type="text" name="search_text">
        		<span class="btn"><a href="#a"><img src="image/search_btn.png" alt=""></a></span>
    		</span>
   			<span class="head_search" style="margin-top:0;">
      			 제목
    		</span>
  
		</div>
		
		<ul>
			<li><a href="">자유게시판</a></li>
			<li><a href="BoardFrServlet?command=">약제정보공유</a></li>
		</ul>
	</div>
	
	<div class="frboardWrap">
		<h1>자유게시판</h1>
		
		<div class="frboardList">
			<table>
				<colgroup>
					<col width="*">
					<col width="192px">
				</colgroup>	
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
<%
			if(list.size()==0){
%>				
			<tr><th colspan="5">=====첫번째 글을 작성해 주세요^^=====</th></tr>	
				
<%
			} else {
				for(int i=0;i<list.size();i++){
%>
					<tr>
						<td><%=list.get(i).getBoard_no() %></td>
						<td><a href="BoardFrServlet?command=detail&board_no=<%=list.get(i).getBoard_no() %>"><%=list.get(i).getTitle()  %></a></td>
						<td><%=list.get(i).getId_u()  %></td>
						<td><%=list.get(i).getRegdate() %></td>
						<td><%=list.get(i).getViews()  %></td>
					</tr>
<%
				}
			}	
%>
			<tr>
				<td colspan="5" align="right">
					<button onclick="location.href='BoardFrServlet?command=insertform'">글쓰기</button>
				</td>
			</tr>
				</tbody>		
			</table>
		</div>
		
	</div>

</body>
</html>



