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
import java.util.List;

import com.health.dao.MaterialDao;
import com.health.dao.PostDao;
import com.health.dao.SymptomDao;
import com.health.dto.MaterialDto;
import com.health.dto.MaterialPostDto;
import com.health.dto.PostDto;
import com.health.dto.SymptomDto;


@WebServlet("/category/list")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoryList() {
        super();
    }


    private final PostDao postDao = PostDao.getInstance();
    private final SymptomDao symptomDao = SymptomDao.getInstance();
    private final MaterialDao materialDao  = MaterialDao.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. nav
		HttpSession session = request.getSession();
		if(session.getAttribute("navSymptomList")==null) {
			session.setAttribute("navSymptomList", symptomDao.getAllSymptom());
		}
				
		// 1. post list get
		//1) 초기화
		List<PostDto> postList = null;
		HashMap<String,String> map = new HashMap<>();   // sort, 페이지, 증상번호 저장, 키워드 저장
		
		//map.put("start", start);
		//map.put("end", end);
		
		
		// 2) 정렬
		String sort = request.getParameter("sort");
		if(sort==null || sort.equals("recent")) {
			map.put("sort", "recent");
		} else if (sort.equals("recommended")){
			map.put("sort", "recommended");
		} else if (sort.equals("reviewed")) {
			map.put("sort", "reviewed");
		}
		
		// 3) 증상, 키워드 얻어오기
		String keyword = request.getParameter("keyword");
		String symp = request.getParameter("symp");
		int sympNo = 0;
		if(symp != null) sympNo=Integer.parseInt(symp);
		
		// 3) real get part, set info
		if(sympNo > 0) { 								// 1) 증상선택 온경우
			map.put("sympNo", symp);
			postList = postDao.getPostForSympno(map);
			
			request.setAttribute("info", symptomDao.getsymptName(sympNo));
		}else if(keyword != null) { 					 // 2) 검색창으로 온경우
			map.put("keyword", keyword);
			postList = postDao.getPostForKeyword(map);
			
			request.setAttribute("info", keyword);
		}else {  											// 3) 전체
			postList = postDao.getPostForAll(map);
		}
		
		
		// 2. 영양소 얻어오기
		List<MaterialDto> materialList = materialDao.getMaerialBySymptom(sympNo);
		
		// 3. send
		//if(postList.size() == 0) { postList = null; }
		request.setAttribute("postList", postList);
		request.setAttribute("materialList", materialList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/category/list.jsp");
		dispatcher.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
