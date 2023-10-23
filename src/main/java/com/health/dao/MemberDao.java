package com.health.dao;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.MemberDto;
import com.health.mybatis.MybatisConnectionFactory;

public class MemberDao {
	public MemberDto loginMember(MemberDto memberDto) {
		MemberDto loggedMember = null;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		System.out.println("연결오류");
		loggedMember = sqlSession.selectOne("loginMember",memberDto);
		sqlSession.close();
		return loggedMember;
	}
	public int idCheck(String id) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("idCheck",id);
		sqlSession.close();
		return result;
	}
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember",memberDto);
		sqlSession.close();
		return result;
	}
}








