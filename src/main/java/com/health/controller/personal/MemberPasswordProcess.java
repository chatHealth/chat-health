package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dto.MemberDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberPasswordProcess", value = "/personal/member-password-process")
public class MemberPasswordProcess extends HttpServlet {

    private final MemberDao memberDao = MemberDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");
        String newPassword = request.getParameter("newPassword");

        MemberDto loginMember = (MemberDto) request.getSession().getAttribute("loginSession");


        if (!password.equals(passwordCheck) || !loginMember.getPw().equals(password) || password.isEmpty() || newPassword.isEmpty()) {
//          비밀번호 확인
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('비밀번호 확인'); history.go(-1);</script>");
            out.flush();
            response.flushBuffer();
            out.close();
        } else {
            MemberDto updatePasswordMember = new MemberDto();
            updatePasswordMember.setPw(password);
            updatePasswordMember.setUserNo(loginMember.getUserNo());
            int result = memberDao.updatePassword(updatePasswordMember);
            if (result > 1) {
                response.sendRedirect("../WEB-INF/personal/member-info");
            } else {
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('서버 오류'); history.go(-1);</script>");
                out.flush();
                response.flushBuffer();
                out.close();
            }
        }
    }
}
