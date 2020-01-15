package com.lntegrated.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.member.dao.MemberDao;
import com.lntegrated.member.dto.MemberDto;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		PrintWriter out = response.getWriter();
		
		int res = 0;
		
		dto.setId_u(request.getParameter("id_u"));
		dto.setPw_u(request.getParameter("pw_u"));
		dto.setName_u(request.getParameter("name_u"));
		dto.setGender_u(request.getParameter("gender_u"));
		dto.setNumber_u(request.getParameter("number_u"));
		dto.setAddr_u(request.getParameter("addr_u"));
		dto.setEmail_u(request.getParameter("email_u"));
		
		res = dao.memberinsert(dto);
		if(res > 0) {
			jsResponse("회원가입 성공", "hello.jsp", response);
		}
		else {
			jsResponse("회원가입 실패", "index.jsp", response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doGet(request, response);
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
