package com.health.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/health/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static SqlSession getSqlSession() {
		//commit auto-commit
		return sqlSessionFactory.openSession(true);
	}
}
