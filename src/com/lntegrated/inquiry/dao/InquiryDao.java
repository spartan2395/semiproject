package com.lntegrated.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.inquiry.dto.InquiryDto;

public class InquiryDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "com.lntegrated.inquiry_mapper.";
	
	public List<InquiryDto> inquiryList(){
		List<InquiryDto> list = null;
		try {
			session = getSessionFactory().openSession();
			list = session.selectList(namespace+"inquiry_list");
		}catch(Exception e) {
			System.out.println("Inquiry_List ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	
	public InquiryDto inquiryInfo(int board_no) {
		InquiryDto dto = null;
		try {
			session = getSessionFactory().openSession();
			dto = session.selectOne(namespace+"inquiry_info", board_no);
		}catch(Exception e) {
			System.out.println("Inquiry_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public int inquiryInsert(InquiryDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.insert(namespace+"inquiry_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Inquiry_insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int inquiryUpdate(InquiryDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.update(namespace+"inquiry_update", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Inquiry_Update ERROR");
		}
		return res;
	}
	
	public int inquiryUpdateChk(int board_no) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.update(namespace+"inquiry_update_chk", board_no);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Inquiry_Update_Chk ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
