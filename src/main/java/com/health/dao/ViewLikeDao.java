package com.health.dao;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.UserLikeDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class ViewLikeDao {
	//싱글톤 적용 위해 static final instance 선언
	   private static final ViewLikeDao instance = new ViewLikeDao();

	    public static ViewLikeDao getInstance() {
	        return instance;
	    }

	    //생성자를 통해 객체를 생성하지 못하도록 막음
	    private ViewLikeDao() {

	    }
	    public int insertViewLike (UserLikeDto userLikeDto) {
			int result = 0;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.insert("insertViewLike",userLikeDto);
			sqlSession.close();
			return result;
		}
		
		public int sameViewLike(UserLikeDto userLikeDto) {
			int result;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.selectOne("sameViewLike",userLikeDto);
			sqlSession.close();
			return result;
		} 

		
		public int deletViewLike(UserLikeDto userLikeDto) {
			int result = 0;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.insert("deletViewLike",userLikeDto);
			sqlSession.close();
			return result;
		}
}