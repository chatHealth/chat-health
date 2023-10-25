package com.health.dao;

import com.health.dto.MemberDto;
import com.health.dto.PostDto;
import com.health.mybatis.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PersonalDao {

    private static final PersonalDao instance = new PersonalDao();

    public static PersonalDao getInstance() {
        return instance;
    }
    private PersonalDao() {
    }

    public List<PostDto> userLikePosts(int userNo) {
        List<PostDto> userLikePosts;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        userLikePosts = sqlSession.selectList("memberWishPosts", userNo);
        System.out.println("userNo = " + userNo);
        System.out.println("userLikePosts.size() = " + userLikePosts.size());
        return userLikePosts;
    }

    public MemberDto memberInfo(int userNo) {
        MemberDto member;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        member = sqlSession.selectOne("memberInfo", userNo);
        sqlSession.close();
        return member;
    }
}
