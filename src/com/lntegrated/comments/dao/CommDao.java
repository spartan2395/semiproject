package com.lntegrated.comments.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.comments.dto.CommDto;

public class CommDao extends SqlConfig{
	private SqlSession session;
	private String namespace = "com.lntegrated.comments.mapper.";
	
	public List<CommDto> commList(int board_no){
		List<CommDto> list = null;
		try {
			session = getSessionFactory("comments/comm_config.xml").openSession();
			list = session.selectList(namespace+"comm_list",board_no);
		}catch(Exception e) {
			System.out.println("Comments_list ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	
	public int commInsert(CommDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("comments/comm_config.xml").openSession();
			res = session.insert(namespace+"comm_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Comment_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int commUpdate(CommDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("comments/comm_config.xml").openSession();
			res = session.update(namespace+"comm_update", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Comment_update ERROR");
		}finally {
			session.close();
		}
		return res;
	}
	
	public int commDelete(CommDto dto) {
		int res = 0;
		String board_no = String.valueOf(dto.getBoard_no());
		try {
			Map<String, String> map = new HashMap<String, String>();
			session = getSessionFactory("comments/comm_config.xml").openSession();
			map.put("board_no",board_no);
			map.put("id_u",dto.getId_u());
			res = session.delete(namespace+"comm_delete", map);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Comment_Delete ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
