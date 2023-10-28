package com.health.controller.personal;

import com.health.dao.PersonalDao;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "MemberReview", value = "/personal/member-review")
public class MemberReview extends HttpServlet {
    PersonalDao personalDao = PersonalDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");
        if (loggedMember == null) {
            ScriptWriter.alertAndGo(response,"잘못된 접근입니다.", "../");
        }else{
            int userNo = loggedMember.getUserNo();
            List<HashMap<String, Object>> memReviews = personalDao.memReview(userNo);
            request.setAttribute("reviews", memReviews);
            System.out.println(memReviews.size());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-review.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
