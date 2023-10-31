package com.health.controller.review;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.apache.catalina.Session;

import com.health.dao.ReviewDao;
import com.health.dto.MemberDto;
import com.health.dto.ReviewDto;
import com.health.util.ModalState;

@WebServlet("/review/ReviewAdd")
public class ReviewAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReviewAdd() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReviewDto reviewDto = new ReviewDto();
		ReviewDao reviewDao = new ReviewDao();

		HttpSession loggedSession = request.getSession();
		MemberDto loggedMember = (MemberDto)loggedSession.getAttribute("loggedMember");


		String recontent = request.getParameter("recontent");
		String retitle = request.getParameter("retitle");
		int no = Integer.parseInt(request.getParameter("no"));


		reviewDto.setUserNo(loggedMember.getUserNo());
		reviewDto.setPostNo(no);
		reviewDto.setTitle(retitle);
		reviewDto.setContent(recontent);
		reviewDto.setHelpful(0);

		int result = reviewDao.insertRivew(reviewDto);
		if(result>0) {
			response.sendRedirect("../view/product?no="+no);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
