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
		List<PostDto> postList = postDao.getAllPost();
		request.setAttribute("postList", postList);
		
		//nav
		HttpSession session = request.getSession();
		if(session.getAttribute("navSymptomList")==null) {
			session.setAttribute("navSymptomList", SymptomDao.getInstance().getAllSymptom());
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/category/list.jsp");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/category/test.jsp");
		dispatcher.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
