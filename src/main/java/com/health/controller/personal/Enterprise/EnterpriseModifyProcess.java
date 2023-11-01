package com.health.controller.personal.Enterprise;

import com.health.dao.MemberDao;
import com.health.dao.PersonalDao;
import com.health.dto.EnterpriseDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EnterpriseModify", value = "/personal/enterprise-modify-process")
public class EnterpriseModifyProcess extends HttpServlet {
//    private final PersonalDao personalDao = PersonalDao.getInstance();
    private final MemberDao memberDao = MemberDao.getInstance();
    private final PersonalDao personalDao = PersonalDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        EnterpriseDto loggedEnterprise = (EnterpriseDto) session.getAttribute("loggedEnterprise");

        if (loggedEnterprise == null) {
            ScriptWriter.alertAndGo(response,"잘못된 접근입니다.","../index/index");
        }

        String tel = request.getParameter("tel");
        String ceo = request.getParameter("ceo");
        String address = request.getParameter("address");
        String addressDetail = request.getParameter("addressDetail");
        int enterpriseNo = loggedEnterprise.getEnterpriseNo();

        EnterpriseDto updateEnterprise = new EnterpriseDto();
        updateEnterprise.setEnterpriseNo(enterpriseNo);
        updateEnterprise.setTel(tel);
        updateEnterprise.setCeo(ceo);
        updateEnterprise.setAddress(address);
        updateEnterprise.setAddressDetail(addressDetail);

        int result = memberDao.updateEnterprise(updateEnterprise);
        if (result > 0) {
            EnterpriseDto enterpriseDto = personalDao.EnterpriseInfo(enterpriseNo);
            enterpriseDto.setPw(null);
            session.setAttribute("loggedEnterprise", enterpriseDto);
            response.sendRedirect("../personal/member-info");
        } else {
            ScriptWriter.alertAndBack(response, "오류");
        }

    }
}
