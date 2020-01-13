package com.Integrated.db;

import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSSF {
	public  SqlSession getSqlSessionFactory(Reader reader) {
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		return factory.openSession();
	}
}
