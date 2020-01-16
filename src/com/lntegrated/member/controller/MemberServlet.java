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
		String command = request.getParameter("command");
		System.out.println(command);
		
		MemberDao dao = new MemberDao();
		
		if(command.equals("MemberChk")) {
			String id_u = request.getParameter("id");
			if(dao.memberInfo(id_u) != null) {
				response.getWriter().println(1);
			}else {
				response.getWriter().println(0);
			}
			
		}
		else if(command.equals("Memberinsert")) {
			String id_u = request.getParameter("id_u");
			String pw_u = request.getParameter("pw_u");
			String name_u = request.getParameter("name_u");
			String gender_u = request.getParameter("gender_u");
			String number_u = request.getParameter("number_u");
			String addr_u = request.getParameter("addr_u");
			String email_u = request.getParameter("email_u");
			MemberDto dto = new MemberDto();
			if(gender_u.equals("남")) {
				gender_u = "M";
			}
			else {
				gender_u = "F";
			}
			dto.setId_u(id_u);
			dto.setPw_u(pw_u);
			dto.setName_u(name_u);
			dto.setGender_u(gender_u);
			dto.setNumber_u(number_u);
			dto.setAddr_u(addr_u);
			dto.setEmail_u(email_u);
			
			int res = dao.memberinsert(dto);
			System.out.println(res);
			if(res > 0) {
				jsResponse("회원가입 성공", "MemberServlet?command=", response);
			}
			else {
				jsResponse("회원가입 실패", "MemberServlet", response);
			}
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
