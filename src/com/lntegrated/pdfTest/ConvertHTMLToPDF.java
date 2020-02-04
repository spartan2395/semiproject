package com.lntegrated.pdfTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.html.pdfelement.TabbedChunk;



public class ConvertHTMLToPDF {

	public static void convertPdf(JSONObject Jsonobj) throws IOException, DocumentException {
		String file = "/Users/jiaemin/Downloads/test.pdf";
	
		try {
			Document doc = new Document(PageSize.A4);
			PdfWriter.getInstance(doc, new FileOutputStream(file));
			
			doc.open();
			
			String resPath = "/Users/jiaemin/Downloads/malgun.ttf";
			BaseFont bf = BaseFont.createFont(resPath, BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
			
			Font TitleFont = new Font(bf, 30, Font.BOLD);
			Font ContentFont = new Font(bf,10, Font.NORMAL);
			Font textFont = new Font(bf,15,Font.BOLD);
			
			Paragraph p = new Paragraph("\n진단서",TitleFont);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			doc.add(p);

			p = new Paragraph("\n\n\n\n\n");
			
			doc.add(p);
			p = new Paragraph("원격 진료 번호 :  "+Jsonobj.get("tel_seq")+
								"\n\n환자 성명 :  "+Jsonobj.get("name_u")+
								"\n진료 일자 :  "+Jsonobj.get("reserv_date")+
								"\n\n병명 :  "+Jsonobj.get("dx_name")+
								"\n진단 내역 :  "+Jsonobj.get("dx_content")+
								"\n\n제출 용도 :  "+Jsonobj.get("purpose")+
								"\n\n비고 :  "+Jsonobj.get("remarks"),
								ContentFont);
			
			
			p.setAlignment(Paragraph.ALIGN_CENTER);
			doc.add(p);
			
			p = new Paragraph("\n\n\n\n\n위와 같이 진단함",textFont);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			doc.add(p);
			
			p = new Paragraph("\n\n\n\n\n\n\n발행인  "+Jsonobj.get("name_d")+
							"\n의료 기관  "+Jsonobj.get("medical_d")+
							"\n발행일  "+Jsonobj.get("iss_date"),
					ContentFont);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			doc.add(p);
			
			Image img = Image.getInstance("/Users/jiaemin/Downloads/logo.png");
			img.scalePercent(15);
			float x = (PageSize.A4.getWidth()-img.getScaledWidth())/2;
			float y = (PageSize.A4.getHeight()-img.getScaledHeight())/8;
			img.setAbsolutePosition(x, y);
			doc.add(img);
			
			doc.close();

			System.out.println("complete");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
