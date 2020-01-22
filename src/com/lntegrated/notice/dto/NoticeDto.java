package com.lntegrated.notice.dto;

import java.util.Date;

public class NoticeDto {
	private int nt_seq;
	private String id_d;
	private String title;
	private String content;
	private Date regdate;
	private int views;
	private String name_d;
	private String medical_d;
	private String grade_d;
	private String department;
	
	
	//�������� �˻�
	public NoticeDto(int nt_seq,String id_d,String title, String content,
			Date regdate,int views, String name_d, String medical_d , String grade_d,String department) {
		this.nt_seq = nt_seq;
		this.id_d = id_d;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.views = views;
		this.name_d = name_d;
		this.medical_d = medical_d;
		this.grade_d = grade_d;
		this.department = department;
	}
	//�������� ��� AND ����
	public NoticeDto(String id_d,String medical_d,String title ,String content) {
		this.id_d = id_d;
		this.medical_d = medical_d;
		this.title = title;
		this.content = content;
	}

	public int getNt_seq() {
		return nt_seq;
	}

	public void setNt_seq(int nt_seq) {
		this.nt_seq = nt_seq;
	}

	public String getId_d() {
		return id_d;
	}

	public void setId_d(String id_d) {
		this.id_d = id_d;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	public String getName_d() {
		return name_d;
	}
	public void setName_d(String name_d) {
		this.name_d = name_d;
	}
	public String getMedical_d() {
		return medical_d;
	}
	public void setMedical_d(String medical_d) {
		this.medical_d = medical_d;
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
