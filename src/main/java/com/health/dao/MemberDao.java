package com.health.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.EnterpriseDto;
import com.health.dto.IdCheckDto;
import com.health.dto.MemberDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class MemberDao{
	
	 //싱글톤 적용 위해 static final instance 선언
    private static final MemberDao instance = new MemberDao();

    public static MemberDao getInstance() {
        return instance;
    }

    //생성자를 통해 객체를 생성하지 못하도록 막음
    private MemberDao() {

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
		System.out.println("memberDto.getPw() = " + memberDto.getPw());
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

	public MemberDto loginMember(MemberDto memberDto) {
		MemberDto loggedMember;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		loggedMember = sqlSession.selectOne("loginMember",memberDto);

		sqlSession.close();
		return loggedMember;
	}

	
	public EnterpriseDto loginEnterprise(EnterpriseDto enterpriseDto) {
		EnterpriseDto loggedMember = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		loggedMember = sqlSession.selectOne("loginEnterprise",enterpriseDto);
		sqlSession.close();
		return loggedMember;
	}
	
	public int idCheck(IdCheckDto id) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.selectOne("idCheck",id);
		sqlSession.close();
		return result;
	}
	
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertMember",memberDto);
		sqlSession.close();
		return result;
	}
	
	public int insertEnterprise(EnterpriseDto enterpriseDto) {
		int result = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertEnterprise",enterpriseDto);
		sqlSession.close();
		return result;
	}

	public int updateEnterprise(EnterpriseDto enterpriseDto) {
		int result = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.update("updateEnterprise", enterpriseDto);
		sqlSession.close();
		return result;
	}
	
	public List<MemberDto> getUser() {
		List<MemberDto> userList = new ArrayList<>();
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		userList = sqlSession.selectList("getUser");
		sqlSession.close();
		return userList;
	}
	
	public List<EnterpriseDto> getEnterprise() {
		List<EnterpriseDto> enterpriseList = new ArrayList<>();
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		enterpriseList = sqlSession.selectList("getEnterprise");
		sqlSession.close();
		return enterpriseList;
	}
	
	public int memWithdraw(int userNo) {
        int result = 0;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        result = sqlSession.update("deleteMember", userNo);
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
}








