package com.health.controller.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.health.dao.MemberDao;
import com.health.dto.IdCheckDto;

@WebServlet("/member/id-check")
public class IDCheck extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private final MemberDao memberDao = MemberDao.getInstance();
       
    public IDCheck() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String id = request.getParameter("id");
      IdCheckDto idCheckDto = new IdCheckDto(id,id);
      int result = memberDao.idCheck(idCheckDto); //0,1
      Map<String,Integer> countMap = new HashMap<>();
      countMap.put("count", result);
      Gson gson = new Gson();
      String resultJson = gson.toJson(countMap);
      request.setAttribute("resultJson", resultJson);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/idCheck.jsp");
      dispatcher.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}