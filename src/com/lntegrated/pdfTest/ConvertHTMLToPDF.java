package com.lntegrated.pdfTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

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



public class ConvertHTMLToPDF {

	public static void convertPdf(String content) throws IOException, DocumentException {
		String file = "/Users/jiaemin/Downloads/test.pdf";
	
		try {
			Document doc = new Document(PageSize.A4);
			PdfWriter.getInstance(doc, new FileOutputStream(file));
			
			doc.open();
			
			String resPath = "/Users/jiaemin/Downloads/malgun.ttf";
			BaseFont bf = BaseFont.createFont(resPath, BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
			
			Font TitleFont = new Font(bf, 30, Font.BOLD);
			Font ContentFont = new Font(bf,10, Font.NORMAL);
			
			Paragraph p = new Paragraph("진단서",TitleFont);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			doc.add(p);

			p = new Paragraph("\n\n\n\n\n\n");
			doc.add(p);
			p = new Paragraph("내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용 \n내용",ContentFont);
			p.setAlignment(Paragraph.ALIGN_CENTER);
			doc.add(p);
			
			doc.close();

			System.out.println("complete");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
