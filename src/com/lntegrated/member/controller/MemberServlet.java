package com.lntegrated.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.lntegrated.member.dao.MemberDao;
import com.lntegrated.member.dto.MemberDto;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDao dao = new MemberDao();
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
		
//		dao.memberinsert(new MemberDto(
//				request.getParameter("id"),
//				request.getParameter("pw"),
//				request.getParameter("name"),
//				request.getParameter("gender"),
//				request.getParameter("number"),
//				request.getParameter("addr"),
//				request.getParameter("email")
//				));
//		
		String command = request.getParameter("command");
		MemberDto dto = null;
		switch(command) {
		case "login" :
			JSONObject obj = new JSONObject();
			dto = dao.memberlogin(request.getParameter("id"), request.getParameter("pw"));
			System.out.println("Member servelt: "+request.getParameter("id")+ request.getParameter("pw"));
			
			if (dto != null) {
				System.out.println("dto okok");
				obj.clear();
				obj.put("id", dto.getId_u());
				obj.put("name", dto.getPw_u());
				obj.put("gender", dto.getGender_u());
				obj.put("number", dto.getNumber_u());
				obj.put("addr", dto.getAddr_u());
				obj.put("email",dto.getEmail_u());
				obj.put("result", "");
				response.getWriter().print(obj);
			} else {
				System.out.println("dto null");
				obj.clear();
				obj.put("result", "아이디와 비밀번호를 확인해 주세요");
				response.getWriter().print(obj);
			}
			break;
		case "idchk":
			System.out.println(request.getParameter("id"));
			dto = dao.memberInfo(request.getParameter("id").replace(" ", ""));
			
			if(dto != null) {
				response.getWriter().println(1);
			} else {
				response.getWriter().println(0);
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

}
