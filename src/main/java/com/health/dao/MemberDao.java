package com.health.dao;

import com.health.dto.MemberDto;
import com.health.mybatis.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {

    public MemberDto loginMember(MemberDto memberDto) {
        MemberDto loginMember;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        loginMember = sqlSession.selectOne("loginMember", memberDto);
        sqlSession.close();
        return loginMember;
    }

    public int updateMember(MemberDto memberDto) {
        int result = 0;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("updateMember", memberDto);
        sqlSession.close();
        return result;
    }

    public int updatePassword(MemberDto memberDto) {
        int result = 0;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("updateMemberPassword", memberDto);
        sqlSession.close();
        return result;
    }

    public int updateProfileImage(MemberDto memberDto) {
        int result = 0;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("updateMemberProfileImage", memberDto);
        sqlSession.close();
        return result;
    }
}
