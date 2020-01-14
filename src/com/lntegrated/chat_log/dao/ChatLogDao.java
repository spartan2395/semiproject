package com.lntegrated.chat_log.dao;

import org.apache.ibatis.session.SqlSession;

import com.lntegrated.chat_log.SqlConfig;
import com.lntegrated.chat_log.dto.ChatLogDto;

public class ChatLogDao extends SqlConfig{
	private SqlSession session;
	private String namespace = "com.chatlog.mapper.";
	
	public ChatLogDto chatLogInfo(int chat_no) {
		ChatLogDto dto = null;
		try {
			session = getSessionFactory().openSession();
			dto = session.selectOne(namespace+"chat_log_select",chat_no);
		}catch(Exception e) {
			System.out.println("Chat_log_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public int chatLogInsert(ChatLogDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.insert(namespace+"chat_log_insert", dto.getChat());
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Chat_Log_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
