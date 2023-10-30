package com.health.controller.personal;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.health.dao.MemberDao;
import com.health.dto.EnterpriseDto;

@WebServlet("/personal/admin-accept-info")
public class AdminEnterpriseAcceptInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberDao memberDao = MemberDao.getInstance();

	public AdminEnterpriseAcceptInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EnterpriseDto> userList = memberDao.getEnterprise();

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/adminPage-accept.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
