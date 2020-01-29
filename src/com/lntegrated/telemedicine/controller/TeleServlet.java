package com.lntegrated.telemedicine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.tel_result.controller.TeleResultServlet;
import com.lntegrated.tel_result.dao.TelResultDao;
import com.lntegrated.tel_result.dto.TelResultDto;
import com.lntegrated.telemedicine.dao.TeleDao;
import com.lntegrated.telemedicine.dto.TeleDto;


@WebServlet("/TeleServlet")
public class TeleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command =request.getParameter("command");
		TeleDao dao = new TeleDao();
		
		if(command.equals("resultupload")) {
			String id_d = request.getParameter("id_d");
			List<TeleDto> list = dao.teleUploadList(id_d);
			
			request.setAttribute("list", list);
			dispatch("tel_result_upload.jsp", request, response);
		} else if(command.equals("select")) {
			int tel_seq = Integer.parseInt(request.getParameter("tel_seq"));
			TeleDto dto = dao.teleInfo(tel_seq);
			request.setAttribute("dto", dto);
			
			PrintWriter out = response.getWriter();
			
		}
		
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

}
