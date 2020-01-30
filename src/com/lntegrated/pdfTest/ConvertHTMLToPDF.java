package com.lntegrated.pdfTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.PdfWriter;



public class ConvertHTMLToPDF {

	public static void main(String[] args) throws IOException, DocumentException {
		String file = "/Users/jiaemin/Downloads/test.pdf";
	
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, new FileOutputStream(file));
		
		doc.open();
		
		Image jpg = Image.getInstance("/Users/jiaemin/Downloads/diagnosisBG.png");
		
		doc.add(jpg);
		
		
		
		
		
		 StyleSheet styles = new StyleSheet();
		 HashMap<String,Object> interfaceProps = new HashMap<String,Object>();
		
		DefaultFontProvider dfp=new DefaultFontProvider("/Users/jiaemin/Downloads/malgun.ttf");
	    //폰트 파일 설정 (한글 나오게 하기 위해 설정 필요함
	    interfaceProps.put(HTMLWorker.FONT_PROVIDER,dfp);

	    
	    StringBuffer sb = new StringBuffer();
	       sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
	       
	       sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");    
	    
	       sb.append("<html>");
	    
	    sb.append("<head>");
	    
	    sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
	    //sb.append("<link rel=\"stylesheet\" type=\"text/css\" href="+StringUtil.getPropWord("pdf.css.path")+" />");
	    sb.append("</head>");
	    
	    sb.append("<body>");
	    
	    sb.append("<table border='10'>");
	    
	    sb.append("  <tr>");
	    
	    sb.append("    <td> 테스트  </td>");
	    
	    sb.append("  <tr>");
	    
	    sb.append("</table>");
	    
	    sb.append("<img src='http://static.naver.net/www/u/2010/0611/nmms_215646753.gif'/>");
	    sb.append("</body>");
	    
	    
	    sb.append("</html>");
	    
	    System.out.println("html:"+sb.toString());
	    
	    StringReader strReader = new StringReader(sb.toString());
	    List<Element> objects = HTMLWorker.parseToList(strReader, styles, interfaceProps);
	    
	    for (int k = 0; k < objects.size(); ++k){
	     
	     doc.add((Element) objects.get(k));


		doc.close();
		System.out.println("close");
	}
	}
}
