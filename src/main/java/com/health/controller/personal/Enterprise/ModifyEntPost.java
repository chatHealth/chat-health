package com.health.controller.personal.Enterprise;

import com.health.dao.*;
import com.health.dto.MaterialDto;
import com.health.dto.PostDto;
import com.health.dto.SymptomDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModifyEntPost", value = "/personal/modify-ent")
public class ModifyEntPost extends HttpServlet {
    SymptomDao symptomDao = SymptomDao.getInstance();
    MaterialDao materialDao = MaterialDao.getInstance();
    SymptomPostDao symptomPostDao = SymptomPostDao.getInstance();
    MaterialPostDao materialPostDao = MaterialPostDao.getInstance();
    PostDao postDao = PostDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. get one post
        int no = Integer.parseInt(request.getParameter("no"));
        PostDto post = postDao.getOnePost(no);

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/modify-post.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
