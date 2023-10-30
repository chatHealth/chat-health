package com.health.dao;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.ReviewDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class ReviewDao {
	public int insertRivew(ReviewDto reviewDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		System.out.println(reviewDto.toString());
		result = sqlSession.insert("insertRivew",reviewDto);
		
		sqlSession.close();
		return result;
	}
}



