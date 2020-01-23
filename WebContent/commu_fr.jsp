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

	.frboardWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.frboardWrap h1{padding: 59px 0 30px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
  	/*검색*/
   .board_search_wrap {float: right; margin-right: 29px; padding-bottom: 10px;position: relative;}
   .word_input input {width: 169px; height: 38px; line-height: 38px; background-color: #fff; border: 1px solid #e3e3e3;
                   padding: 0 29px 0 20px; float: left;}
   .word_input span.btn {position: absolute; right: 8px; top: 8px; height: 21px;}
   .word_input span.btn img {float: left;}
   .frboardList table{width: 100%; margin-top: 56px; text-align: center; font-size: 16px; font-weight: 300;
                   border-top: 1px solid #9c836a; border-bottom: 1px solid #c6b5a4;}
    .frboardList table th{position: relative; height: 60px; font-weight: 300; color: #9c836a;}
   	/* .frboardList table thead th:before {display: block; content: ''; position: absolute; top: 23px;
                    right: 0px; height: 16px; width: 1px; background-color: #e6e3df;} */
   div.frboardList table tbody tr:first-child{border-top: 1px solid #e6e3df;}
   div.frboardList table tbody tr td:first-child{text-align: left; padding-left: 10px; cursor: pointer;}
   div.frboardList table tbody tr {border-top: 1px solid #f4f2ef; height: 60px;}
   div.frboardList table tbody tr:hover{background-color: #f4f2ef;}
   div.frboardList table tfoot tr {border-top: 1px solid #f4f2ef; height: 60px;}
   .frboardWrap table button{border: 1px solid #c6b5a4; padding: 9px 15px 9px 15px; color: #c6b5a4; position: relative;}
   .frboardWrap table button:hover{background-color: #c6b5a4; color: white; }
   .frboardWrap .paginate{margin-top: 60px; text-align: center;}
   .frboardWrap .paginate a{display: inline-block; width: 24px; height: 24px; padding: 0 3px; font-size: 14px; color: #999;
                      font-weight: 300; line-height: 23px; vertical-align: top; box-sizing: unset;}
   .frboardWrap .paginate a.direction{background: url(image/btn_paging.png) center no-repeat; text-indent: -9999px;}
   .frboardWrap .paginate a.direction{background-position: 0 0;}
   .frboardWrap .paginate a.direction:nth-of-type(2){background-position: 0 -24px; margin-right: 10px;}
   .frboardWrap .paginate a.next{background-position: 0 -48px; margin-left: 10px;}
   .frboardWrap .paginate a.direction:last-of-type{background-position: 0 -74px; margin-left: 0;}
    div.frboardList table tbody tr>td>span{font-size: 15px; color: orange;}


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
		<ul>
			<li><a href="">자유게시판</a></li>
			<li><a href="">약제정보공유</a></li>
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

						<td>
							<a href="BoardFrServlet?command=select&board_no=<%=list.get(i).getBoard_no() %>"><%=list.get(i).getTitle()  %></a>
							<span>[댓글개수]</span>
						</td>

						<td><%=list.get(i).getId_u()  %></td>
						<td><%=list.get(i).getRegdate() %></td>
						<td><%=list.get(i).getViews()  %></td>
					</tr>
<%
				}
			}
%>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="4" align="right">
							<button onclick="location.href='BoardFrServlet?command=insertform'">글쓰기</button>
						</td>
					</tr>
				</tfoot>

			</table>
		</div>

	</div>

</body>
</html>
