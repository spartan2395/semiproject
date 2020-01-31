package com.lntegrated.board_sh_comm.dto;

import java.util.Date;

public class BoardShCommDto {
	private int boardshno;
	private String content;
	private Date regdate;
	private String id_u;
	
	public BoardShCommDto(int boardshno,String content,Date regdate,String id_u) {
		this.boardshno = boardshno;
		this.content = content;
		this.regdate = regdate;
		this.id_u = id_u;
	}
	
	public BoardShCommDto(int boardshno,String content,String id_u) {
		this.boardshno = boardshno;
		this.content = content;
		this.id_u = id_u;
	}
	
	public BoardShCommDto(int boardshno,String id_u,Date regdate) {
		this.boardshno = boardshno;
		this.id_u = id_u;
		this.regdate = regdate;
	}

	public int getBoardshno() {
		return boardshno;
	}

	public void setBoardshno(int boardshno) {
		this.boardshno = boardshno;
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

	public String getId_u() {
		return id_u;
	}

	public void setId_u(String id_u) {
		this.id_u = id_u;
	}
	
}
