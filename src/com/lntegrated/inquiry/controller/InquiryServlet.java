package com.lntegrated.inquiry.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.inquiry.dao.InquiryDao;
import com.lntegrated.inquiry.dto.Criteria;
import com.lntegrated.inquiry.dto.InquiryDto;
import com.lntegrated.inquiry.dto.PageMaker;


@WebServlet("/InquiryServlet")
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InquiryDao dao;

    public InquiryServlet() {
        super();
        dao = new InquiryDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String command = request.getParameter("command");

		if(command.equals("boardlist")) {
			String paramPage = request.getParameter("page");
			System.out.println(paramPage);

			Criteria cri = new Criteria();


			if(paramPage==null) {
				cri.setPage(1);
				cri.setPageCount(5);
			} else {
				int page = Integer.parseInt(paramPage);
				cri.setPage(page);
				cri.setPageCount(5);
			}


			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(dao.countBoard());

			List<InquiryDto> list = dao.inquiryList(cri.getPage(), cri.getPageCount());

			request.setAttribute("list", list);
			request.setAttribute("pageMaker", pageMaker);

			dispatch("inquiry_list.jsp", request, response);
		}else if(command.equals("one")) {
			int no = Integer.parseInt(request.getParameter("no"));
			InquiryDto dto = dao.inquiryInfo(no);
			request.setAttribute("dto", dto);
			dispatch("inquiry_info.jsp", request, response);

		}else if(command.equals("writeform")) {
			response.sendRedirect("inquiry_insert.jsp");

		}else if(command.equals("write")) {
			String id_u = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			InquiryDto dto = new InquiryDto(id_u, title, content);
			int res = dao.inquiryInsert(dto);
			if(res >0) {
				jsResponse("작성성공!", "InquiryServlet?command=boardlist", response);
			}else {
				jsResponse("ㅜㅜ", "InquiryServlet?command=write", response);
			}
		}else if(command.equals("updateform")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String id_u = request.getParameter("id_u");
			InquiryDto dto = dao.inquiryInfo(no);
			request.setAttribute("dto", dto);
			dispatch("inquiry_update.jsp", request, response);

		}else if(command.equals("update")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String id_u = request.getParameter("id_u");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			InquiryDto dto = new InquiryDto(no, title, content);
			int res = dao.inquiryUpdate(dto);
			if(res > 0) {
				jsResponse("수정성공!", "InquiryServlet?command=boardlist", response);
			}else {
				jsResponse("ㅜㅜ", "InquiryServlet?command=one&no="+no, response);
			}
		}else if(command.equals("chk")) {
			int no = Integer.parseInt(request.getParameter("no"));
			int res = dao.inquiryUpdateChk(no);

			if(res >0) {

				jsResponse("답변완료", "InquiryServlet?command=boardlist", response);
			}else {
				jsResponse("답변실패", "InquiryServlet?command=boardlist", response);

			}


		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
	}

	private void dispatch( String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);

	}
	private void jsResponse(String msg , String url, HttpServletResponse response) throws IOException {
		String s = "<script type= 'text/javascript'>"
				+"alert('"+msg+"');"
				+"location.href='"+url+"';"
						+ "</script>";
		PrintWriter out = response.getWriter();
		out.print(s);
	}
}
