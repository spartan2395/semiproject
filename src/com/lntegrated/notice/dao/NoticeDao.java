package com.lntegrated.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.board_fr.dto.Criteria;
import com.lntegrated.notice.dto.NoticeDto;

public class NoticeDao extends SqlConfig{
	private String namespace = "com.lntegrated.notice.";
	private SqlSession session = null;
	//�������� ����Ʈ
	public List<NoticeDto> notice_List(int pageNum, int pageCount){
		List<NoticeDto> list = null;
		try {
			Criteria cri = new Criteria();
			cri.setPage(pageNum);
			cri.setPageCount(pageCount);
			
			session = getSessionFactory("notice/notice_config.xml").openSession();
			list = session.selectList(namespace+"notice_list", cri);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Notice_List ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//�������� �󼼺���
	public NoticeDto notice_Info(int nt_seq) {
		NoticeDto dto = null;
		try {
			session = getSessionFactory("notice/notice_config.xml").openSession();
			dto = session.selectOne(namespace+"notice_info", nt_seq);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Notice_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//�������� �߰�
	public int notice_insert(NoticeDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("notice/notice_config.xml").openSession();
			res = session.insert(namespace+"notice_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Notice_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//�������� ����
	public int notice_update(NoticeDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("notice/notice_config.xml").openSession();
			res = session.update(namespace+"notice_update", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Notice_Update ERROR");
		}finally {

		}
		return res;
	}
	//��ȸ �� ����
	public int notice_Update_Views(int nt_seq) {
		int res = 0;
		try {
			session = getSessionFactory("notice/notice_config.xml").openSession();
			res = session.update(namespace+"notice_views_update", nt_seq);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Notice_Update_view ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//�������� ����
	public int notice_delete(int nt_seq) {
		int res = 0;
		try {
			session = getSessionFactory("notice/notice_config.xml").openSession();
			res = session.delete(namespace+"notice_delete", nt_seq);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Notice_delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	public int countBoard() {
		
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory("notice/notice_config.xml").openSession();
		res = session.selectOne(namespace+"countBoard");
		
		return res;
	}
}
