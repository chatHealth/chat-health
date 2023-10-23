package com.health.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.health.dao.MemberDao;
import com.health.dto.MemberDto;
import com.health.dto.ModalState;
import com.health.util.ScriptWriter;


@WebServlet("/member/login-process")
public class MemberLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID= request.getParameter("userID");
		String userPW= request.getParameter("userPW");
		
		MemberDao memberDao = new MemberDao();
		MemberDto parameterMemberDto = new MemberDto();
		MemberDto loggedMember = null;
		parameterMemberDto.setID(userID);
		parameterMemberDto.setPW(userPW);
		loggedMember = memberDao.loginMember(parameterMemberDto);
		if(loggedMember!=null) {
			HttpSession loginSession = request.getSession();
			ModalState modalState = new ModalState("show","로그인되었습니다.");
			loginSession.setAttribute("modalState", modalState);
			loginSession.setAttribute("loggedID", loggedMember.getID());
			loginSession.setAttribute("loggedName", loggedMember.getName());
			loginSession.setAttribute("profile", loggedMember.getProfile());
			System.out.println(loginSession.getAttribute("loggedID"));
			response.sendRedirect("../board/list"); //사랑이 메인페이지 만들어지면 수정 필요.
		} else {
			ScriptWriter.alertAndGo(response, "아이디 혹은 비밀번호가 일치하지 않습니다.", "/");
		}
		
	}

}
