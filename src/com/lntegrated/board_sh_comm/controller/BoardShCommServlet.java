package com.lntegrated.board_sh_comm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.board_sh.dto.BoardShDto;
import com.lntegrated.board_sh_comm.dao.BoardShCommDao;
import com.lntegrated.board_sh_comm.dto.BoardShCommDto;


@WebServlet("/BoardShCommServlet")
public class BoardShCommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		BoardShCommDao dao = new BoardShCommDao();
		
		if(command.equals("insert")) {
			int board_sh_no = Integer.parseInt(request.getParameter("board_sh_no"));
			String content = request.getParameter("content");
			String id_u="788";
			
			System.out.println(content);
			System.out.println(board_sh_no);
			
			BoardShCommDto dto = new BoardShCommDto(board_sh_no, content, id_u);
			int res = dao.insert(dto);
			

			
		}
		
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
