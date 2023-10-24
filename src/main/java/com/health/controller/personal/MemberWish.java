package com.health.controller.personal;

import com.health.dao.MemberDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MemberWish", value = "/personal/member-wish")
public class MemberWish extends HttpServlet {

    //singleton
    private final MemberDao memberDao = MemberDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //list <- 유저 좋아요 post
        List<String> images = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            images.add(i + "번");
        }

        request.setAttribute("images", images);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-wish.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
