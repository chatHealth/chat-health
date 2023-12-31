package com.health.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.MaterialDto;
import com.health.dto.PostDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class MaterialDao {
	
	//싱글톤 적용 위해 static final instance 선언
	   private static final MaterialDao instance = new MaterialDao();

	    public static MaterialDao getInstance() {
	        return instance;
	    }

	    //생성자를 통해 객체를 생성하지 못하도록 막음
	    private MaterialDao() {

	    }
    
	// 1. material db의 모든 증상 출력
	public List<MaterialDto> getAllMaterial(){
		List<MaterialDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getAllMaterial");
		sqlSession.close();
		
		return resList;
	}

	// 2. 증상과 관련있는 영양소 (postNo로 조회) 모두 출력
	public List<MaterialDto> getMaerialBySymptom(int sympNo) {
		List<MaterialDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getMaerialBySymptom", sympNo);
		sqlSession.close();
		
		return resList;
	}

	
	// 3. materialNo로 이름 출력
	public String getMaterialName(int materialNo) {
		String result = "";
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getMaterialName", materialNo);
		sqlSession.close();
		return result;
	}
	

}
