package com.health.controller.personal;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.health.dao.MemberDao;

@WebServlet("/personal/admin-withdraw")
public class AdminMemberWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberDao memberDao = MemberDao.getInstance();

	public AdminMemberWithdraw() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int intUserNo = Integer.parseInt(request.getParameter("userNo"));
		int result = memberDao.memWithdraw(intUserNo);

		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		String resultJson = null;
		if (result > 0) {
			map.put("isDelete", "ok");
			resultJson = gson.toJson(map);

		} else {
			map.put("isDelete", "fail");
			resultJson = gson.toJson(map);
		}
		request.setAttribute("resultJson", resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/memberDeleted.jsp");
		dispatcher.forward(request, response);
	}

}
