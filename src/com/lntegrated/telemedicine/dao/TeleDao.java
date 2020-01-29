package com.lntegrated.telemedicine.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.telemedicine.dto.TeleDto;

public class TeleDao extends SqlConfig{
	SqlSession session = null;
	String namespace = "com.tele.mapper.";
	int res = 0;
	//���� ����Ʈ
	public List<TeleDto> teleList(String id_d){
		List<TeleDto> list = null;
		try {
			session = getSessionFactory("telemedicine/tele_config.xml").openSession();
			list = session.selectList(namespace+"tele_list", id_d);
		}catch(Exception e) {
			System.out.println("Telemedicine_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	public List<TeleDto> teleInfoList(String id_u){
		List<TeleDto> list = null;
		try {
			session = getSessionFactory("telemedicine/tele_config.xml").openSession();
			list = session.selectList(namespace+"tele_info", id_u);
		}catch(Exception e) {
			System.out.println("Telemedicine_info ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	public TeleDto teleInfo(int tel_seq){
		TeleDto dto = null;
		try {
			session = getSessionFactory("telemedicine/tele_config.xml").openSession();
			dto = session.selectOne(namespace+"tele_info", tel_seq);
		}catch(Exception e) {
			System.out.println("Telemedicine_info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public int teleInsert(TeleDto dto) {
		res = 0;
		try {
			session = getSessionFactory("telemedicine/tele_config.xml").openSession();
			res = session.insert(namespace+"tele_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Telemedicine_insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int teleUpdateInfo(TeleDto dto) {
		res = 0;
		try {
			session = getSessionFactory("telemedicine/tele_config.xml").openSession();
			res = session.update(namespace+"tele_update_info", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Telemedicine_update_info ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int teleUpdateChk(int tel_seq) {
		res = 0;
		try {
			session = getSessionFactory("telemedicine/tele_config.xml").openSession();
			res = session.update(namespace+"tele_update_check", tel_seq);
		}catch(Exception e) {
			System.out.println("Telemedicine_update_check ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
