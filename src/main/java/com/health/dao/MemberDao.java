package com.health.dao;

import org.apache.ibatis.session.SqlSession;

import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.mybatis.MyBatisConnectionFactory;

public class MemberDao {
	
	 //싱글톤 적용 위해 static final instance 선언
    private static final MemberDao instance = new MemberDao();

    public static MemberDao getInstance() {
        return instance;
    }

    //생성자를 통해 객체를 생성하지 못하도록 막음
    private MemberDao() {

    }
    
	public MemberDto loginMember(MemberDto memberDto) {
		MemberDto loggedMember = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		loggedMember = sqlSession.selectOne("loginMember",memberDto);
		sqlSession.close();
		return loggedMember;
	}
	
	public EnterpriseDto loginEnterprise(EnterpriseDto enterpriseDto) {
		EnterpriseDto loggedMember = null;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		loggedMember = sqlSession.selectOne("loginMember",enterpriseDto);
		sqlSession.close();
		return loggedMember;
	}
	
	public int idCheck(String id) {
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
		System.out.println(enterpriseDto.getEnterpriseNo());
		System.out.println(enterpriseDto.getCode());
		System.out.println(enterpriseDto.getAccepted());
		System.out.println(enterpriseDto.getAddress());
		System.out.println(enterpriseDto.getDeletedDate());
		System.out.println(enterpriseDto.getAddressDetail());
		System.out.println(enterpriseDto.getCeo());
		System.out.println(enterpriseDto.getId());
		System.out.println(enterpriseDto.getPw());
		System.out.println(enterpriseDto.getTel());
		System.out.println(enterpriseDto.getName());
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		result = sqlSession.insert("insertEnterprise",enterpriseDto);
		sqlSession.close();
		return result;
	}
	
}








