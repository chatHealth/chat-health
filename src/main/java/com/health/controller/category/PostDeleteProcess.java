package com.health.controller.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.health.dao.PostDao;

@WebServlet("/post/delete-process")
public class PostDeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PostDeleteProcess() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private final PostDao postDao = PostDao.getInstance();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		// 1. delete 
		int result = postDao.deletePost(postNo);
		
		// 2. 결과 보내기

		
		if (result > 0) {
			request.setAttribute("isDeleted", "success");

		} else {
			request.setAttribute("isDeleted", "fail");
		}

		// 3. modal 삭제
		HttpSession session = request.getSession();
		if(session.getAttribute("myModal")!=null) session.removeAttribute("myModal");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/product.jsp");
		dispatcher.forward(request, response);
	}

}
