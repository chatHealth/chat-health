package com.health.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/post/modal-control")
public class ModalControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ModalControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ModalState modal = (ModalState)session.getAttribute("myModal");
		
		String action = request.getParameter("action");
		
		// 1. modal 삭제
		if(modal!=null && action.equals("delete")) {
			String button = request.getParameter("button");
			
			if(button.equals("accept") ) {
				if(modal.getTitle().equals("안내")) //안내면 삭제
				session.removeAttribute("myModal");
			}else if(button.equals("reject")) {  //취소면 다 삭제
				session.removeAttribute("myModal");
			}
		}
		
		// 2. 생성
		if(action.equals("create")) {
			String title = request.getParameter("title");
			
			if(title.equals("게시물 수정") ) {
				
				//response.sendRedirect("../category/list");
			}
		}

	}

}
