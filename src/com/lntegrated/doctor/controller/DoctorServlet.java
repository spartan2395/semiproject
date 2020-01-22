package com.lntegrated.doctor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.lntegrated.doctor.dao.DoctorDao;
import com.lntegrated.doctor.dto.DoctorDto;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter out = null;
    DoctorDao dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
    	dao = new DoctorDao();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		DoctorDto dto = null;
		switch(command) {
			case "insert" :
				String grade = "";
				if(request.getParameter("grade").equals("의사")) {
					grade = "D";
				}
				int res = dao.insert(new DoctorDto(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name")
						,request.getParameter("number"),"M", request.getParameter("addr_home"), request.getParameter("addr_job"), request.getParameter("email"), 
						"D", request.getParameter("department")));
				if(res > 0) {
					response.sendRedirect("index.html");
				}else {
					out = response.getWriter();
					out.println("<script type = 'text/javascript'>"
							+ "alert('ERROR')"
							+ "</script>");
				}
			break;
			case "idchk" : 
					dto = dao.doctorInfo(request.getParameter("id").replace(" ", ""));
				if(dto != null) {
					response.getWriter().println(1);	
				}else {
					response.getWriter().println(0);
				}
			break;
			
			case "login":
				dto = dao.doctorLogin(request.getParameter("id"), request.getParameter("pw"));
				System.out.println("servelt: "+request.getParameter("id")+ request.getParameter("pw"));
				if (dto != null) {
					response.getWriter().println("");
				} else {
					System.out.println("dto null");
					response.getWriter().println("아이디와 패스워드를 확인해 주세요");
				}
				break;
		}
	}

}
