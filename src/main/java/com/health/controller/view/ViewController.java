package com.health.controller.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.health.dao.ReviewDao;
import com.health.dto.ReviewDto;


@WebServlet("/view/product")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReviewDao reviewDao = new ReviewDao();
	
    public ViewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		//리뷰정보전달
		List<Map<String,Object>> reviewList = reviewDao.selectReview(no);
		request.setAttribute("reviewList", reviewList);
		
		
		//제품정보전달
<<<<<<< HEAD
		List<Map<String,Object>> postInfo = reviewDao.postInfo(no);
=======
		List<Map<String,Object>> postInfo = reviewDao.selectReview(no);
>>>>>>> 157edffc7e53e8b711175115dad7ed49ffc1f634
		request.setAttribute("postInfo", postInfo);
		
		
		HttpSession session= request.getSession();
		session.getAttribute("loggedMember");
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/view/product.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
