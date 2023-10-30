package com.health.controller.personal;

import com.health.dao.PersonalDao;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberWithdraw", value = "/personal/member-withdraw")
public class MemberWithdraw extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object loggedMember = request.getAttribute("loggedMember");
        Object loggedEnterprise = request.getAttribute("loggedEnterprise");

        if (loggedMember == null && loggedEnterprise == null) {
            ScriptWriter.alertAndGo(response,"잘못된 접근입니다.", "../");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-withdraw.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
