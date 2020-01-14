package com.lntegrated.clinic.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.clinic.dto.ClinicDto;

public class ClinicDao extends SqlConfig{
	SqlSession session = null;
	String namespace = "clinic_mapper.";
	//의사에게 예약이되어 있는 손님들 리스트 
	public List<ClinicDto> clinicList(String id_d) {
		List<ClinicDto> list = new ArrayList<ClinicDto>();
		try {
			session = getSessionFactory().openSession();
			list = session.selectList(namespace+"clinic_list", id_d);
		}catch(Exception e) {
			System.out.println("clinicList ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//예약자 상세 정보
	public ClinicDto clinicMemberInfo(String id_u) {
		ClinicDto dto = null;
		
		try {
			session = getSessionFactory().openSession();
			dto = session.selectOne(namespace+"clinic_memberinfo", id_u);
		}catch(Exception e) {
			System.out.println("ClinicmemberInfo ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//예약 신청
	public int clinicinsert(ClinicDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.insert(namespace+"clinic_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("clinic_insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//승인 유무
	public int clinicupdate(String id_u , String id_d) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_u", id_u);
			map.put("id_d",id_d);
			res = session.update(namespace+"clinic_update", map);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("ClinicUpdate ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
