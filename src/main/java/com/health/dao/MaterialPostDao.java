package com.health.dao;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.MaterialDto;
import com.health.dto.MaterialPostDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class MaterialPostDao {

	  private static final MaterialPostDao instance = new MaterialPostDao();
	  public static MaterialPostDao getInstance() { return instance; }
	  private MaterialPostDao() { }
	  
	  
	// 1. insert
	public int insertMateriaPost(MaterialPostDto mpDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMaterialPost",mpDto);
		sqlSession.close();

		
		return result;
	}
}
