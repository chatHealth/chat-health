package com.health.controller.personal;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.health.dao.MemberDao;
import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;

@WebServlet("/personal/member-manage")
public class AdminInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberDao memberDao = MemberDao.getInstance();
     
    public AdminInfo() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberDto> userList = memberDao.getUser();			
		request.setAttribute("userList", userList);
		HttpSession session = request.getSession();
		MemberDto loggedAdmin = (MemberDto) session.getAttribute("loggedAdmin");
		if(loggedAdmin !=null) {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/personal/AdminPage.jsp");
		dispatcher.forward(request, response);
		}else {
			ScriptWriter.alertAndGo(response,"잘못된 접근입니다.", "../index/index");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
