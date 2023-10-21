package com.health.dao;

import com.health.dto.MemberDto;
import com.health.mybatis.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

public class MemberDaoImpl implements MemberDao{

    @Override
    public MemberDto loginMember(MemberDto memberDto) {
        MemberDto loginMember;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        loginMember = sqlSession.selectOne("loginMember", memberDto);
        sqlSession.close();
        return loginMember;
    }
}
