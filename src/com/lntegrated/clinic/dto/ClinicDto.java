package com.lntegrated.clinic.dto;

import java.util.Date;

public class ClinicDto {
	private String id_u;
	private String id_d;
	private String name_u;
	private String name_d;
	private String disease;
	private Date reserv_date;
	private String category;
	private String checkd;
	private String medical_d;
	//ȯ�� ���� ����Ʈ
	public ClinicDto(String id_u,String id_d , String name_u, String name_d,
			String disease, Date reserv_date , String category , String checkd) {
		this.id_u = id_u;
		this.id_d = id_d;
		this.name_u = name_u;
		this.name_d = name_d;
		this.disease = disease;
		this.reserv_date = reserv_date;
		this.category = category;
		this.checkd = checkd;
	}
	
	public ClinicDto(String id_u,String id_d,String disease,Date reserv_date , String category , String checkd) {
		this.id_u = id_u;
		this.id_d = id_d;
		this.disease = disease;
		this.reserv_date = reserv_date;
		this.category = category;
		this.checkd = checkd;
	}
	
	
	public ClinicDto(String id_u,String id_d,String disease,Date reserv_date , String category , String checkd,String medical_d) {
		this.id_u = id_u;
		this.id_d = id_d;
		this.disease = disease;
		this.reserv_date = reserv_date;
		this.category = category;
		this.checkd = checkd;
		this.medical_d = medical_d;
	}
	
	public String getId_u() {
		return id_u;
	}

	public void setId_u(String id_u) {
		this.id_u = id_u;
	}

	public String getId_d() {
		return id_d;
	}

	public void setId_d(String id_d) {
		this.id_d = id_d;
	}

	public String getName_u() {
		return name_u;
	}

	public void setName_u(String name_u) {
		this.name_u = name_u;
	}

	public String getName_d() {
		return name_d;
	}

	public void setName_d(String name_d) {
		this.name_d = name_d;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCheckd() {
		return checkd;
	}

	public void setCheckd(String checkd) {
		this.checkd = checkd;
	}

	public String getMedical_d() {
		return medical_d;
	}

	public void setMedical_d(String medical_d) {
		this.medical_d = medical_d;
	}
	
	
	
}
