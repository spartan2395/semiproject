package com.lntegrated.board_sh_comm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.board_sh_comm.dto.BoardShCommDto;

public class BoardShCommDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "com.lntegrated.board_sh_comm.mapper.";
	private String config = "board_sh_comm/board_sh_comm_config.xml";
	
	public List<BoardShCommDto> selectList(int boardshno){
		List<BoardShCommDto> list = null;
		try {
			session = getSessionFactory(config).openSession();
			list = session.selectList(namespace+"board_sh_comm_list", boardshno);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("board_sh_comm_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	public int insert(BoardShCommDto dto) {
		int res = 0;
		try {
			session = getSessionFactory(config).openSession();
			res = session.insert(namespace+"board_sh_comm_insert",dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("board_sh_comm_insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int update(BoardShCommDto dto) {
		int res = 0;
		try{
			session = getSessionFactory(config).openSession();
			res = session.update(namespace+"board_sh_comm_update",dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("board_sh_comm_update ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int delete(BoardShCommDto dto) {
		int res = 0;
		try {
			session = getSessionFactory(config).openSession();
			res = session.update(namespace+"board_sh_comm_delete", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("board_sh_comm_delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
