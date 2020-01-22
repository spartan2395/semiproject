package com.lntegrated.notice.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.notice.dao.NoticeDao;
import com.lntegrated.notice.dto.NoticeDto;


@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeDao dao;

	
   
    public NoticeServlet() {
        super();
        dao = new NoticeDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		
		if(command.equals("list")) {
			List<NoticeDto> list = dao.notice_List();
			request.setAttribute("list", list);
			dispatch("noticelist.jsp", request, response);
			
			
		}else if(command.equals("one")) {
			int nt_seq = Integer.parseInt(request.getParameter("nt_seq"));
		
			NoticeDto dto = dao.notice_Info(nt_seq);
			request.setAttribute("dto", dto);
			dispatch("notice_info.jsp", request, response);
			
		}else if(command.equals("writeform")) {
			response.sendRedirect("notice_write.jsp");
			
		}else if(command.equals("write")) {
			String id_d = request.getParameter("writer");
			String medical_d = request.getParameter("medical");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			NoticeDto dto = new NoticeDto(id_d, medical_d, title, content);
			int res = dao.notice_insert(dto);
			if(res >0) {
				jsResponse("작성성공!", "NoticeServlet?command=list", response);
			}else {
				jsResponse("ㅜㅜ", "NoticeServlet?command=list", response);
			}
			
		}else if(command.equals("updateform")) {
			int nt_seq = Integer.parseInt(request.getParameter("ne_seq"));
			NoticeDto dto = dao.notice_Info(nt_seq);
			request.setAttribute("dto", dto);
			dispatch("notice_update.jsp", request, response);
			
		}else if(command.equals("update")) {
			int nt_seq = Integer.parseInt(request.getParameter("nt_seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			NoticeDto dto = new NoticeDto(null, null, title, content);
			int res = dao.notice_update(dto);
			
			if(res > 0) {
				jsResponse("수정성공", "NoticeServlet?command=list", response);
			}else {
				jsResponse("ㅜㅜ", "NoticeServlet?command=one"+nt_seq, response);
				
			}
			
		}else if(command.equals("delete")) {
			
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
