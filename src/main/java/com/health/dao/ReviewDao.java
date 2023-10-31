package com.health.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.ReviewDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class ReviewDao {
	
	private static final ReviewDao instance = new ReviewDao();
	public static ReviewDao getInstance() { return instance; }
	private ReviewDao() { }
	
	public int insertRivew(ReviewDto reviewDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertRivew",reviewDto);
		sqlSession.close();
		return result;
	}
	
	public List<Map<String,Object>> selectReview(int no) {
		List<Map<String,Object>> result;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectList("reviewDate",no);
		sqlSession.close();
		return result;
	}
	public Map<String,Object> postInfo(int no) {
		Map<String,Object> result;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("postInfo",no);
		sqlSession.close();
		return result;
	} 
	public List<Map<String,Object>> postMeterial(int no) {
		List<Map<String,Object>> result;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectList("postMeterial",no);
		sqlSession.close();
		return result;
	}
}



