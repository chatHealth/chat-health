package com.jjang051.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jjang051.dao.MemberDao;
import com.jjang051.dto.MemberDto;
import com.jjang051.dto.ModalState;

/**
 * Servlet implementation class MemberLoginProcess
 */
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		MemberDto loggedMember = null;
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userID);
		memberDto.setPassword(userPW);
		MemberDao memberDao = new MemberDao();
		loggedMember = memberDao.loginMember(memberDto);
		if(loggedMember!=null) {
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show","로그인되었습니다.");
			session.setAttribute("modalState", modalState);
			session.setAttribute("loggedID", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			session.setAttribute("profile", loggedMember.getProfile());
			response.sendRedirect("../board/list");
		}
	}
}
