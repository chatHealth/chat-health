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
            ScriptWriter.alertAndGo(response, "잘못된 접근입니다.", "../index/index");
        }

        int accepted = loggedEnterprise.getAccepted();

        int idx;
        if (request.getParameter("idx") == null) {
            idx = 1;
        } else {
            idx = Integer.parseInt(request.getParameter("idx"));
        }
        int count = personalDao.totalEntPosts(loggedEnterprise.getEnterpriseNo());
        int pages = (int) Math.ceil(count / 10.0);

        Map<String, Integer> map = new HashMap<>();
        map.put("enterpriseNo", loggedEnterprise.getEnterpriseNo());
        map.put("idx", idx * 10 - 9);

        //            정렬 기준
//            1, "TITLE";
//            2, "REGDATE";
//            3, "LIKES";

        int by;
        if (request.getParameter("by") == null) {
            by = 2;
        } else {
            by = Integer.parseInt(request.getParameter("by"));
        }
        map.put("by", by);

//            오름/내림차순
//            1, "DESC"
//            2, "ASC"
        int sort;
        if (request.getParameter("sort") == null) {
            sort = 1;
        } else {
            sort = Integer.parseInt(request.getParameter("sort"));
        }
        map.put("sort", sort);

        request.setAttribute("by", by);
        request.setAttribute("sort", sort);

        List<PostPageDto> posts = personalDao.entPost(map);

        request.setAttribute("idx", idx);
        request.setAttribute("accepted", accepted);
        request.setAttribute("totalMerchandise", count);
        request.setAttribute("posts", posts);


        request.setAttribute("pages", pages);

        int totalGroup = (int)Math.ceil(pages/5.0);
        int group=1;
        if(request.getParameter("group") != null) {
            group = Integer.parseInt(request.getParameter("group"));
        }
        int start = group * 5 - 4;
        int end = group * 5;
        if (end >= pages) {
            end = pages;
        }

        request.setAttribute("totalGroup", totalGroup);
        request.setAttribute("start", start);
        request.setAttribute("end", end);
        request.setAttribute("group",group);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/enterprise-post.jsp");
        dispatcher.forward(request, response);

    }
}