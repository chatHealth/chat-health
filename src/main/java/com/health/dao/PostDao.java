package com.health.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.PostDto;
import com.health.dto.SymptomDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class PostDao {

	private static final PostDao instance = new PostDao();
	public static PostDao getInstance() { return instance; }
	private PostDao() { }
	  
	// 1. insert
	public int insertPost(PostDto postDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertPost",postDto);
		sqlSession.close();
		
		return result;
	}
	
	
	// 2. seq_post.nextval 얻어오기
	public int seqPostNextVal() {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("seqPostNextVal");
		sqlSession.close();
		return result;
	}
	
	// 3. 모든 post list 가져오기
	public List<PostDto> getAllPost() {
		List<PostDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getAllPost");
		sqlSession.close();
		
		return resList;
	}
}
