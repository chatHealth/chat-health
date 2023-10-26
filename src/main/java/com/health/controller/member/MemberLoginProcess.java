package com.health.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.health.dao.MemberDao;
import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.util.ModalState;
import com.health.util.ScriptWriter;

@WebServlet("/member/login-process")
public class MemberLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberDao memberDao = MemberDao.getInstance();

	public MemberLoginProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID= request.getParameter("userID");
		String userPW= request.getParameter("userPW");
		String isEnterprise = request.getParameter("isEnterprise");

		
		
		if(isEnterprise == null) { // 1. 개인인 경우
			MemberDto memberDto = new MemberDto();
			MemberDto loggedMember = null;
			memberDto.setId(userID);
			memberDto.setPw(userPW);
			loggedMember = memberDao.loginMember(memberDto);
		
			if(loggedMember!=null) {
				HttpSession loginSession = request.getSession();
				ModalState modalState = new ModalState("show","로그인되었습니다.");
				loginSession.setAttribute("modalState", modalState);
				loggedMember.setPw(null);
				loginSession.setAttribute("loggedMember", loggedMember);
	
				response.sendRedirect("../category/list"); //메인페이지로 수정 필요 
			} else {
				ScriptWriter.alertAndBack(response, "아이디 혹은 비밀번호가 일치하지 않습니다.");
			}
		} else if (isEnterprise.equals("imEnterprise")) {	 //2. 사업자인경우
			EnterpriseDto enterpriseDto = new EnterpriseDto();
			EnterpriseDto loggedMember = null;
			enterpriseDto.setId(userID);
			enterpriseDto.setPw(userPW);
			loggedMember = memberDao.loginEnterprise(enterpriseDto);
			
			if(loggedMember!=null) {  //login success
				HttpSession loginSession = request.getSession();
				ModalState modalState = new ModalState("show","로그인되었습니다.");
				loginSession.setAttribute("modalState", modalState);
				loggedMember.setPw(null);
				loginSession.setAttribute("loggedEnterprise", loggedMember);
				
				response.sendRedirect("../category/list"); //메인페이지로 수정 필요 
			} else {  // login fail
				ScriptWriter.alertAndBack(response, "아이디 혹은 비밀번호가 일치하지 않습니다.");
			}
		}
			

		

	}

}
