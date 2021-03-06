<%@page import="com.lntegrated.board_sh_comm.dto.BoardShCommDto"%>
<%@page import="com.lntegrated.board_sh_comm.dao.BoardShCommDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lntegrated.board_sh.dto.BoardShDto"%>
<%@page import="java.util.List"%>
<%@page import="com.lntegrated.board_sh.dao.BoardShDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

	.infoboardWrap{width: 1100px; margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.infoboardWrap h1{padding: 59px 0 30px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	.board_search_wrap {float: right; margin-right: 29px; padding-bottom: 10px;position: relative;}
	.word_input input {width: 180px; height: 38px; line-height: 38px; background-color: #fff; border: 1px solid #e3e3e3;
                   padding: 0 29px 0 20px; float: left;}
	.word_input span.btn {position: absolute; right: 8px; top: 8px; height: 21px;}
	.word_input span.btn img {float: left;}
	.infoshareList table{width: 100%; margin-top: 56px; text-align: center; font-size: 16px; font-weight: 300; 
                   border-top: 1px solid #9c836a; border-bottom: 1px solid #c6b5a4;}
    .infoshareList table th{position: relative; height: 60px; font-weight: 300; color: #9c836a;}
   div.infoshareList table tbody tr:first-child{border-top: 1px solid #e6e3df;}
   div.infoshareList table tbody tr td:first-child{text-align: left; padding-left: 10px; cursor: pointer;}
   div.infoshareList table tbody tr {border-top: 1px solid #f4f2ef; height: 60px;}
   div.infoshareList table tbody tr:hover{background-color: #f4f2ef;}
   div.infoshareList table tfoot tr {border-top: 1px solid #f4f2ef; height: 60px;}
   .infoboardWrap table button{border: 1px solid #c6b5a4; padding: 9px 15px 9px 15px; color: #c6b5a4; position: relative;}
   .infoboardWrap table button:hover{background-color: #c6b5a4; color: white; }
   .infoboardWrap .paginate{margin-top: 60px; text-align: center;}
   .infoboardWrap .paginate a{display: inline-block; width: 24px; height: 24px; padding: 0 3px; font-size: 14px; color: #999; 
                      font-weight: 300; line-height: 23px; vertical-align: top; box-sizing: unset;}
   .infoboardWrap .paginate a.direction{background: url(image/btn_paging.png) center no-repeat; text-indent: -9999px;}
   .infoboardWrap .paginate a.direction{background-position: 0 0;}
   .infoboardWrap .paginate a.direction:nth-of-type(2){background-position: 0 -24px; margin-right: 10px;}
   .infoboardWrap .paginate a.next{background-position: 0 -48px; margin-left: 10px;}
   .infoboardWrap .paginate a.direction:last-of-type{background-position: 0 -74px; margin-left: 0;}
	
	.infoshareList span.hospital{font-size: 16px; margin-right: 5px; float: left; color: orange;}
	.infoshareList table tbody tr>td>span{font-size: 15px; color: lightgray;}
	
</style>
<script type="text/javascript">
	function selectone(board_sh_no){
		location.href="BoardShServlet?command=select&board_sh_no="+board_sh_no;
	}
</script>
</head>
<body>

	<%@ include file="form/header.jsp" %>
	
	<div class="headMenu">
		<h1>커뮤니티</h1>
		<ul>
			<li><a href="BoardFrServlet?command=boardlist">자유게시판</a></li>
			<li><a href="BoardShServlet?command=boardlist">병원정보공유</a></li>
		</ul>
	</div>
	
	<div class="infoboardWrap">
		<h1>병원정보공유</h1>
		<!-- 병원으로 검색 -->
		<div class="board_search_wrap">
            <span class="word_input" style="margin-top:0;">
            <input type="text" name="search_text" placeholder="병원이름으로검색">
            <span class="btn"><a href="#a"><img src="image/search_btn.png" alt=""></a></span>
         	</span>
        </div> 	 
		<div class="infoshareList">
			<table>
				<colgroup>
					<col width="*">
					<col width="150px">
					<col width="150px">
					<col width="150px">
				</colgroup>			
				<thead>
					<tr>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:choose>
						<c:when test="${empty list}">
							<tr><th colspan="4">=====첫번째 글을 작성해 주세요^^=====</th></tr>	
						</c:when>
						<c:otherwise>
							<c:forEach items="${list}" var="dto">
								<tr>
									<td>
										<span class="hospital">[${dto.medical_name }]</span><a href = "BoardShServlet?command=select&board_sh_no=${dto.board_sh_no }">${dto.title }</a>
									</td>
									<td> ${dto.id_u }</td>
									<td> <fmt:formatDate value="${dto.regdate }" pattern="yyyy.MM.dd"/></td>
									<td> ${dto.views }</td>				
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
				<tfoot>		
					<tr>
						<td colspan="4" align="right">
							<button onclick="location.href='BoardShServlet?command=insert'">글쓰기</button>
						</td>
					</tr>
				</tfoot>
				<tr>
						<td colspan = "4" align = "center">
							<c:if test="${pageMaker.prev }">
								<a href = "BoardShServlet?command=boardlist&page=1">처음</a>
								<a href = "BoardShServlet?command=boardlist&page=${pageMaker.startPage-1 }">이전</a>
							</c:if>
							<c:forEach begin = "${pageMaker.startPage }" end = "${pageMaker.endPage }" var = "pageNum">
								<a href = '<c:url value = "BoardShServlet?command=boardlist&page=${pageNum }"/>'>${pageNum }</a>
							</c:forEach>
							<c:if test = "${pageMaker.next && pageMaker.endPage >0 }">
								<a href = "BoardShServlet?command=boardlist&page=${pageMaker.endPage+1 }">다음</a>
								<a href = "BoardShServlet?command=boardlist&page=${pageMaker.tempEndPage }">마지막</a>
							</c:if>
						
						</td>
					</tr>
			</table>
		</div>
		
	</div>
	

</body>
</html>