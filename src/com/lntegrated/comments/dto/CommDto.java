package com.lntegrated.comments.dto;

import java.util.Date;

public class CommDto {
	private int board_no;
	private String content_a;
	private Date regdate_a;
	private String id_u;
	
	//´ñ±Û °Ë»ö
	public CommDto(int board_no,String content_a,Date regdate_a,String id_u) {
		this.board_no = board_no;
		this.content_a = content_a;
		this.regdate_a = regdate_a;
		this.id_u = id_u;
	}
	
	//´ñ±Û ÀÛ¼º
	public CommDto(int board_no, String content_a,String id_u) {
		this.board_no = board_no;
		this.content_a = content_a;
		this.id_u = id_u;
	}
	//´ñ±Û ¼öÁ¤
	public CommDto(int board_no , String content_a) {
		this.board_no = board_no;
		this.content_a = content_a;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
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

	public String getId_u() {
		return id_u;
	}

	public void setId_u(String id_u) {
		this.id_u = id_u;
	}
}
