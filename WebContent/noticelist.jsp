<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lntegrated.notice.dto.NoticeDto"%>
<%@page import="com.lntegrated.notice.dao.NoticeDao"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");%>
<%	response.setContentType("text/html; charset=UTF-8");%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danggen Notice</title>

<style type="text/css">

	.headMenu{position: relative; top: 30%;}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/menu.css">

<style type="text/css">
	.noticeboardWrap{width: 1000px; height:100%;  margin: 0 auto; padding: 0 80px 160px; margin-top: 130px;}
	.noticeboardWrap h1{padding: 59px 0 58px; font-weight: 30px; font-size: 30px; line-height: 40px; color: orange;}
	
    .noticelist table{width: 100%; margin-top: 56px; text-align: center; font-size: 16px; font-weight: 300; 
                   border-top: 1px solid #9c836a; border-bottom: 1px solid #c6b5a4;}
    .noticelist table th{position: relative; height: 60px; font-weight: 300; color: #9c836a;}	
   div.noticelist table tbody tr:first-child{border-top: 1px solid #e6e3df;}
   div.noticelist table tbody tr td:first-child{text-align: left; padding-left: 10px; cursor: pointer;}
   div.noticelist table tbody tr {border-top: 1px solid #f4f2ef; height: 60px;}
   div.noticelist table tbody tr:hover{background-color: #f4f2ef;}
   div.noticelist table tfoot tr {border-top: 1px solid #f4f2ef; height: 60px;}
   .noticeboardWrap table button{border: 1px solid #c6b5a4; padding: 9px 15px 9px 15px; color: #c6b5a4; position: relative;}
   .noticeboardWrap table button:hover{background-color: #c6b5a4; color: white; }
   .noticeboardWrap .paginate{margin-top: 60px; text-align: center;}
   .noticeboardWrap .paginate a{display: inline-block; width: 24px; height: 24px; padding: 0 3px; font-size: 14px; color: #999; 
                      font-weight: 300; line-height: 23px; vertical-align: top; box-sizing: unset;}
   .noticeboardWrap .paginate a.direction{background: url(image/btn_paging.png) center no-repeat; text-indent: -9999px;}
   .noticeboardWrap .paginate a.direction{background-position: 0 0;}
   .noticeboardWrap .paginate a.direction:nth-of-type(2){background-position: 0 -24px; margin-right: 10px;}
   .noticeboardWrap .paginate a.next{background-position: 0 -48px; margin-left: 10px;}
   .noticeboardWrap .paginate a.direction:last-of-type{background-position: 0 -74px; margin-left: 0;}
    div.noticelist table tbody tr>td>span{font-size: 15px; color: orange;} 
</style>

</head>
<%

	List<NoticeDto> list = (List<NoticeDto>)request.getAttribute("list");
	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
%>
<body>

<%@ include file="./form/header.jsp" %>

	<div class="headMenu">
		<h1>고객센터</h1>
		<ul>
			<li><a href="NoticeServlet?command=list">공지사항</a></li>
			<li><a href="InquiryServlet?command=list">1:1 문의</a></li>
			<li><a href="FAQ.jsp">FAQ</a></li>
		</ul>
	</div>

	<div class="noticeboardWrap">
		<h1>공지사항</h1>
		<div class="noticelist">
			<table>
				<colgroup>
					<col width="*">
					<col width="150px">
					<col width="150px">
					<col width="150px">
					<col width="150px">
				</colgroup>	
				<thead>
				<tr>
				<!-- <th>번호</th>  -->
					<th>병원이름</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				</thead>
				<tbody>
				<c:choose>
						<c:when test="${empty list}">
							<tr><th colspan="5">=====첫번째 글을 작성해 주세요^^=====</th></tr>	
						</c:when>
						<c:otherwise>
							<c:forEach items="${list}" var="dto">
								<tr>
									<td>[${dto.medical_d }]</td>
									<td>
										<a href = "NoticeServlet?command=one&nt_seq=${dto.nt_seq }">${dto.title }</a>
										<c:forEach items="${commList }" var="commList">
											<span>${fn:length(commList)}</span>	
										</c:forEach>
									</td>
									<td> ${dto.id_d }</td>
									<td> <fmt:formatDate value="${dto.regdate }" pattern="yyyy.MM.dd"/></td>
									<td> ${dto.views }</td>				
								</tr>
							</c:forEach>
						</c:otherwise>	
					</c:choose>
				</tbody>
				<tfoot>
				<tr>

					<td colspan="5" align="right">
						<c:if test="${not empty id_d}"> <button onclick="location.href='NoticeServlet?command=writeform&id_d=${dto.id_d}'">글쓰기</button></c:if>
					</td>
				</tr>
				<tr>
						<td colspan = "5" align = "center">
							<c:if test="${pageMaker.prev }">
								<a href = "NoticeServlet?command=boardlist&page=1">처음</a>
								<a href = "NoticeServlet?command=boardlist&page=${pageMaker.startPage-1 }">이전</a>
							</c:if>
							<c:forEach begin = "${pageMaker.startPage }" end = "${pageMaker.endPage }" var = "pageNum">
								<a href = '<c:url value = "NoticeServlet?command=boardlist&page=${pageNum }"/>'>${pageNum }</a>
							</c:forEach>
							<c:if test = "${pageMaker.next && pageMaker.endPage >0 }">
								<a href = "NoticeServlet?command=boardlist&page=${pageMaker.endPage+1 }">다음</a>
								<a href = "NoticeServlet?command=boardlist&page=${pageMaker.tempEndPage }">마지막</a>
							</c:if>
						
						</td>
					</tr>
	
				</tfoot>
			
			</table>
		</div>
	</div>
	
	
<%@ include file="./form/footer.jsp" %>
</body>
</html>
