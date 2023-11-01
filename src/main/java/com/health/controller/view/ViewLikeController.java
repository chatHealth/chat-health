package com.health.controller.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.health.dao.ViewLikeDao;
import com.health.dto.MemberDto;
import com.health.dto.UserLikeDto;
import com.health.util.ScriptWriter;


@WebServlet("/view/viewlike")
public class ViewLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ViewLikeDao viewLikeDao = ViewLikeDao.getInstance();

	public ViewLikeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLikeDto userLikeDto = new UserLikeDto();

		HttpSession loggedSession = request.getSession();
		MemberDto loggedMember = (MemberDto) loggedSession.getAttribute("loggedMember");
		int no = Integer.parseInt(request.getParameter("viewLikeNo"));
		
		
		
		userLikeDto.setPostNo(no);

		if (loggedMember != null) {
			userLikeDto.setUserNo(loggedMember.getUserNo());
			int helpfulSame = viewLikeDao.sameViewLike(userLikeDto);

			if (helpfulSame > 0) {
				userLikeDto.setUserNo(loggedMember.getUserNo());
				viewLikeDao.deletViewLike(userLikeDto);
				response.sendRedirect("../view/product?no=" + no);
			} else {
				userLikeDto.setUserNo(loggedMember.getUserNo());
				viewLikeDao.insertViewLike(userLikeDto);
				response.sendRedirect("../view/product?no=" + no);
			}
		} else {
			ScriptWriter.alertAndBack(response, "로그인한 사용자만 가능합니다");
		}
	}
	}