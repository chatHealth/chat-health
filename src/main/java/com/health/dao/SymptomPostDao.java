package com.health.dao;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.SymptomPostDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class SymptomPostDao {
	
	private static final SymptomPostDao instance = new SymptomPostDao();
	public static SymptomPostDao getInstance() { return instance; }
	private SymptomPostDao() { }
	
	// 1. insert
	public int insertSymptomPost(SymptomPostDto spPost) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertSymptomPost",spPost);
		sqlSession.close();
		
		return result;
	}
}
