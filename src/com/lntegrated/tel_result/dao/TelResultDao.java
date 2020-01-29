package com.lntegrated.tel_result.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.Integrated.db.SqlConfig;
import com.lntegrated.tel_result.dto.TelResultDto;

public class TelResultDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "com.lntegrated.telresult";
	//ȯ�� �˻�(���ܱ��)
	public List<TelResultDto> telResultList(String id_u){
		List<TelResultDto> list = null;
		try {
			session = getSessionFactory("tel_result/tel_result_config.xml").openSession();
			list = session.selectList(namespace+"tel_result_list", id_u);
		}catch(Exception e) {
			System.out.println("Tel_Result_List ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//ȯ�� (���ܼ�)
	public TelResultDto telResultInfo(int tel_seq) {
		TelResultDto dto = null;
		try {
			session = getSessionFactory("tel_result/tel_result_config.xml").openSession();
			dto = session.selectOne(namespace+"tel_result_info",tel_seq);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Tel_Result_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//�ǻ� (���ܼ� �ۼ�)
	public int relResultInsert(TelResultDto dto) {
		int res = 0;
		try {
			session = getSessionFactory("tel_result/tel_result_config.xml").openSession();
			res = session.insert(namespace+"tel_result_insert", dto);
			if(res > 0) {
				session.commit();
			}
		}catch(Exception e) {
			System.out.println("Tel_Result_Insert ERROR");
		}finally {
			session.close();
		}
		return res;
	}
}
