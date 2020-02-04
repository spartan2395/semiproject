package com.lntegrated.tel_result.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.lntegrated.doctor.dao.DoctorDao;
import com.lntegrated.doctor.dto.DoctorDto;
import com.lntegrated.member.dao.MemberDao;
import com.lntegrated.member.dto.MemberDto;
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
		TelResultDto dto = null;
		DoctorDto doc_dto = null;
		DoctorDao doc_dao = new DoctorDao();
		MemberDto mem_dto = null;
		MemberDao mem_dao = new MemberDao();
		
		if(command.equals("insert")) {
			int tel_seq = Integer.parseInt(request.getParameter("tel_seq"));
			System.out.println(tel_seq);
			String dx_name = request.getParameter("dx_name");
			String dx_content = request.getParameter("dx_content");
			String purpose = request.getParameter("purpose");
			String remarks = request.getParameter("remarks");
			
			dto = new TelResultDto(tel_seq, dx_name, dx_content, purpose, remarks);
			
			int res = dao.relResultInsert(dto);
			if(res>0) {
				jsResponse("업로드 성공", "TeleServlet?command=resultupload&id_d=nexon", response);
			}
		
		} else if (command.equals("select")) {
			dto = dao.telResultInfo((Integer.parseInt(request.getParameter("tel_seq"))));
			doc_dto = doc_dao.doctorInfo(dto.getId_d());
			mem_dto = mem_dao.memberInfo(dto.getId_u());
			JSONObject obj = new JSONObject();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
			 
			obj.put("tel_seq", String.valueOf(dto.getTel_seq()));
			obj.put("id_u", dto.getId_u());
			obj.put("id_d", dto.getId_d());
			obj.put("reserv_date", df.format(dto.getReserv_date()));
			obj.put("dx_name", dto.getDx_name());
			obj.put("dx_content", dto.getDx_content());
			obj.put("purpose", dto.getPurpose());
			obj.put("remarks", dto.getRemarks());
			obj.put("iss_date", df.format(dto.getIss_date()));
			obj.put("checkd", dto.getCheckd());
			obj.put("name_d",doc_dto.getName_d());
			obj.put("medical_d", doc_dto.getMedical_d());
			obj.put("name_u",mem_dto.getName_u());
			
			
			response.getWriter().print(obj);
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
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      RequestDispatcher dispatch = request.getRequestDispatcher(url);
	      dispatch.forward(request, response);
	   }


}
