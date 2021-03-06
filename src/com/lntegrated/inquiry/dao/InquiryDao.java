package com.lntegrated.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.board_fr.dto.Criteria;
import com.lntegrated.inquiry.dto.InquiryDto;

public class InquiryDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "com.lntegrated.inquiry_mapper.";
	
	public List<InquiryDto> inquiryList(int pageNum, int pageCount){
		List<InquiryDto> list = null;
		try {
			Criteria cri = new Criteria();
			cri.setPage(pageNum);
			cri.setPageCount(pageCount);
			
			session = getSessionFactory("inquiry/inquiry_config.xml").openSession();
			list = session.selectList(namespace+"inquiry_list", cri);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Inquiry_List ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	
	public InquiryDto inquiryInfo(int board_no) {
		InquiryDto dto = null;
		try {
			session = getSessionFactory("inquiry/inquiry_config.xml").openSession();
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
			session = getSessionFactory("inquiry/inquiry_config.xml").openSession();
			res = session.insert(namespace+"inquiry_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Inquiry_insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int inquiryUpdate(InquiryDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("inquiry/inquiry_config.xml").openSession();
			res = session.update(namespace+"inquiry_update", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Inquiry_Update ERROR");
		}
		return res;
	}
	
	public int inquiryUpdateChk(int board_no) {
		int res = 0;
		try {
			session = getSessionFactory("inquiry/inquiry_config.xml").openSession();
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
	public int countBoard() {
		
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory("inquiry/inquiry_config.xml").openSession();
		res = session.selectOne(namespace+"countBoard");
		
		return res;
	}
}
