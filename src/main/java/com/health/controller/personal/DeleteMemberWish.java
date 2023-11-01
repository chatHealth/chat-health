package com.health.controller.personal;

import com.google.gson.Gson;
import com.health.dao.PersonalDao;
import com.health.dto.UserLikeDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/personal/delete-wish")
public class DeleteMemberWish extends HttpServlet{
    private static final PersonalDao personalDao = PersonalDao.getInstance();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int userNo = Integer.parseInt(request.getParameter("userNo"));
            int postNo = Integer.parseInt(request.getParameter("postNo"));

            UserLikeDto userLikeDto = new UserLikeDto();
            userLikeDto.setUserNo(userNo);
            userLikeDto.setPostNo(postNo);

            int isWish = personalDao.isLike(userLikeDto);

            int result = 0;
            int states = 0;
            if(isWish > 0){
                result = personalDao.deleteLike(userLikeDto);
            } else if (isWish == 0) {
                result = personalDao.addLike(userLikeDto);
                states = 1;
            }
            Gson gson = new Gson();
            Map<String, Integer> countMap = new HashMap<>();
            countMap.put("count", result);
            countMap.put("states", states);
            String resultJson = gson.toJson(countMap);
            request.setAttribute("resultJson", resultJson);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/delete-wish.jsp");
            dispatcher.forward(request, response);
        }

}
