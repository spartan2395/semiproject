package com.lntegrated.board_fr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.board_fr.dto.BoardFrDto;

public class BoardFrDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "";
	//게시글 전체 리스트
	public List<BoardFrDto> boardFrList(){
		List<BoardFrDto> list = null;
		try {
			session = getSessionFactory().openSession();
			list = session.selectList(namespace+"board_list");
		}catch(Exception e) {
			System.out.println("Board_Fr_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//게시글 제목검색
	public List<BoardFrDto> boardFrSearchList(String title){
		List<BoardFrDto> list = null;
		try {
			session = getSessionFactory().openSession();
			list = session.selectList(namespace+"board_search_list", title);
		}catch(Exception e) {
			System.out.println("Board_Fr_Search_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//게시글 상세정보
	public BoardFrDto boardFrInfo(int board_no) {
		BoardFrDto dto = null;
		try {
			session = getSessionFactory().openSession();
			dto = session.selectOne(namespace+"board_info", board_no);
		}catch(Exception e) {
			System.out.println("Board_Fr_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//게시글 작성
	public int boardInsert(BoardFrDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
			res = session.insert(namespace+"board_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Board_Fr_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	//게시글 수정
	public int boardUpdateInfo(BoardFrDto dto) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
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
	//게시글 조회수 증가
	public int boardUpadteViews(int board_no) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
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
	//게시글 삭제
	public int boardDelete(int board_no) {
		int res = 0;
		try {
			session = getSessionFactory().openSession();
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
