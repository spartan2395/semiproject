package com.lntegrated.dto;

import java.util.Date;

public class Dto {
	// 공통

	private String activation;
	private Date reserv_date;
	private String category; 
	private String check;
	private int tel_seq;
	//
	public Dto(String activation , Date reserv_date , String category , String check, int tel_seq) {
		this.activation = activation;
		this.reserv_date = reserv_date;
		this.category = category;
		this.check =check;
		this.tel_seq = tel_seq;
	}
	// 공통(게시판)

	private int board_no; 
	private String title;
	private String content;
	private Date regdate;
	private int view;

	// 의사 테이블
	private String id_d;
	private String pw_d;
	private String name_d;
	private String gender_d;
	private String number_d;
	private String adrr_d;
	private String medical_d;
	private String email_d;
	private String grade_d;
	private String department;

	// 환자 테이블
	private String id_u;
	private String pw_u;
	private String name_u;
	private String gender_u;
	private String number_u;
	private String adrr_u;
	private String email_u;

	// 왕진, 통원 신청(예약)
	private String disease;

	// 원격진료 신청(예약)
	private int chat_no;

	// 공지사항
	private int nt_seq;

	// 화상채팅 로그
	private String chat;

	// 진단결과
	private String dx_name;
	private String dx_content;
	private String purpose;
	private String remarks;
	private Date iss_date;

	// 자유게시판 -> 댓글
	private String content_a;
	private Date regdate_a;

	// 1:1 문의 게시판

	private String ans_chk;


	


	public String getActivation() {
		return activation;
	}


	public void setActivation(String activation) {
		this.activation = activation;
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


	public String getCheck() {
		return check;
	}


	public void setCheck(String check) {
		this.check = check;
	}


	public int getTel_seq() {
		return tel_seq;
	}


	public void setTel_seq(int tel_seq) {
		this.tel_seq = tel_seq;
	}


	public int getBoard_no() {
		return board_no;
	}


	public void setBoard_no(int board_no) {
		this.board_no = board_no;
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


	public int getView() {
		return view;
	}


	public void setView(int view) {
		this.view = view;
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


	public String getAdrr_d() {
		return adrr_d;
	}


	public void setAdrr_d(String adrr_d) {
		this.adrr_d = adrr_d;
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


	public String getAdrr_u() {
		return adrr_u;
	}


	public void setAdrr_u(String adrr_u) {
		this.adrr_u = adrr_u;
	}


	public String getEmail_u() {
		return email_u;
	}


	public void setEmail_u(String email_u) {
		this.email_u = email_u;
	}


	public String getDisease() {
		return disease;
	}


	public void setDisease(String disease) {
		this.disease = disease;
	}


	public int getChat_no() {
		return chat_no;
	}


	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}


	public int getNt_seq() {
		return nt_seq;
	}


	public void setNt_seq(int nt_seq) {
		this.nt_seq = nt_seq;
	}


	public String getChat() {
		return chat;
	}


	public void setChat(String chat) {
		this.chat = chat;
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


	public String getContent_a() {
		return content_a;
	}


	public void setContent_a(String content_a) {
		this.content_a = content_a;
	}


	public Date getRegdate_a() {
		return regdate_a;
	}


	public void setRegdate_a(Date regdate_a) {
		this.regdate_a = regdate_a;
	}


	public String getAns_chk() {
		return ans_chk;
	}


	public void setAns_chk(String ans_chk) {
		this.ans_chk = ans_chk;
	}
}
