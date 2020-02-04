package com.lntegrated.telemedicine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.type.TypeException;

import com.lntegrated.tel_result.controller.TeleResultServlet;
import com.lntegrated.tel_result.dao.TelResultDao;
import com.lntegrated.tel_result.dto.TelResultDto;
import com.lntegrated.telemedicine.dao.TeleDao;
import com.lntegrated.telemedicine.dto.TeleDto;

import net.sf.json.JSONObject;


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
      System.out.println("TeleServlet command=============>"+command);
      TeleDao tdao = new TeleDao();
      TelResultDao resultdao = new TelResultDao();
      
      
      if(command.equals("resultupload")) { //=*==*==*==*==*==*==*==*==*==*==*==*=
    	  String id_d = request.getParameter("id_d");
         List<TeleDto> list = tdao.teleUploadList(id_d);	// 현재시각 이전에 예약했던 모든 환자들의 리스트(의사 아이디로 필터) 
         List<TeleDto> sendlist = new ArrayList<TeleDto>();
         for(int i=0;i<list.size();i++) {
    	   if(resultdao.telResultInfo(list.get(i).getTel_seq()) == null) {
      		 sendlist.add(list.get(i));
      		 System.out.println("TeleServlet resultupload: "+sendlist.get(i).getId_u());
    	   }
         }
         request.setAttribute("list", sendlist);
         dispatch("tel_result_upload.jsp", request, response);
         
      }else if(command.equals("resultdownload")){  //=*==*==*==*==*==*==*==*==*=
    	  String id_u = request.getParameter("id_u");
    	  List<TeleDto> list = tdao.teleInfoList(id_u);
    	  List<TeleDto> sendlist = new ArrayList<TeleDto>();
    	  for(TeleDto dto :list) {
    		  if(resultdao.telResultInfo(dto.getTel_seq())!=null) {
    			  sendlist.add(dto);
    			  System.out.println("TeleServlet resultdownload: "+dto.getTel_seq());
    		  }  
    	  }
    	  request.setAttribute("list", sendlist);
		  System.out.println("sendlist.size: "+sendlist.size());
	         dispatch("medicalreport.jsp", request, response);
    	  
      }else if(command.equals("select")) {  //=*==*==*==*==*==*==*==*==*==*==*==
         JSONObject obj = new JSONObject();
         int tel_seq = Integer.parseInt(request.getParameter("tel_seq"));
         TeleDto dto = tdao.teleInfo(tel_seq);
         // request.setAttribute("dto", dto);
//         String name_u = dto.getName_u();
         SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
         String reserv_date = df.format(dto.getReserv_date());
         //System.out.println(reserv_date);
         
         if(dto!=null) {
            obj.clear();
            obj.put("tel_seq", tel_seq);
            obj.put("name_u", dto.getName_u());
            obj.put("reserv_date",reserv_date);
            
            response.getWriter().println(obj);
         }
         
      } else if(command.equals("telmedical")) {  //=*==*==*==*==*==*==*==*==*==*==*
    	  
      }
      
   }
   
   public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher dispatch = request.getRequestDispatcher(url);
      dispatch.forward(request, response);
   }

}