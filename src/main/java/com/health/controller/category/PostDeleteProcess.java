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
import com.health.util.ModalState;

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
		
		
		// 1. modal 삭제
		HttpSession session = request.getSession();
		if(session.getAttribute("myModal")!=null) session.removeAttribute("myModal");
		
		// 2. delete 
		int result = postDao.deletePost(postNo);
		
		
		// 3. 결과 보내기

		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		String resultJson = null;

		if (result > 0) {
			map.put("isAccepted", "ok");
			resultJson = gson.toJson(map);
			
			ModalState deleteModal = new ModalState("show","안내", "게시물이 삭제되었습니다", "확인");
			session.setAttribute("myModal", deleteModal);

		} else {
			map.put("isAccepted", "fail");
			resultJson = gson.toJson(map);
			
			ModalState deleteModal = new ModalState("show","안내", "게시물이 삭제되지않았습니다", "확인");
			session.setAttribute("myModal", deleteModal);
		}
		
		request.setAttribute("resultJson", resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/post/delete-result.jsp");
		dispatcher.forward(request, response);
		
	}

}
