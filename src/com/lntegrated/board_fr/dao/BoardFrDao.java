package com.lntegrated.board_fr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.board_fr.dto.BoardFrDto;

public class BoardFrDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "com.board_fr.mapper.";
	//�Խñ� ��ü ����Ʈ
	public List<BoardFrDto> boardFrList(){
		List<BoardFrDto> list = null;
		try {
			session = getSessionFactory("board_fr/boardfr_config.xml").openSession();
			list = session.selectList(namespace+"board_list");
		}catch(Exception e) {
			System.out.println("Board_Fr_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//�Խñ� ����˻�
	public List<BoardFrDto> boardFrSearchList(String title){
		List<BoardFrDto> list = null;
		try {
			session = getSessionFactory("board_fr/boardfr_config.xml").openSession();
			list = session.selectList(namespace+"board_search_list", title);
		}catch(Exception e) {
			System.out.println("Board_Fr_Search_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//�Խñ� ������
	public BoardFrDto boardFrInfo(int board_no) {
		BoardFrDto dto = null;
		try {
			session = getSessionFactory("board_fr/boardfr_config.xml").openSession();
			dto = session.selectOne(namespace+"board_info", board_no);
		}catch(Exception e) {
			System.out.println("Board_Fr_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//�Խñ� �ۼ�
	public int boardInsert(BoardFrDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("board_fr/boardfr_config.xml").openSession();
			res = session.insert(namespace+"board_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Board_Fr_Insert ERROR");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	//�Խñ� ����
	public int boardUpdateInfo(BoardFrDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("board_fr/boardfr_config.xml").openSession();
			res = session.update(namespace+"board_update_info", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Board_Update_Info ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//�Խñ� ��ȸ�� ����
	public int boardUpadteViews(int board_no) {
		int res = 0;
		try {
			session = getSessionFactory("board_fr/boardfr_config.xml").openSession();
			res = session.update(namespace+"board_update_views", board_no);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Board_Update_Views ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//�Խñ� ����
	public int boardDelete(int board_no) {
		int res = 0;
		try {
			session = getSessionFactory("board_fr/boardfr_config.xml").openSession();
			res = session.delete(namespace+"board_delete", board_no);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Board_Delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
