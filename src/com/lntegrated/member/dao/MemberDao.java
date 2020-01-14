package com.lntegrated.member.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.member.dto.MemberDto;

public class MemberDao extends SqlConfig{
	SqlSession session = null;
	String namespace = "com.lntegrated.member.";
	//회원 리스트 ( 혹시 몰라서 추가 )
	public List<MemberDto> memberList(){
		List<MemberDto> list = new ArrayList<MemberDto>();
		try {
			session = getSessionFactory().openSession();
			list = session.selectList(namespace+"memberList");
		}catch(Exception e) {
			System.out.println("memberList ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//회원 상세 정보
	public MemberDto memberInfo(String id_u) {
		MemberDto dto = null;
		try {
			session = getSessionFactory().openSession();
			dto = session.selectOne(namespace+"memberinfo",id_u);
		}catch(Exception e) {
			System.out.println("Member_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//회원 가입
	public int memberinsert(MemberDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.insert(namespace+"member_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Member_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//회원 정보 수정
	public int memberupdate(MemberDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.update(namespace+"update", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Member_Update ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//회원 탈퇴
	public int memberdelete(String id_u) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.update(namespace+"member_delete", id_u);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Member_Delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
