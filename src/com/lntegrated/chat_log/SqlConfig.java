package com.lntegrated.chat_log;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlConfig {
	private SqlSessionFactory sqlfac;
	private String resources = "com/lntegrated/db.dbpropertis";
	
	public SqlSessionFactory getSessionFactory() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resources);
			sqlfac = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlfac;
	}
}
