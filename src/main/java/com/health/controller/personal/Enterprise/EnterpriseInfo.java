package com.health.controller.personal.Enterprise;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EnterpriseInfo", value = "/personal/enterprise-info")
public class EnterpriseInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object enterprise = session.getAttribute("enterprise");
        System.out.println(enterprise.toString());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/personal/enterprise-info.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
