package com.lntegrated.calendar;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;


import com.lntegrated.clinic.dto.ClinicDto;
import com.lntegrated.telemedicine.dto.TeleDto;

public class Util {

	private String todates;

	public String getTodates() {
		return todates;
	}

	public void setTodates(String mdate) {
		// yyyy-mm-dd hh:mm:ss
		//date -> String 변환 
		String m = mdate.substring(0, 4) + "-" +
				mdate.substring(4, 6) + "-" +
				mdate.substring(6, 8) + " " +
				mdate.substring(8, 10) + ":" + 
				mdate.substring(10) + 
				":00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년mm월dd일 hh시mm분");
		Timestamp tm = Timestamp.valueOf(m); //문자열 값을 날짜형식으로 파싱해줌  
		todates = sdf.format(tm);
		
		
		
	}

	// 한자리수를 두자리수로 변환
	public static String isTwo(String msg) {

		return msg.length() < 2 ? "0" + msg : msg;

	}
	
	
	// 달력에 토용ㄹ 일요일 평일 색갈 설정
	public static String fontColor(int date, int dayOfWeek) {
		String color = "";
		
		if((dayOfWeek-1+date)%7 == 0) {
			color = "blue";
		}else if((dayOfWeek-1+date)%7 == 1) {
			color = "red";
		}else {
			color = "black";
		}
		
		return color;
	}
	
	
	public static String getCalView(int i, List<ClinicDto> clist , List<TeleDto> tlist) {
		String d = isTwo(i+"");
		String res = "";
//		ClinicDto cdt = new ClinicDto();
//		String stringcDate = String.valueOf(cdt.getReserv_date());
//		System.out.println(stringcDate);
//		TeleDto tdt = new TeleDto();
//		String StringtDate = String.valueOf(tdt.getReserv_date());
//		System.out.println(StringtDate);
		for(ClinicDto dto : clist) {	
			if(String.valueOf(dto.getReserv_date()).substring(8,10).equals(d)) {
				if(dto.getMedical_d() != null) {
					res+="<p>" + dto.getMedical_d() + "</p>";
				}
			}
		}
		for(TeleDto dto : tlist) {
			if(String.valueOf(dto.getReserv_date()).substring(8,10).equals(d)) {
				if(dto.getMedical_d() != null) {
					res+="<p>" + dto.getMedical_d() + "</p>";
				}
			}
		}
		
		return res;
	}
	

}
