package com.health.controller.personal;

import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberModify", value = "/personal/member-modify")
public class MemberModify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");
        EnterpriseDto loggedEnterprise = (EnterpriseDto) session.getAttribute("loggedEnterprise");

        if(loggedMember!=null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-modify.jsp");
            requestDispatcher.forward(request, response);
        } else if (loggedEnterprise != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/enterprise-modify.jsp");
            requestDispatcher.forward(request, response);
        } else {
            ScriptWriter.alertAndBack(response, "잘못된 접근입니다.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
