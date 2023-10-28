package com.health.dao;

import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.dto.PostDto;
import com.health.dto.PostPageDto;
import com.health.mybatis.MyBatisConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
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
        sqlSession.close();
        return userLikePosts;
    }

    public MemberDto memberInfo(int userNo) {
        MemberDto member;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        member = sqlSession.selectOne("memberInfo", userNo);
        sqlSession.close();
        return member;
    }

    public String memberPassword(int userNo) {
        String pw;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        pw = sqlSession.selectOne("memberPassword", userNo);
        sqlSession.close();
        return pw;
    }

    public int memWithdraw(int userNo) {
        int result = 0;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("memWithdraw", userNo);
        sqlSession.close();
        return result;
    }

    public EnterpriseDto EnterpriseInfo(int enterpriseNo) {
        EnterpriseDto enterprise;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        enterprise = sqlSession.selectOne("enterpriseInfo", enterpriseNo);
        sqlSession.close();
        return enterprise;
    }

    public String enterprisePassword(int enterpriseNo) {
        String pw;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        pw = sqlSession.selectOne("enterprisePassword", enterpriseNo);
        sqlSession.close();
        return pw;
    }

    public int updateEntPassword(EnterpriseDto enterpriseDto) {
        int result;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("updateEntPassword", enterpriseDto);
        sqlSession.close();
        return result;
    }

    public int entWithdraw(int enterpriseNo) {
        int result = 0;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("entWithdraw", enterpriseNo);
        sqlSession.close();
        return result;
    }

    public int updateProfileImage(EnterpriseDto enterpriseDto) {
        int result = 0;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("entProfileImg", enterpriseDto);
        sqlSession.close();
        return result;
    }

    public List<PostPageDto> entPost(int no) {
        List<PostPageDto> entPosts;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        entPosts = sqlSession.selectList("entPosts", no);
        sqlSession.close();
        return entPosts;
    }

    public List<HashMap<String, Object>> memReview(int no) {
        List<HashMap<String, Object>> list;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        list = sqlSession.selectList("memReview", no);
        sqlSession.close();
        return list;
    }
}
