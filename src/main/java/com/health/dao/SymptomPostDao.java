package com.health.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.PostDto;
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
	
	// 2. postno로  sympno 얻어오는 함수
	public List<Integer> getSelectedSymptom(int no) {
		List<Integer> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getSelectedSymptom", no);
		sqlSession.close();
		
		return resList;
	}
	
	// 3.delete
	public int deleteSymptomPost(SymptomPostDto spDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteSymptomPost",spDto);
		sqlSession.close();
		
		return result;
		
	}
}
