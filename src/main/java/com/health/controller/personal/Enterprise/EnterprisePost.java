package com.health.controller.personal.Enterprise;

import com.health.dao.PersonalDao;
import com.health.dto.EnterpriseDto;
import com.health.dto.PostPageDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EnterprisePost", value = "/personal/enterprise-post")
public class EnterprisePost extends HttpServlet {
    PersonalDao personalDao = PersonalDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object loggedMember = session.getAttribute("loggedMember");
        EnterpriseDto loggedEnterprise = (EnterpriseDto) session.getAttribute("loggedEnterprise");

        if (loggedEnterprise == null || loggedMember != null) {
            ScriptWriter.alertAndGo(response, "잘못된 접근입니다.", "../");
        }

        int idx = Integer.parseInt(request.getParameter("idx"));
        idx = idx * 10 - 9;

        int count = personalDao.totalEntPosts(loggedEnterprise.getEnterpriseNo());
        int pages = (int) Math.ceil(count / 10.0);

        Map<String, Integer> map = new HashMap<>();
        map.put("enterpriseNo", loggedEnterprise.getEnterpriseNo());
        map.put("idx", idx);

        List<PostPageDto> posts = personalDao.entPost(map);

        request.setAttribute("totalMerchandise", count);
        request.setAttribute("pages", pages);
        request.setAttribute("posts", posts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/enterprise-post.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
