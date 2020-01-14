package com.lntegrated.telemedicine.dto;

import java.util.Date;

public class TeleDto {
	private int tel_seq;
	private String id_u;
	private String name_u;
	private String number_u;
	private String id_d;
	private String name_d;
	private String number_d;
	private String medical_d;
	private String department;
	private int chat_no;
	private String checkd;
	private String disease;
	private Date reserv_date;
	//예약 검색
	public TeleDto(int tel_seq,String id_u,String name_u,String number_u,String id_d,String name_d,
			String number_d,String medical_d,String department,int chat_no,String checkd,String disease,
			Date reserv_date) {
		this.tel_seq = tel_seq;
		this.id_d = id_d;
		this.id_u = id_u;
		this.name_u = name_u;
		this.name_d = name_d;
		this.number_u = number_u;
		this.number_d = number_d;
		this.medical_d = medical_d;
		this.department = department;
		this.chat_no = chat_no;
		this.checkd = checkd;
		this.disease = disease;
		this.reserv_date = reserv_date;
	}
	//
	public TeleDto() {
		
	}
}
