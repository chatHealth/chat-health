package com.health.dao;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.HelpfulDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class HelpfulDao {
	//싱글톤 적용 위해 static final instance 선언
	   private static final HelpfulDao instance = new HelpfulDao();

	    public static HelpfulDao getInstance() {
	        return instance;
	    }

	    //생성자를 통해 객체를 생성하지 못하도록 막음
	    private HelpfulDao() {

	    }
	    public int helpfulAdd (HelpfulDto helpfulDto) {
			int result = 0;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.insert("helpfulAdd",helpfulDto);
			sqlSession.close();
			return result;
		}
		
		public int helpFulCount(int no) {
			int result;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.selectOne("helpFulCount",no);
			sqlSession.close();
			return result;
		} 
		
		public int helpfulSame(HelpfulDto helpfulDto) {
			int result;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.selectOne("helpfulSame",helpfulDto);
			sqlSession.close();
			return result;
		} 

		
		public int helpfulCancel(HelpfulDto helpfulDto) {
			int result = 0;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.insert("helpfulCancel",helpfulDto);
			sqlSession.close();
			return result;
		}
}
