package com.lntegrated.chat_log.dto;

import java.util.Date;

public class ChatLogDto {
	private String name_d,name_u,chat;
	private Date reserv_date;
	private int chat_no;
	//채팅 기록 확인
	public ChatLogDto(String name_d, String name_u, String chat,
			Date reserv_date,int chat_no) {
		this.name_d = name_d;
		this.name_u = name_u;
		this.chat = chat;
		this.reserv_date = reserv_date;
		this.chat_no = chat_no;
	}
	public ChatLogDto(String chat) {
		this.chat = chat;
	}
	public String getName_d() {
		return name_d;
	}
	public void setName_d(String name_d) {
		this.name_d = name_d;
	}
	public String getName_u() {
		return name_u;
	}
	public void setName_u(String name_u) {
		this.name_u = name_u;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	public Date getReserv_date() {
		return reserv_date;
	}
	public void setReserv_date(Date reserv_date) {
		this.reserv_date = reserv_date;
	}
	public int getChat_no() {
		return chat_no;
	}
	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}
}
