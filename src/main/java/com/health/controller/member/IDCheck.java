package com.health.controller.member;

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

@WebServlet("/member/id-check")
public class IDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IDCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form , ajax
		String id = request.getParameter("userID");
		MemberDao memberDao = new MemberDao(); // db에 접속해서 일하는 애
		int result = memberDao.idCheck(id); //0,1
		Map<String,Integer> countMap = new HashMap<>();
		countMap.put("count", result);
		Gson gson = new Gson();
		String resultJson = gson.toJson(countMap);
		request.setAttribute("resultJson", resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/id-check.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
