package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dao.PersonalDao;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberPasswordProcess", value = "/personal/member-password-process")
public class MemberPasswordProcess extends HttpServlet {

    private final MemberDao memberDao = MemberDao.getInstance();
    private final PersonalDao personalDao = PersonalDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");
        String newPassword = request.getParameter("newPassword");

        if (password.equals("") || passwordCheck.equals("") || newPassword.equals("")) {
            ScriptWriter.alertAndBack(response, "빈 칸 있음");
        }

        HttpSession session = request.getSession();
        MemberDto member = (MemberDto) session.getAttribute("loggedMember");
        int userNo = member.getUserNo();
        System.out.println("userNo = " + userNo);
        String memberPassword = personalDao.memberPassword(userNo);


        if (!(password.equals(passwordCheck) || memberPassword.equals(password) || password.isEmpty() || newPassword.isEmpty())) {
//          비밀번호 확인
            ScriptWriter.alertAndBack(response, "비밀번호 확인");
        } else {
            MemberDto updatePasswordMember = new MemberDto();
            updatePasswordMember.setPw(newPassword);
            updatePasswordMember.setUserNo(userNo);
            int result = memberDao.updatePassword(updatePasswordMember);
            if (result > 0) {
                session.invalidate();
                ScriptWriter.alertAndGo(response, "재로그인 필요", "../member/login");
            } else {
                ScriptWriter.alertAndBack(response, "오류");
            }
        }
    }
}
