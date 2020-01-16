package com.lntegrated.doctor.dto;
//생년월일 추가

public class DoctorDto {
	private String id_d;
	private String pw_d;
	private String name_d;
	private String gender_d;
	private String number_d;
	private String addr_d;
	private String medical_d;
	private String email_d;
	private String grade_d;
	private String department;
	
	//�ǻ� ���� �˻� AND ���� AND ȸ�� ����
	public DoctorDto(String id_d, String pw_d, String name_d,String number_d,String gender_d,
			String addr_d,String medical_d,String email_d,String grade_d,String department) {
		this.id_d = id_d;
		this.pw_d = pw_d;
		this.name_d = name_d;
		this.gender_d = gender_d;
		this.number_d = number_d;
		this.addr_d = addr_d;
		this.medical_d = medical_d;
		this.email_d = email_d;
		this.grade_d = grade_d;
		this.department = department;
	}

	public String getId_d() {
		return id_d;
	}

	public void setId_d(String id_d) {
		this.id_d = id_d;
	}

	public String getPw_d() {
		return pw_d;
	}

	public void setPw_d(String pw_d) {
		this.pw_d = pw_d;
	}

	public String getName_d() {
		return name_d;
	}

	public void setName_d(String name_d) {
		this.name_d = name_d;
	}

	public String getGender_d() {
		return gender_d;
	}

	public void setGender_d(String gender_d) {
		this.gender_d = gender_d;
	}

	public String getNumber_d() {
		return number_d;
	}

	public void setNumber_d(String number_d) {
		this.number_d = number_d;
	}

	public String getAddr_d() {
		return addr_d;
	}

	public void setAddr_d(String addr_d) {
		this.addr_d = addr_d;
	}

	public String getMedical_d() {
		return medical_d;
	}

	public void setMedical_d(String medical_d) {
		this.medical_d = medical_d;
	}

	public String getEmail_d() {
		return email_d;
	}

	public void setEmail_d(String email_d) {
		this.email_d = email_d;
	}

	public String getGrade_d() {
		return grade_d;
	}

	public void setGrade_d(String grade_d) {
		this.grade_d = grade_d;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
