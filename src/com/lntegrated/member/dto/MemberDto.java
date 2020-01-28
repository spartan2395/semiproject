package com.lntegrated.member.dto;

public class MemberDto {
	private String id_u;
	private String pw_u;
	private String name_u;
	private String gender_u;
	private String number_u;
	private String addr_u;
	private String email_u;
	private String activation;
	private String bd_u;
	
	//���������� ����
	public MemberDto(String id_u , String pw_u, String name_u, String gender_u,
			String number_u,String addr_u,String email_u,String activation,String bd_u) {
		this.id_u = id_u;
		this.pw_u = pw_u;
		this.name_u = name_u;
		this.gender_u = gender_u;
		this.number_u = number_u;
		this.addr_u = addr_u;
		this.email_u = email_u;
		this.activation = activation;
		this.bd_u = bd_u;
	}
	// ȸ�� ���� AND ���� ����
	public MemberDto(String id_u,String pw_u,String name_u,String gender_u,
			String number_u,String addr_u,String email_u,String bd_u) {
		this.id_u = id_u;
		this.pw_u = pw_u;
		this.name_u = name_u;
		this.gender_u = gender_u;
		this.number_u = number_u;
		this.addr_u = addr_u;
		this.email_u = email_u;
		this.bd_u = bd_u;
	}
	
	
	public MemberDto() {
		super();
	}
	
	public MemberDto(String id_u,String activation) {
		this.id_u = id_u;
		this.activation = activation;
	}
	public String getId_u() {
		return id_u;
	}
	public void setId_u(String id_u) {
		this.id_u = id_u;
	}
	public String getPw_u() {
		return pw_u;
	}
	public void setPw_u(String pw_u) {
		this.pw_u = pw_u;
	}
	public String getName_u() {
		return name_u;
	}
	public void setName_u(String name_u) {
		this.name_u = name_u;
	}
	public String getGender_u() {
		return gender_u;
	}
	public void setGender_u(String gender_u) {
		this.gender_u = gender_u;
	}
	public String getNumber_u() {
		return number_u;
	}
	public void setNumber_u(String number_u) {
		this.number_u = number_u;
	}
	public String getAddr_u() {
		return addr_u;
	}
	public void setAddr_u(String addr_u) {
		this.addr_u = addr_u;
	}
	public String getEmail_u() {
		return email_u;
	}
	public void setEmail_u(String email_u) {
		this.email_u = email_u;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public String getBd_u() {
		return bd_u;
	}
	public void setBd_u(String bd_u) {
		this.bd_u = bd_u;
	}
	
	
	
}
