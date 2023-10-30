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
import java.util.Map;

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
            Map<String, Integer> map = new HashMap<>();

            map.put("no", userNo);
            int idx = Integer.parseInt(request.getParameter("idx"));
            idx = 10 * idx - 9;
            map.put("idx", idx);

            int count = personalDao.memReviewsCount(userNo);
            int pages = (int) Math.ceil(count / 10.0);

            request.setAttribute("pages", pages);
            List<HashMap<String, Object>> memReviews = personalDao.memReview(map);
            request.setAttribute("reviews", memReviews);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-review.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
