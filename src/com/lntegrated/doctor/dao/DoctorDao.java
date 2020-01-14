package com.lntegrated.doctor.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.Integrated.db.SqlConfig;
import com.lntegrated.doctor.dto.DoctorDto;

public class DoctorDao extends SqlConfig{
	String namespace = "com.lntegerated.doctor_mapper";
	SqlSession session = null;
	//????
	public List<DoctorDto> doctorList(){
		List<DoctorDto> list = null;
		try {
			session = getSessionFactory().openSession();
			list = session.selectList(namespace+"doctor_list");
		}catch(Exception e) {
			System.out.println("Doctor_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//회원 정보 검색
	public DoctorDto doctorInfo(String id_d) {
		DoctorDto dto = null;
		try {
			session = getSessionFactory().openSession();
			dto = session.selectOne(namespace+"doctor_info", id_d);
		}catch(Exception e) {
			System.out.println("Doctor_info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//회원 가입
	public int insert(DoctorDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.insert(namespace+"doctor_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Doctor_insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//회원 정보 수정
	public int update(DoctorDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.update(namespace+"doctor_update", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Doctor_update ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//회원 삭제
	public int delete(String id_d) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.update(namespace+"doctor_delete", id_d);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Doctor_delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
