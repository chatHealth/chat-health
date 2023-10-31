package com.health.controller.review;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.health.dao.HelpfulDao;
import com.health.dao.PostDao;
import com.health.dto.HelpfulDto;
import com.health.dto.MemberDto;

@WebServlet("/review/HelpfulController")
public class HelpfulController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final HelpfulDao helpfulDao = HelpfulDao.getInstance();
       
    public HelpfulController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HelpfulDto helpfulDto =new HelpfulDto();
		
		HttpSession loggedSession = request.getSession();
		MemberDto loggedMember = (MemberDto)loggedSession.getAttribute("loggedMember");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		
		helpfulDto.setReviewNo(reviewNo);
		helpfulDto.setUserNo(loggedMember.getUserNo());
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
