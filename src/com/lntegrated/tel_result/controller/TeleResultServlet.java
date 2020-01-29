package com.lntegrated.tel_result.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.tel_result.dao.TelResultDao;
import com.lntegrated.tel_result.dto.TelResultDto;

@WebServlet("/TeleResultServlet")
public class TeleResultServlet extends HttpServlet {
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
		TelResultDao dao = new TelResultDao();
		
		if(command.equals("insert")) {
			int tel_seq = Integer.parseInt(request.getParameter("tel_seq"));
			String dx_name = request.getParameter("dx_name");
			String dx_content = request.getParameter("dx_content");
			String purpose = request.getParameter("purpose");
			String remarks = request.getParameter("remarks");
			
			TelResultDto dto = new TelResultDto(tel_seq, dx_name, dx_content, purpose, remarks);
			
			int res = dao.relResultInsert(dto);
			if(res>0) {
				jsResponse("업로드 성공", "", response);
			}
		
		}
		
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
