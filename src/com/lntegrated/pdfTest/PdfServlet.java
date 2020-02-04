package com.lntegrated.pdfTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.itextpdf.text.DocumentException;

@WebServlet("/PdfServlet")
public class PdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PdfServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=utf-8");
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=utf-8");
		String command = request.getParameter("command");
		System.out.println("PdfServlet-command=============>"+command);
		
		if(command.equals("convertPdf")) {
			String Jsonobj = request.getParameter("Jsonobj");
			System.out.println(Jsonobj);
			JSONParser parser = new JSONParser();
			
			JSONObject obj = null;
			
			try {
				obj = (JSONObject) parser.parse(Jsonobj);
				System.out.println(obj.get("tel_seq"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			ConvertHTMLToPDF convert = new ConvertHTMLToPDF();
			try {
				convert.convertPdf(obj);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
