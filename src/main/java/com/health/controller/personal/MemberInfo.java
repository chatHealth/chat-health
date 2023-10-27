package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dao.PersonalDao;
import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberInfo", value = "/personal/member-info")
public class MemberInfo extends HttpServlet {

    //생성자를 통해 MemberDao 객체를 생성할 수 없으므로 getInstance() 메서드 호출 -> singleton
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");
        EnterpriseDto loggedEnterprise = (EnterpriseDto) session.getAttribute("loggedEnterprise");

        if(loggedMember != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-info.jsp");
            requestDispatcher.forward(request, response);
        } else if (loggedEnterprise != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/enterprise-info.jsp");
            requestDispatcher.forward(request, response);
        } else {
            ScriptWriter.alertAndBack(response,"잘못된 접근입니다.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
