package com.health.controller.personal;

import com.health.dao.PersonalDao;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberWithdrawProcess", value = "/personal/member-withdraw-process")
public class MemberWithdrawProcess extends HttpServlet {

    PersonalDao personalDao = PersonalDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        int loggedNo = (int) session.getAttribute("loggedNo");
        MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");
        int loggedNo = loggedMember.getUserNo();
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");
        String memberPassword = personalDao.memberPassword(loggedNo);

        if (!(password.equals(passwordCheck) && !password.equals("") && password.equals(memberPassword))) {
            ScriptWriter.alertAndBack(response, "비밀번호를 확인하세요.");
        } else {
            int result = personalDao.memberWithdraw(loggedNo);
            if (result > 0) {
                session.invalidate();
                ScriptWriter.alertAndGo(response, "탈퇴되었습니다.", "../board/list");
            } else {
                ScriptWriter.alertAndBack(response, "오류");
            }
        }

    }
}
