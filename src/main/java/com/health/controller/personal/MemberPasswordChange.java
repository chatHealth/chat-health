package com.health.controller.personal;

import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberPasswordChange", value = "/personal/member-password")
public class MemberPasswordChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object loggedMember = session.getAttribute("loggedMember");
        Object loggedEnterprise = session.getAttribute("loggedEnterprise");

        if(loggedMember == null && loggedEnterprise==null) {
            ScriptWriter.alertAndBack(response,"잘못된 접근입니다.");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-password.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
