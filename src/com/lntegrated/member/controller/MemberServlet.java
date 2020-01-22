package com.lntegrated.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.servlet.RequestDispatcher;
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
			dto = dao.memberlogin(request.getParameter("id"), request.getParameter("pw"));
			if (dto != null) {

			} else {

			}
			break;
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
