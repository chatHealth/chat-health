package com.health.controller.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.health.dao.PostDao;
import com.health.dao.SymptomDao;
import com.health.dto.MaterialDto;
import com.health.dto.PostDto;
import com.health.dto.SymptomDto;


@WebServlet("/category/list")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoryList() {
        super();
    }


    private final PostDao postDao = PostDao.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. nav
		HttpSession session = request.getSession();
		if(session.getAttribute("navSymptomList")==null) {
			session.setAttribute("navSymptomList", SymptomDao.getInstance().getAllSymptom());
		}
		
		// 1. post list get
		List<PostDto> postList = null;
		postList = postDao.getAllPost();
		
		String keyword = request.getParameter("keyword");
		String symp = request.getParameter("symp");
		
		int sympNo = 0;
		if(symp != null) sympNo=Integer.parseInt(symp);
		
		if(keyword == null) { // 1) 검색창으로 온경우
			
		}else if(sympNo > 0) {  // 2) 증상 선택으로 온경우
			
		}else {  // 3) 전체
			postList = postDao.getAllPost();
		}
		
		
		
		// 2. post list send
		//if(postList.size() == 0) { postList = null; }
		request.setAttribute("postList", postList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/category/list.jsp");
		dispatcher.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
