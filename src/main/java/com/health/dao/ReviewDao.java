package com.health.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.ReviewDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class ReviewDao {
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
	public List<Map<String,Object>> postInfo(int no) {
		List<Map<String,Object>> result;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectList("postInfo",no);
		sqlSession.close();
		return result;
	} 
}



