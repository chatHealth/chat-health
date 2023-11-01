package com.health.controller.personal;

import com.health.dao.PersonalDao;
import com.health.dto.MemberDto;
import com.health.dto.personal.MemberReviewPageDto;
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
            ScriptWriter.alertAndGo(response,"잘못된 접근입니다.", "../index/index");
        }else{
            int userNo = loggedMember.getUserNo();
            Map<String, Integer> map = new HashMap<>();

            map.put("no", userNo);

            int idx;
            if (request.getParameter("idx") == null) {
                idx = 1;
            } else {
                idx = Integer.parseInt(request.getParameter("idx"));
                idx = 10 * idx - 9;
            }
            map.put("idx", idx);

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

            int count = personalDao.memReviewsCount(userNo);
            int pages = (int) Math.ceil(count / 10.0);

            request.setAttribute("by", by);
            request.setAttribute("sort", sort);
            request.setAttribute("pages", pages);
            List<MemberReviewPageDto> memReviews = personalDao.memReview(map);
            request.setAttribute("reviews", memReviews);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-review.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
