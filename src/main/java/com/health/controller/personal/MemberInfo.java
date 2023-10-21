package com.health.controller.personal.member;

import com.health.dao.MemberDao;
import com.health.dao.MemberDaoImpl;
import com.health.dto.MemberDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberInfo", value = "/personal/member/info")
public class MemberInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto memberDto = new MemberDto();
        MemberDao memberDao = new MemberDaoImpl();
        memberDto.setId("id18");
        memberDto.setPw("pw18");

        HttpSession session = request.getSession();
        MemberDto loginMember = memberDao.loginMember(memberDto);

        session.setAttribute("loginMember", loginMember);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-info.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
