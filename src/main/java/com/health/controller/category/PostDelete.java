package com.health.controller.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import com.health.dao.PostDao;
import com.health.dao.ReviewDao;
import com.health.dao.SymptomDao;
import com.health.dto.PostDto;
import com.health.util.ModalState;

@WebServlet("/post/delete")
public class PostDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PostDelete() {
        super();
    }

    private final SymptomDao symptomDao = SymptomDao.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. nav
		HttpSession session = request.getSession();
		if(session.getAttribute("navSymptomList")==null) {
			session.setAttribute("navSymptomList", symptomDao.getAllSymptom());
		}
		
		//1. modal
		ModalState deleteModal = new ModalState("show","게시물 삭제", "게시물을 삭제하시겠습니까?", "예", "아니요");
		session.setAttribute("myModal", deleteModal);
		
		
		// 2. post
		int no = Integer.parseInt(request.getParameter("no"));
		Map<String,Object> postInfo = ReviewDao.getInstance().postInfo(no);
		request.setAttribute("postInfo", postInfo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/product.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
