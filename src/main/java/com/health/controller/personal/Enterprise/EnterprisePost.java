package com.health.controller.personal.Enterprise;

import com.health.dao.PersonalDao;
import com.health.dto.EnterpriseDto;
import com.health.dto.PostPageDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EnterprisePost", value = "/personal/enterprise-post")
public class EnterprisePost extends HttpServlet {
    PersonalDao personalDao = PersonalDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object loggedMember = session.getAttribute("loggedMember");
        EnterpriseDto loggedEnterprise = (EnterpriseDto) session.getAttribute("loggedEnterprise");

        if (loggedEnterprise == null || loggedMember != null) {
            ScriptWriter.alertAndBack(response, "잘못된 접근입니다.");
        }

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("start", 1);
//        map.put("end", 10);
//        map.put("enterpriseNo", loggedEnterprise1.getEnterpriseNo());
//        System.out.println(map.get("enterpriseNo"));

//        System.out.println("loggedEnterprise1 = " + loggedEnterprise1.getEnterpriseNo());

        int enterpriseNo = loggedEnterprise.getEnterpriseNo();
        List<PostPageDto> posts = personalDao.entPost(enterpriseNo);

        request.setAttribute("posts", posts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/enterprise-post.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
