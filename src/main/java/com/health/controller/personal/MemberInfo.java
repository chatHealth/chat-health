package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dto.MemberDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberInfo", value = "/personal/member-info")
public class MemberInfo extends HttpServlet {

    //생성자를 통해 MemberDao 객체를 생성할 수 없으므로 getInstance() 메서드 호출 -> singleton
    private final MemberDao memberDao = MemberDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDto memberDto = new MemberDto();
        memberDto.setId("id18");
        memberDto.setPw("pw18");

        HttpSession session = request.getSession();
        MemberDto loginMember = memberDao.loginMember(memberDto);

        session.setAttribute("loginSession", loginMember);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/personal/member-info.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
