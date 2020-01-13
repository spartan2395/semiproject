package com.lntegrated.clinic;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.Integrated.db.GetSSF;

public class SqlConfig {
	private SqlSessionFactory sqlsfac;
	public SqlSessionFactory getsqlSessionFactory() {
		String resources = "com/lntegrated/controller/select/hosconfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resources);
			sqlsfac = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlsfac;
	}
}
