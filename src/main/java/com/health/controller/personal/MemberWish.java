package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dao.PersonalDao;
import com.health.dto.MemberDto;
import com.health.dto.PostDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MemberWish", value = "/personal/member-wish")
public class MemberWish extends HttpServlet {

    //singleton
    private final PersonalDao personalDao = PersonalDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        MemberDto loginSession = (MemberDto) session.getAttribute("loginSession");
        int userNo = loginSession.getUserNo();

        List<PostDto> userLikePosts = personalDao.userLikePosts(userNo);

        request.setAttribute("userLikes", userLikePosts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-wish.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
