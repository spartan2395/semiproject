package com.lntegrated.tel_result.dto;

import java.util.Date;

public class TelResultDto {
	private int tel_seq;
	private String id_u;
	private String id_d;
	private Date reserv_date;
	private String dx_name;
	private String dx_content;
	private String purpose;
	private String remarks;
	private Date iss_date;
	
	public TelResultDto(int tel_seq,String id_u,String id_d,Date reserv_date,
			String dx_name,String dx_content,String purpose,String remarks,Date iss_date) {
		this.tel_seq = tel_seq;
		this.id_d = id_d;
		this.id_u = id_u;
		this.reserv_date = reserv_date;
		this.dx_name = dx_name;
		this.dx_content = dx_content;
		this.purpose = purpose;
		this.remarks = remarks;
		this.iss_date = iss_date;
	}
	
	public TelResultDto(int tel_seq,String dx_name, String dx_content, String purpose, String remarks) {
		this.tel_seq = tel_seq;
		this.dx_name = dx_name;
		this.dx_content = dx_content;
		this.purpose = purpose;
		this.remarks = remarks;
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

	public String getId_d() {
		return id_d;
	}

	public void setId_d(String id_d) {
		this.id_d = id_d;
	}

	public Date getReserv_date() {
		return reserv_date;
	}

	public void setReserv_date(Date reserv_date) {
		this.reserv_date = reserv_date;
	}

	public String getDx_name() {
		return dx_name;
	}

	public void setDx_name(String dx_name) {
		this.dx_name = dx_name;
	}

	public String getDx_content() {
		return dx_content;
	}

	public void setDx_content(String dx_content) {
		this.dx_content = dx_content;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getIss_date() {
		return iss_date;
	}

	public void setIss_date(Date iss_date) {
		this.iss_date = iss_date;
	}
}
