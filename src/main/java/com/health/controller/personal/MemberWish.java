package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dao.PersonalDao;
import com.health.dto.MemberDto;
import com.health.dto.PostDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MemberWish", value = "/personal/member-wish")
public class MemberWish extends HttpServlet {

    //singleton
    private final PersonalDao personalDao = PersonalDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        MemberDto member = (MemberDto) session.getAttribute("loggedMember");
        if (member == null) {
            ScriptWriter.alertAndGo(response,"잘못된 접근입니다.", "../index/index");
        }
        int userNo = member.getUserNo();

        HashMap<String, Integer> map = new HashMap<>();

        int idx = Integer.parseInt(request.getParameter("idx"));

        idx = idx * 8 - 7;

        map.put("userNo", userNo);
        map.put("idx", idx);

        int count = personalDao.totalMemWish(userNo);
        int pages = (int) Math.ceil(count / 8.0);

        List<PostDto> userLikePosts = personalDao.userLikePosts(map);

        request.setAttribute("pages", pages);
        request.setAttribute("userLikes", userLikePosts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-wish.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
