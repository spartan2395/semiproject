package com.lntegrated.calendar;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
	
	
	public static String getCalViewDoc(int month, int i, List<ClinicDto> clist , List<TeleDto> tlist) {
		String d = isTwo(i+"");
		String m = isTwo(month+"");
		String res = "";
//		ClinicDto cdt = new ClinicDto();
//		String stringcDate = String.valueOf(cdt.getReserv_date());
//		System.out.println(stringcDate);
//		TeleDto tdt = new TeleDto();
//		String StringtDate = String.valueOf(tdt.getReserv_date());
//		System.out.println(StringtDate);
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		if(clist != null) {
			for(ClinicDto cdto : clist) {	

				if(String.valueOf(df.format(cdto.getReserv_date())).substring(5,7).equals(m) &&
						String.valueOf(df.format(cdto.getReserv_date())).substring(8,10).equals(d)) 
				{
					System.out.println(df.format(cdto.getReserv_date()).substring(5,7));
					System.out.println("m="+m);
					System.out.println(df.format(cdto.getReserv_date()).substring(8,10));
					System.out.println("d="+d);
					if(cdto.getName_u() != null) {
						res+="<p style='background-color:pink; color:white;'>" + cdto.getName_u() + "</p>";
					} else {
						System.out.println("cdtonull");
					}
				}
			}
		}
		if(tlist != null) {
			for(TeleDto tdto : tlist) {
				if(String.valueOf(df.format(tdto.getReserv_date())).substring(5,7).equals(m) &&
						String.valueOf(df.format(tdto.getReserv_date())).substring(8,10).equals(d)) 
				{
					if(tdto.getName_u() != null) {
						System.out.println("wyo no");
						res+="<p style='background-color:skyblue; color:white;'>" + tdto.getName_u() + "</p>";
					}else {
						System.out.println("tdtonull");
					}
				}
			}
		}
				return res;
	}
	
	public static String getCalViewPatient(int month, int i, List<ClinicDto> clist , List<TeleDto> tlist) {
		String d = isTwo(i+"");
		String m = isTwo(month+"");
		String res = "";
//		ClinicDto cdt = new ClinicDto();
//		String stringcDate = String.valueOf(cdt.getReserv_date());
//		System.out.println(stringcDate);
//		TeleDto tdt = new TeleDto();
//		String StringtDate = String.valueOf(tdt.getReserv_date());
//		System.out.println(StringtDate);
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		if(clist != null) {
			for(ClinicDto cdto : clist) {	

				if(String.valueOf(df.format(cdto.getReserv_date())).substring(5,7).equals(m) &&
						String.valueOf(df.format(cdto.getReserv_date())).substring(8,10).equals(d)) 
				{
					System.out.println(df.format(cdto.getReserv_date()).substring(5,7));
					System.out.println("m="+m);
					System.out.println(df.format(cdto.getReserv_date()).substring(8,10));
					System.out.println("d="+d);
					if(cdto.getMedical_d() != null&&cdto.getCheckd().equals("N")) {
						res+="<p style='background-color:gray; color:white;'>" + cdto.getMedical_d() + " "+cdto.getId_d() + "</p>";
					} else if (cdto.getMedical_d() !=null && cdto.getCheckd().equals("Y")) {
						res+="<p style='background-color:pink; color:white;'>" + cdto.getMedical_d() + " "+cdto.getId_d() + "</p>";
					} else {
						System.out.println("cdtonull");
					}
				}
			}
		}
		if(tlist != null) {
			for(TeleDto tdto : tlist) {
				if(String.valueOf(df.format(tdto.getReserv_date())).substring(5,7).equals(m) &&
						String.valueOf(df.format(tdto.getReserv_date())).substring(8,10).equals(d)) 
				{
					if(tdto.getMedical_d() != null&&tdto.getCheckd().equals("N")) {
						res+="<p style='background-color:gray; color:white;'>" + tdto.getMedical_d()+" "+tdto.getName_d() + "</p>";
					}else if(tdto.getMedical_d() != null&&tdto.getCheckd().equals("Y")) {
						res+="<p style='background-color:skyblue; color:white;'>" + tdto.getMedical_d()+" "+tdto.getName_d() + "</p>";
					} else {
						System.out.println("tdtonull");
					}
				}
			}
		}
				return res;
	}

}
