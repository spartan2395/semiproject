package com.lntegrated.board_sh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.board_fr.dto.Criteria;
import com.lntegrated.board_sh.dto.BoardShDto;

public class BoardShDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "com.boardsh.mapper.";
	private String config = "board_sh/boardsh_config.xml";
	public List<BoardShDto> sharing_List(int pageNum, int pageCount){
		List<BoardShDto> list = null;
		try {
			
			Criteria cri = new Criteria();
			cri.setPage(pageNum);
			cri.setPageCount(pageCount);
			
			session = getSessionFactory("board_sh/boardsh_config.xml").openSession();
			list = session.selectList(namespace+"board_sh_list", cri);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Sharing_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	
	public BoardShDto sharing_info(int board_sh_no) {
		BoardShDto dto = null;
		try {
			session = getSessionFactory(config).openSession();
			dto = session.selectOne(namespace+"board_sh_info", board_sh_no);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("sharing_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public int sharing_insert(BoardShDto dto) {
		int res = 0;
		try {
			session = getSessionFactory(config).openSession();
			res = session.insert(namespace+"board_sh_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("sharing_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int sharing_update_views(int board_sh_no) {
		int res = 0;
		try {
			session = getSessionFactory(config).openSession();
			res = session.update(namespace+"board_sh_update_view", board_sh_no);		
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("sharing_Update_Views ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int sharing_update(BoardShDto dto) {
		int res = 0;
		try {
			session = getSessionFactory(config).openSession();
			res = session.update(namespace+"board_sh_update_write", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("sharing_Update ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int sharing_delete(int board_sh_no) {
		int res = 0;
		try {
			session = getSessionFactory(config).openSession();
			res = session.delete(namespace+"board_sh_delete",board_sh_no);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("sharing_Delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	public int countBoard() {
		
		SqlSession session = null;
		int res = 0;
		
		session = getSessionFactory("board_sh/boardsh_config.xml").openSession();
		res = session.selectOne(namespace+"countBoard");
		
		return res;
	}
}