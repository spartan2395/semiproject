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
	//예약 신청
	public TeleDto(String id_u , String id_d ,String disease, Date reserv_date) {
		this.id_u = id_u;
		this.id_d = id_d;
		this.disease = disease;
		this.reserv_date = reserv_date;
	}
	//예약 일자 변경
	public TeleDto(int tel_seq , Date reserv_date) {
		this.tel_seq = tel_seq;
		this.reserv_date = reserv_date;
	}
	public int getTel_seq() {
		return tel_seq;
	}
	public void setTel_seq(int tel_seq) {
		this.tel_seq = tel_seq;
	}
	public String getId_u() {
		return id_u;
	}
	public void setId_u(String id_u) {
		this.id_u = id_u;
	}
	public String getName_u() {
		return name_u;
	}
	public void setName_u(String name_u) {
		this.name_u = name_u;
	}
	public String getNumber_u() {
		return number_u;
	}
	public void setNumber_u(String number_u) {
		this.number_u = number_u;
	}
	public String getId_d() {
		return id_d;
	}
	public void setId_d(String id_d) {
		this.id_d = id_d;
	}
	public String getName_d() {
		return name_d;
	}
	public void setName_d(String name_d) {
		this.name_d = name_d;
	}
	public String getNumber_d() {
		return number_d;
	}
	public void setNumber_d(String number_d) {
		this.number_d = number_d;
	}
	public String getMedical_d() {
		return medical_d;
	}
	public void setMedical_d(String medical_d) {
		this.medical_d = medical_d;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getChat_no() {
		return chat_no;
	}
	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}
	public String getCheckd() {
		return checkd;
	}
	public void setCheckd(String checkd) {
		this.checkd = checkd;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Date getReserv_date() {
		return reserv_date;
	}
	public void setReserv_date(Date reserv_date) {
		this.reserv_date = reserv_date;
	}
}
