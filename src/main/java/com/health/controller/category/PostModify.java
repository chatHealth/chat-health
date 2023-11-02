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

import com.health.dao.MaterialDao;
import com.health.dao.MaterialPostDao;
import com.health.dao.PostDao;
import com.health.dao.SymptomDao;
import com.health.dao.SymptomPostDao;
import com.health.dto.MaterialDto;
import com.health.dto.PostDto;
import com.health.dto.SymptomDto;
import com.health.util.ModalState;

@WebServlet("/post/modify")
public class PostModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public PostModify() {
        super();
    }

	private final PostDao postDao = PostDao.getInstance();
	private final SymptomDao symptomDao = SymptomDao.getInstance();
	private final SymptomPostDao symptomPostDao = SymptomPostDao.getInstance();
	private final MaterialDao materialDao = MaterialDao.getInstance();
	private final MaterialPostDao materialPostDao = MaterialPostDao.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 0. 수정모달 처리
		if (session.getAttribute("myModal") == null) {
			ModalState modifyModal = new ModalState("show", "게시물 수정", "게시물을 수정하시겠습니까?", "예", "아니요");
			session.setAttribute("myModal", modifyModal);
			session.setAttribute("modifyNo", Integer.parseInt(request.getParameter("no")));
			response.sendRedirect("../category/list");
			
		} else {
			
			// 0. 모달 삭제
			session.removeAttribute("myModal");
			
			// 0. nav
			if(session.getAttribute("navSymptomList")==null) {
				session.setAttribute("navSymptomList", symptomDao.getAllSymptom());
			}
			
			// 1. get one post
			int no = (Integer)session.getAttribute("modifyNo");
			PostDto post =  postDao.getOnePost(no);

			// 2. symptom material
			List<SymptomDto> symptomList = symptomDao.getAllSymptom();
			List<Integer> selectedSymptomList = symptomPostDao.getSelectedSymptom(no);
			List<MaterialDto> materialList = materialDao.getAllMaterial();
			List<Integer> selectedMaterialList = materialPostDao.getSelectedMaterial(no);
			
			request.setAttribute("symptomList", symptomList);
			request.setAttribute("selectedSymptomList", selectedSymptomList);
			request.setAttribute("materialList", materialList);
			request.setAttribute("selectedMaterialList", selectedMaterialList);
			
			// 3. send
			request.setAttribute("post", post);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/post/modify.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
