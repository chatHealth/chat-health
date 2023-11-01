package com.health.dao;

import java.util.HashMap;
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
	
	
	// 3. 
	
	// 모든 post list 가져오기
	public List<PostDto> getPostForAll(HashMap<String,String> map) {
		List<PostDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getPostForAll", map );
		sqlSession.close();
		
		return resList;
	}
	
	
	// 증상으로 post list 가져오기
	public List<PostDto> getPostForSympno(HashMap<String,String> map) {
		List<PostDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getPostForSympno", map);
		sqlSession.close();
		
		return resList;
	}
	
	// 증상과 재료로 post list 가져오기
	public List<PostDto> getPostForSympnoAndMaterial(HashMap<String, String> map) {
		List<PostDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getPostForSympnoAndMaterial", map);
		sqlSession.close();
		
		return resList;
	}
		
	// 키워드로  post list 가져오기
	public List<PostDto> getPostForKeyword(HashMap<String,String> map) {
		List<PostDto> resList = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		resList = sqlSession.selectList("getPostForKeyword", map);
		sqlSession.close();
		
		return resList;
	}
	

	

	
	
	// 4. postNo로 게시글 하나 가져오기
	public PostDto getOnePost(int no) {
		PostDto result = null;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("getOnePost", no);
		sqlSession.close();
		
		return result;
	}
	
	//5. update
	public int updatePost(PostDto postDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updatePost",postDto);
		sqlSession.close();
		
		return result;
	}
	
	// 6. delete one
	public int deletePost(int no) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.delete("deletePost",no);
		sqlSession.close();
		
		return result;
	}
	
	
}
