package com.health.controller.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.health.dao.SymptomDao;
import com.health.dto.MaterialDto;
import com.health.dto.SymptomDto;

@WebServlet("/index/index")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	  
    public MainPage() {
        super();
    }

    private final SymptomDao symptomDao = SymptomDao.getInstance();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SymptomDto> symptomList = symptomDao.getAllSymptom();
		request.setAttribute("symptomList", symptomList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index/index.jsp");
		dispatcher.forward(request, response); 

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
