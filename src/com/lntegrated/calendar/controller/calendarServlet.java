package com.lntegrated.calendar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.clinic.dao.ClinicDao;
import com.lntegrated.clinic.dto.ClinicDto;
import com.lntegrated.telemedicine.dao.TeleDao;
import com.lntegrated.telemedicine.dto.TeleDto;


@WebServlet("/calendarServlet")
public class calendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public calendarServlet() {
        super();       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		ClinicDao cdao = new ClinicDao();
		TeleDao tdao = new TeleDao();
		System.out.println("<" + command +">");
		if(command.equals("schedual")) {
			String id_u = request.getParameter("id_u");
			List<ClinicDto> clist = cdao.clinicMemberList(id_u);
			List<TeleDto>  tlist = tdao.teleInfoList(id_u);
			System.out.println(clist.size());
			request.setAttribute("clist", clist);
			request.setAttribute("tlist", tlist);
			
			dispatch("member_mypage.jsp", request, response);
					
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void dispatch( String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
		
	}

}
