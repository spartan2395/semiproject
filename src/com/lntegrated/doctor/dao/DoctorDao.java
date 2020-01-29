package com.lntegrated.doctor.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.Integrated.db.SqlConfig;
import com.lntegrated.doctor.dto.DoctorDto;
import com.lntegrated.member.dto.MemberDto;

public class DoctorDao extends SqlConfig{
	String namespace = "com.lntegerated.doctor_mapper.";
	SqlSession session = null;
	
	public boolean emailchk(String email_d) {
		boolean chk = false;
		List<DoctorDto> list = new ArrayList<DoctorDto>();
		
		try {
			session = getSessionFactory("doctor/doctor_config.xml").openSession();
			list = session.selectList(namespace+"doctor_email",email_d);
			if (list.size()>0) {
				chk = false;	// 이미 사용중인 이메일 
			} else {
				chk = true;		// 사용 가능한 이메일 
			}
		} catch (Exception e) {
			System.out.println("email check error");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return chk;
	}
	
	// login
	public DoctorDto doctorLogin(String id_d, String pw_d){
		DoctorDto dto = null;
		Map<String, String> m = new HashMap<String, String>();
		m.put("id_d", id_d);
		m.put("pw_d", pw_d);
		System.out.println("dao"+id_d+pw_d);
		System.out.println("map id: "+m.get("id_d"));
		System.out.println("map pw: "+m.get("pw_d"));
			try {
				session = getSessionFactory("doctor/doctor_config.xml").openSession();
				dto = session.selectOne(namespace+"doctor_login",m);
			} catch (Exception e) {
				System.out.println("Doctor_login ERROR");
				e.printStackTrace();
			} finally {
				session.close();
			}
		return dto;
	}
	
	//????
	public List<DoctorDto> doctorList(){
		List<DoctorDto> list = null;
		try {
			session = getSessionFactory("doctor/doctor_config.xml").openSession();
			list = session.selectList(namespace+"doctor_list");
		}catch(Exception e) {
			System.out.println("Doctor_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	
	//ȸ�� ���� �˻�
	public DoctorDto doctorInfo(String id_d) {
		DoctorDto dto = null;
		try {
			session = getSessionFactory("doctor/doctor_config.xml").openSession();
			dto = session.selectOne(namespace+"doctor_info", id_d);
		}catch(Exception e) {
			
			System.out.println("Doctor_info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	
	//ȸ�� ����
	public int insert(DoctorDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("doctor/doctor_config.xml").openSession();
			res = session.insert(namespace+"doctor_insert",dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Doctor_insert ERROR");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	//ȸ�� ���� ����
	public int update(DoctorDto dto) {
		int res = 0;

		try {

			System.out.println("zero");
			session = getSessionFactory("doctor/doctor_config.xml").openSession();
			System.out.println("one");
			res = session.update(namespace+"doctor_update", dto);
			System.out.println("two");
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Doctor_update ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//ȸ�� ����
	public int delete(String id_d) {
		int res = 0;
		try {
			session = getSessionFactory("doctor/doctor_config.xml").openSession();
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
	
	public boolean doctordeletePw(String pw_d, String id_d) {
		boolean result =false;
		String res = null;
		try {
			session= getSessionFactory("doctor/doctor_config.xml").openSession();
			res = session.selectOne(namespace+"doctor_delete_pwchk",id_d);
			if(res.equals(pw_d)){
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Doctor_Delete_Chk ERROR");
		} finally {
			session.close();
		}
		return result;
	}
}
