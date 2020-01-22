package com.lntegrated.board_sh.dto;

import java.util.Date;

public class BoardShDto {
	private int board_sh_no;
	private String id_u;
	private String title;
	private String content;
	private String medical_name;
	private Date regdate;
	private int views;
	
	//select
	public BoardShDto(int board_sh_no , String id_u,String title, String content,
			String medical_name, Date regdate, int views) {
		this.board_sh_no = board_sh_no;
		this.id_u= id_u;
		this.title = title;
		this.content = content;
		this.medical_name = medical_name;
		this.regdate = regdate;
		this.views = views;
	}
	//insert
	public BoardShDto(String id_u,String title, String content,
			String medical_name) {
		this.id_u = id_u;
		this.title = title;
		this.content = content;
		this.medical_name = medical_name;
	}
	
	//update
	public BoardShDto(int board_sh_no , String title, String content , String medical_name) {
		this.board_sh_no = board_sh_no;
		this.title = title;
		this.content = content;
		this.medical_name = medical_name;
	}
	public int getBoard_sh_no() {
		return board_sh_no;
	}
	public void setBoard_sh_no(int board_sh_no) {
		this.board_sh_no = board_sh_no;
	}
	public String getId_u() {
		return id_u;
	}
	public void setId_u(String id_u) {
		this.id_u = id_u;
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
	public String getMedical_name() {
		return medical_name;
	}
	public void setMedical_name(String medical_name) {
		this.medical_name = medical_name;
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
}
