package com.health.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.MaterialDto;
import com.health.dto.MaterialPostDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class MaterialPostDao {

	  private static final MaterialPostDao instance = new MaterialPostDao();
	  public static MaterialPostDao getInstance() { return instance; }
	  private MaterialPostDao() { }
	  
	  
	// 1. insert
	public int insertMaterialPost(MaterialPostDto mpDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMaterialPost",mpDto);
		sqlSession.close();

		
		return result;
	}
	
	// 2. postno로  sympno 얻어오는 함수
	public List<Integer> getSelectedMaterial(int no) {
		List<Integer> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getSelectedMaterial", no);
		sqlSession.close();
		
		return resList;
	}
	
	//3. delete
	public int deleteMaterialPost(MaterialPostDto mpDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deleteMaterialPost",mpDto);
		sqlSession.close();
		
		return result;
		
	}
}
