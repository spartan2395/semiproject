package com.lntegrated.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.doctor.dto.DoctorDto;
import com.lntegrated.member.dto.MemberDto;

public class MemberDao extends SqlConfig{
	SqlSession session = null;
	String namespace = "com.lntegrated.member.";
	
	public boolean emailchk(String email_u) {
		boolean chk = false;
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			list = session.selectList(namespace+"member_email",email_u);
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
	
	public MemberDto memberlogin(String id_u, String pw_u) {
		MemberDto dto = null;
		Map<String, String> m = new HashMap<String, String>();
		m.put("id_u",id_u);
		m.put("pw_u",pw_u);
		System.out.println("Member dao"+id_u+pw_u);
		System.out.println("map id: "+m.get("id_u"));
		System.out.println("map pw: "+m.get("pw_u"));
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			dto = session.selectOne(namespace+"member_login",m);
			System.out.println(dto);
		} catch (Exception e) {
			System.out.println("memberLogin ERROR");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}
	//ȸ�� ����Ʈ ( Ȥ�� ���� �߰� )
	public List<MemberDto> memberList(){
		List<MemberDto> list = new ArrayList<MemberDto>();
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			list = session.selectList(namespace+"memberList");
		}catch(Exception e) {
			System.out.println("memberList ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//ȸ�� �� ����
	public MemberDto memberInfo(String id_u) {
		MemberDto dto = null;
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			dto = session.selectOne(namespace+"memberinfo",id_u);
		}catch(Exception e) {
			System.out.println("Member_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//ȸ�� ����
	public int memberinsert(MemberDto dto) {
		int res = 0;
		try {
			System.out.println("???");
			session = getSessionFactory("member/member_config.xml").openSession();
			System.out.println("id_u: "+dto.getId_u());
			System.out.println("pw_u: "+dto.getPw_u());
			System.out.println("name_u: "+dto.getName_u());
			System.out.println("gender_u: "+dto.getGender_u());
			System.out.println("number_u: "+dto.getNumber_u());
			System.out.println("addr_u: "+dto.getAddr_u());
			System.out.println("bd_u: "+dto.getBd_u());
			res = session.insert(namespace+"member_insert", dto);
			System.out.println(res);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Member_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//ȸ�� ���� ����
	public int memberupdate(MemberDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			System.out.println("id_u: "+dto.getId_u());
			System.out.println("pw_u: "+dto.getPw_u());
			System.out.println("name_u: "+dto.getName_u());
			System.out.println("gender_u: "+dto.getGender_u());
			System.out.println("number_u: "+dto.getNumber_u());
			System.out.println("addr_u: "+dto.getAddr_u());
			System.out.println("bd_u: "+dto.getBd_u());
			res = session.update(namespace+"member_update", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Member_Update ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//ȸ�� Ż��
	public int memberdelete(String id_u) {
		int res = 0;
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			res = session.update(namespace+"member_delete", id_u);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Member_Delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public boolean memberdeletePw(String pw_u, String id_u) {
		boolean result = false;
		String res = null;
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			res = session.selectOne(namespace+"member_delete_pwchk",id_u);
			System.out.println("res="+res);
			System.out.println("pw_u="+pw_u);
			if (res.equals(pw_u)) {
			result=true;
			}
		} catch (Exception e) {
			System.out.println("Member_Delete_Chk ERROR");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public MemberDto googleLogin(String email) {
		MemberDto dto = null;
		try {
			session = getSessionFactory("member/member_config.xml").openSession();
			dto = session.selectOne(namespace+"member_google_login",email);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
}
