package com.health.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.ReviewDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class HelpfulDao02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelpfulDao02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

		
		public int helpfulCancel(HelpfulDto helpfulDto) {
			int result = 0;
			SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
			result = sqlSession.insert("helpfulCancel",helpfulDto);
			sqlSession.close();
			return result;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
