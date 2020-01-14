package com.lntegrated.tel_result.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lntegrated.tel_result.SqlConfig;
import com.lntegrated.tel_result.dto.TelResultDto;

public class TelResultDao extends SqlConfig{
	private SqlSession session = null;
	private String namespace = "com.lntegrated.telresult";
	//환자 검색(진단기록)
	public List<TelResultDto> telResultList(String id_u){
		List<TelResultDto> list = null;
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"tel_result_list", id_u);
		}catch(Exception e) {
			System.out.println("Tel_Result_List ERROR");
		}finally {
			session.close();
		}
		return list;
	}
	//환자 (진단서)
	public TelResultDto telResultInfo(int tel_seq) {
		TelResultDto dto = null;
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"tel_result_info",tel_seq);
		}catch(Exception e) {
			System.out.println("Tel_Result_Info ERROR");
		}finally {
			session.close();
		}
		return dto;
	}
	//의사 (진단서 작성)
	public int relResultInsert(TelResultDto dto) {
		int res = 0;
		try {
			session = getSqlSessionFactory().openSession();
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
