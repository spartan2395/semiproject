package com.lntegrated.inquiry.dto;

import java.util.Date;

public class InquiryDto {
	private int board_no;
	private String id_u;
	private String title;
	private String content;
	private Date regdate;
	private String ans_chk;
	
	public InquiryDto(int board_no, String id_u,
			String title,String content , Date regdate,String ans_chk) {
		this.board_no = board_no;
		this.id_u = id_u;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.ans_chk = ans_chk;
	}
	
	public InquiryDto(String id_u, String title,String content) {
		this.id_u = id_u;
		this.title = title;
		this.content = content;
	}
	
	public InquiryDto(int board_no, String title , String content) {
		this.board_no = board_no;
		this.title = title;
		this.content = content;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getAns_chk() {
		return ans_chk;
	}

	public void setAns_chk(String ans_chk) {
		this.ans_chk = ans_chk;
	}
	
}
