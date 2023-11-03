package com.health.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/member/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object loggedMember = session.getAttribute("loggedMember");
		Object loggedEnterprise = session.getAttribute("loggedEnterprise");
		Object loggedAdmin = session.getAttribute("loggedAdmin");
		if (loggedEnterprise == null && loggedMember == null) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/member/login.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("../index/index");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
