package com.health.controller.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.health.dao.MaterialDao;
import com.health.dao.SymptomDao;
import com.health.dto.MaterialDto;
import com.health.dto.SymptomDto;

@WebServlet("/post/write")
public class PostWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PostWrite() {
        super();
        
    }

    private final SymptomDao symptomDao = SymptomDao.getInstance();
	private final MaterialDao materialDao = MaterialDao.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<SymptomDto> symptomList = symptomDao.getAllSymptom();
		List<MaterialDto> materialList = materialDao.getAllMaterial();
		
		
		request.setAttribute("symptomList", symptomList);
		request.setAttribute("materialList", materialList);
		
		//nav
		HttpSession session = request.getSession();
		if(session.getAttribute("navSymptomList")==null) {
			session.setAttribute("navSymptomList", SymptomDao.getInstance().getAllSymptom());
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/post/write.jsp");
		dispatcher.forward(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
