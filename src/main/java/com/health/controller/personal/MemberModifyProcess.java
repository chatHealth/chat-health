package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberModifyProcess", value = "/personal/member-modify-process")
public class MemberModifyProcess extends HttpServlet {

    private final MemberDao memberDao = MemberDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberDto loginMember = (MemberDto) session.getAttribute("member");
        int userNo = loginMember.getUserNo();

        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String addressDetail = request.getParameter("addressDetail");

        MemberDto memberDto = new MemberDto();
        memberDto.setUserNo(userNo);
        memberDto.setNickname(nickname);
        memberDto.setEmail(email);
        memberDto.setAddress(address);
        memberDto.setAddressDetail(addressDetail);

        int result = memberDao.updateMember(memberDto);

        if (result > 0) {
            response.sendRedirect("../personal/member-info");
        } else {
            ScriptWriter.alertAndBack(response,"오류입니다.");
        }
    }
}
