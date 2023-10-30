package com.health.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.SymptomDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class SymptomDao {
	
	private static final SymptomDao instance = new SymptomDao();
	public static SymptomDao getInstance() { return instance; }
	private SymptomDao() { }
	
	// 1. symptom db의 모든 증상 출력
	public List<SymptomDto> getAllSymptom(){
		List<SymptomDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getAllSymptom");
		sqlSession.close();
		
		return resList;
	}
	
	
	// 2. sympno로 이름 출력
	public String getsymptName(int sympNo) {
		String result = "";
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getsymptName", sympNo);
		sqlSession.close();
		return result;
	}
	
	
	
}
