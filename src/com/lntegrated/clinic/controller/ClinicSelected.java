package com.lntegrated.clinic.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class HosSelected
 */
@WebServlet("/HosSelected")
public class ClinicSelected extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicSelected() {
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
		
		if(command.equals("nearHos")) {
			String addr = "http://apis.data.go.kr/B551182/hospInfoService/getHospBasisList?pageNo=1&numOfRows=10&ServiceKey="
					+ "ljl6RvnUG45n%2BUQ8%2BtFevuOTaOZ5wZsVmiGT6%2Bm0u5AwUvUUCAK%2FEQFuTYaim5YjRyYNDnWJAWnocoKR9TuBTA%3D%3D"
					+ "&xPos="+request.getParameter("x")+"&yPos="+request.getParameter("y")+"&radius=100&_type=json";
			URL url = new URL(addr);
			
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("CONTENT-TYPE", "text/html");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			String inputLine = "";
			String buffer = "";
			while((inputLine = in.readLine())!= null) {
				buffer += inputLine.trim();
			}
			System.out.println(buffer);
			JsonElement obj = null;
			
			JsonElement element = JsonParser.parseString(buffer);
			try {
				JsonObject jsonobj = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject().get("item").getAsJsonObject();
				obj = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject();
			}catch(IllegalStateException e) {
				try {
				JsonArray jsonarr = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject().get("item").getAsJsonArray();
				System.out.println(jsonarr);
				obj = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject();
				}catch(IllegalStateException e1) {
					System.out.println("공백");
				}
				}finally {
			
				PrintWriter out = response.getWriter();
				out.println(obj);
			}
		}else if(command.equals("hosinfo")) {
			String addr = "http://apis.data.go.kr/B551182/medicInsttDetailInfoService/getDetailInfo?ykiho="+request.getParameter("ykiho")+"&ServiceKey=";
			
			String serviceKey = "ljl6RvnUG45n%2BUQ8%2BtFevuOTaOZ5wZsVmiGT6%2Bm0u5AwUvUUCAK%2FEQFuTYaim5YjRyYNDnWJAWnocoKR9TuBTA%3D%3D";
			String type = "&_type=json";
			URL url = new URL(addr+serviceKey+type);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("CONTENT-TYPE", "text/html");
			PrintWriter out = response.getWriter();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			String inputLine = "";
			String buffer = "";
			while((inputLine = in.readLine())!= null) {
				buffer += inputLine.trim();
			}
			JsonElement element = JsonParser.parseString(buffer);
			JsonObject jsonobj = null;
			try {
				jsonobj = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject().get("item").getAsJsonObject();
			}catch(IllegalStateException e) {
				System.out.println("정보가 없습니다.");
			}finally {
				if(jsonobj == null) {
					out.println("u");
				}else {
					out.println(jsonobj);
				}
			}
		}else if(command.equals("searchcode")) {
			String addr = "http://apis.data.go.kr/B551182/medicInsttDetailInfoService/getMdlrtSbjectInfoList?ykiho="+request.getParameter("ykiho")+"&ServiceKey=";
			
			String serviceKey = "ljl6RvnUG45n%2BUQ8%2BtFevuOTaOZ5wZsVmiGT6%2Bm0u5AwUvUUCAK%2FEQFuTYaim5YjRyYNDnWJAWnocoKR9TuBTA%3D%3D";
			String type = "&_type=json";
			URL url = new URL(addr+serviceKey+type);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("CONTENT-TYPE", "text/html");
			PrintWriter out = response.getWriter();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			String inputLine = "";
			String buffer = "";
			while((inputLine = in.readLine())!= null) {
				buffer += inputLine.trim();
			}
			
			JsonElement element = JsonParser.parseString(buffer);
			JsonObject jsonarr = null;
			try {
				jsonarr = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items").getAsJsonObject();
				System.out.println(element.getAsJsonObject());
			}catch(IllegalStateException e) {
				System.out.println("정보가 없습니다.");
			}finally {
				if(jsonarr == null) {
					out.println("u");
				}else {
					out.println(jsonarr);
				}
			}
		}else if(command.equals("medical_clinic")) {
			String ykiho = request.getParameter("ykiho");
			String hosname = request.getParameter("hosName");
			String addr = request.getParameter("addr");
			request.setAttribute("ykiho", ykiho);
			request.setAttribute("hosName", hosname);
			request.setAttribute("addr", addr);
			disPatch("app_medical_clinic.jsp", request, response);
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
	protected void disPatch(String url,HttpServletRequest request , HttpServletResponse response) {
		RequestDispatcher dp = request.getRequestDispatcher(url);
		try {
			dp.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
