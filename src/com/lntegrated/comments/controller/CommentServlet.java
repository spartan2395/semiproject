package com.lntegrated.comments.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.comments.dao.CommDao;
import com.lntegrated.comments.dto.CommDto;

/**
 * Servlet implementation class CommentServelt
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		CommDao dao = new CommDao();
		
		if(command.equals("list")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			List<CommDto> commList = dao.commList(board_no);
			
			request.setAttribute("commList", commList);
			dispatch("commu_frselect.jsp", request, response);
		}
		else if(command.equals("insert")) {
			
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			System.out.println(board_no);
			String content_a = request.getParameter("content");
			System.out.println(content_a);
			String id_u = "788";
			
			CommDto dto = new CommDto(board_no, content_a, id_u);
			
			int res = dao.commInsert(dto);
			if(res >0) {
				jsResponse("댓글 작성", "BoardFrServlet?command=select&board_no="+board_no, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type = 'text/javascript'>"
					+ "alert('" + msg + "');"
					+ "location.href = '"+url+"';"
					+ "</script>";
		PrintWriter out = response.getWriter();
		out.println(s);
	}

}
