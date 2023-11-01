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
import com.health.util.ScriptWriter;

@WebServlet("/review/HelpfulController")
public class HelpfulController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final HelpfulDao helpfulDao = HelpfulDao.getInstance();

	public HelpfulController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HelpfulDto helpfulDto = new HelpfulDto();

		HttpSession loggedSession = request.getSession();
		MemberDto loggedMember = (MemberDto) loggedSession.getAttribute("loggedMember");
		int no = Integer.parseInt(request.getParameter("productNo"));

		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));

		helpfulDto.setReviewNo(reviewNo);

		if (loggedMember != null) {
			helpfulDto.setUserNo(loggedMember.getUserNo());
			int helpfulSame = helpfulDao.helpfulSame(helpfulDto);

			if (helpfulSame > 0) {
				helpfulDto.setUserNo(loggedMember.getUserNo());
				helpfulDao.helpfulCancel(helpfulDto);
				response.sendRedirect("../view/product?no=" + no);
			} else {
				helpfulDto.setUserNo(loggedMember.getUserNo());
				helpfulDao.helpfulAdd(helpfulDto);
				response.sendRedirect("../view/product?no=" + no);
			}
		} else {
			ScriptWriter.alertAndBack(response, "로그인한 사용자만 가능합니다");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
