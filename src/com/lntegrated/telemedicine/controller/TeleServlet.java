package com.lntegrated.telemedicine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.tel_result.dao.TelResultDao;
import com.lntegrated.telemedicine.dao.TeleDao;
import com.lntegrated.telemedicine.dto.TeleDto;

import net.sf.json.JSONObject;

@WebServlet("/TeleServlet")
public class TeleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private TeleDao dao;
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String command = request.getParameter("command");
		System.out.println("TeleServlet command=============>" + command);
		TeleDao tdao = new TeleDao();
		TelResultDao resultdao = new TelResultDao();

		if (command.equals("resultupload")) { // =*==*==*==*==*==*==*==*==*==*==*==*=
			String id_d = request.getParameter("id_d");
			List<TeleDto> list = tdao.teleUploadList(id_d); // 현재시각 이전에 예약했던 모든 환자들의 리스트(의사 아이디로 필터)
			List<TeleDto> sendlist = new ArrayList<TeleDto>();
			for (int i = 0; i < list.size(); i++) {
				if (resultdao.telResultInfo(list.get(i).getTel_seq()) == null) {
					sendlist.add(list.get(i));
					System.out.println("TeleServlet resultupload: " + sendlist.get(i).getId_u());
				}
			}
			request.setAttribute("list", sendlist);
			dispatch("tel_result_upload.jsp", request, response);

		} else if (command.equals("resultdownload")) { // =*==*==*==*==*==*==*==*==*=
			String id_u = request.getParameter("id_u");
			List<TeleDto> list = tdao.teleInfoList(id_u);
			List<TeleDto> sendlist = new ArrayList<TeleDto>();
			for (TeleDto dto : list) {
				if (resultdao.telResultInfo(dto.getTel_seq()) != null) {
					sendlist.add(dto);
					System.out.println("TeleServlet resultdownload: " + dto.getTel_seq());
				}
			}
			request.setAttribute("list", sendlist);
			System.out.println("sendlist.size: " + sendlist.size());
			dispatch("medicalreport.jsp", request, response);

		} else if (command.equals("select")) { // =*==*==*==*==*==*==*==*==*==*==*==
			JSONObject obj = new JSONObject();
			int tel_seq = Integer.parseInt(request.getParameter("tel_seq"));
			TeleDto dto = tdao.teleInfo(tel_seq);
			// request.setAttribute("dto", dto);
//         String name_u = dto.getName_u();
			SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
			String reserv_date = df.format(dto.getReserv_date());
			// System.out.println(reserv_date);

			if (dto != null) {
				obj.clear();
				obj.put("tel_seq", tel_seq);
				obj.put("name_u", dto.getName_u());
				obj.put("reserv_date", reserv_date);

				response.getWriter().println(obj);
			}

		} else if (command.equals("telmedical")) { // =*==*==*==*==*==*==*==*==*==*==* 진료승인된 환자 리스트
			String id_d = request.getParameter("id_d");
			List<TeleDto> list = tdao.teleList(id_d); // 예약날짜>현재날짜
			List<TeleDto> sendlist = new ArrayList<TeleDto>(); // checkd=y 만 담을 배열
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getCheckd().equals("Y")) { // && list.get(i).getReserv_date()>=현재날짜
					int reserv_date = Integer.parseInt(df.format(list.get(i).getReserv_date()));
					// Calendar cal = Calendar.getInstance();
					// String today = ""+(cal.get(Calendar.YEAR))+(cal.get(Calendar.MONTH) +
					// 1)+(cal.get(Calendar.DAY_OF_MONTH));
					// int day = cal.get(Calendar.DAY_OF_MONTH);
					// System.out.println(today);
					Date date = new Date();
					int today = Integer.parseInt(df.format(date));
//    			  System.out.println(reserv_date);
//    			  System.out.println(today);
					if (reserv_date >= today) {
						sendlist.add(list.get(i));
					}
				}
			}
			request.setAttribute("list", sendlist);
			dispatch("telmedical.jsp", request, response);

		} else if (command.equals("medical_clinic")) {
			String ykiho = request.getParameter("ykiho");
			String hosname = request.getParameter("hosName");
			String addr = request.getParameter("addr");
			request.setAttribute("ykiho", ykiho);
			request.setAttribute("hosName", hosname);
			request.setAttribute("addr", addr);
			request.setAttribute("x", request.getParameter("x"));
			request.setAttribute("y", request.getParameter("y"));
			dispatch("app_medical_tel.jsp", request, response);

		}else if(command.equals("write")) {
	         String id_u = request.getParameter("id_u");
	         String id_d = "nexon";
	 
	         String year = request.getParameter("year");
	         String month = request.getParameter("month");
	         String date = request.getParameter("date");
	         String hour = request.getParameter("hour");
	         String minute = request.getParameter("minute");
	         String disease = request.getParameter("disease");

	         String reserv_date = year+"-"+month+"-"+date+" "+hour+":"+minute;
	         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	         Date to = null;
	         try {
				to = df.parse(reserv_date);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         TeleDto dto = new TeleDto(id_u, id_d, disease, to);
	         dao = new TeleDao();
	         int res = dao.teleInsert(dto);
	         if(res > 0) {
	             jsResponse("예약되었습니다", "appointment_tel.jsp", response);
	          }else {
	             jsResponse("ㅜㅜ", "appointmain_tel.jsp", response);
	          }
		}
	}

	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	  private void jsResponse(String msg , String url, HttpServletResponse response) throws IOException {
	      String s = "<script type= 'text/javascript'>"
	            +"alert('"+msg+"');"
	            +"location.href='"+url+"';"
	                  + "</script>";
	      PrintWriter out = response.getWriter();
	      out.print(s);
	   }
//   private static Date dateCompare(Date a, Date b){
//	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DAY_DATE_FORMAT);
//	   String dateA = simpleDateFormat.format(a);
//	   String dateB = simpleDateFormat.format(b);
//	   Calendar c = Calendar.getInstance();
//	   c.setTime(a);
//
//	   if(dateA.compareTo(dateB) < 0){
//	      c.add(c.DATE, +7);
//	      return c.getTime();
//	   }else{
//	      return a;
//	   }
//	}

}