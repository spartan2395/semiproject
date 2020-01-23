package com.lntegrated.doctor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
    	dao = new DoctorDao();

    }

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorServlet() {
		dao = new DoctorDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		System.out.println("command=====================>"+command);
		DoctorDto dto = null;
		PrintWriter out = response.getWriter();
		switch(command) {

				// 회원 가입
			case "register" :/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
				String bday = request.getParameter("bd_yy")+"/"+request.getParameter("bd_mm")+"/"+request.getParameter("bd_d");
				int res = dao.insert(
						new DoctorDto(
								request.getParameter("id"),
								request.getParameter("pw"),
								request.getParameter("name"),
								request.getParameter("tel"),
								request.getParameter("gender"),
								request.getParameter("addr"),
								request.getParameter("medical"),
								request.getParameter("email"),
								"D",
								request.getParameter("department"),
								bday));

				if(res > 0) {
					System.out.println("insert successed");
					HttpSession session = request.getSession() ;
					System.out.println(session.getAttribute("key"));
					session.removeAttribute("key");

					RequestDispatcher dispatcher = request.getRequestDispatcher("doctormain.jsp");
					dispatcher.forward(request, response);

				}else {
					System.out.println("REGISTER FAIL");
					out.println("\n" +
							"<script type='text/javascript'>\n" +
							"    alert(\"회원가입에 실패하였습니다. \")\n"
							+ "history.back();" +
							"</script>");
				}
				break;

				// 로그인
			case "login": /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
				JSONObject obj = new JSONObject();
				dto = dao.doctorLogin(request.getParameter("id"), request.getParameter("pw"));
				System.out.println("servelt: "+request.getParameter("id")+ request.getParameter("pw"));

				if (dto != null) {
					System.out.println("dto okok");
					obj.clear();
					obj.put("id", dto.getId_d());
					obj.put("name", dto.getName_d());
					obj.put("gender",dto.getGender_d());
					obj.put("number", dto.getNumber_d());
					obj.put("addr", dto.getAddr_d());
					obj.put("medial", dto.getMedical_d());
					obj.put("email", dto.getEmail_d());
					obj.put("grade", dto.getGrade_d());
					obj.put("department", dto.getDepartment());

					obj.put("result", "");
					response.getWriter().print(obj);
				} else {
					System.out.println("dto null");
					obj.clear();
					obj.put("result", "아이디와 비밀번호를 확인해 주세요");
					response.getWriter().print(obj);
				}
				break;

				// 아이디 중복 체크
			case "idchk" : /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
					dto = dao.doctorInfo(request.getParameter("id").replace(" ", ""));
				if(dto != null) {
					response.getWriter().println(1);
				}else {
					response.getWriter().println(0);
				}
				break;

			case "emailchk":/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
				String email_u = request.getParameter("email");
				boolean chk = dao.emailchk(email_u);
				System.out.println(email_u);
				System.out.println(chk);

				if(chk=false) {
					out.println(1);	// 이미 사용 중인 이메일
				} else {
					out.println(0);
			break;

				}
				break;

			case "emailcodesend":/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
				String email = request.getParameter("email");

				String host = "smtp.gmail.com";
				String user = "zzz0qq";
				String password = "lanyou12";

				String to_email = email;

				Properties props = new Properties();
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", 587);
				props.put("mail.smtp.auth", "true");


				StringBuffer temp =new StringBuffer();
	            Random rnd = new Random();
	            for(int i=0;i<10;i++)
	            {
	                int rIndex = rnd.nextInt(3);
	                switch (rIndex) {
	                case 0:
	                    // a-z
	                    temp.append((char) ((int) (rnd.nextInt(26)) + 97));
	                    break;
	                case 1:
	                    // A-Z
	                    temp.append((char) ((int) (rnd.nextInt(26)) + 65));
	                    break;
	                case 2:
	                    // 0-9
	                    temp.append((rnd.nextInt(10)));
	                    break;
	                }
	            }

	            String authenticationKey = temp.toString();
	            System.out.println(authenticationKey);

	            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            	protected PasswordAuthentication getPasswordAuthentication() {
	            		return new PasswordAuthentication(user,password);
	            	}
	            });

	            try {
	                MimeMessage msg = new MimeMessage(session);
	                System.out.println("Sending...");

					msg.setFrom(new InternetAddress(user,"당근 병원"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
					msg.setSubject("당근 병원 인증 메일입니다.");

					msg.setText("인증번호 : "+"["+temp+"]");

					Transport.send(msg, msg.getAllRecipients());
					System.out.println("이메일 전송");
				} catch (AddressException e) {
					 System.out.println("ERROR MAIL");
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            HttpSession saveKey = request.getSession();
	            saveKey.setAttribute("code", authenticationKey);

	            out.println("인증번호를 입력해주세요.");

	            break;

			case "code":/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
				HttpSession saveKeyChk = request.getSession();
				String inputCode = request.getParameter("inputcode").replace(" ", "");
				String code = (String)saveKeyChk.getAttribute("code");
				System.out.println("code:"+code);
				System.out.println("inputcode:"+inputCode);
				if (inputCode.equals(code)) {
					System.out.println("일치!!");
					out.println(0);	// 코드 일치

				} else {
					System.out.println("불일치!!");
					out.println(1);
				}

				 break;




		}
	}

}
