package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dao.PersonalDao;
import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "MemberProfileImage", value = "/personal/member-profile-image")
public class MemberProfileImage extends HttpServlet {

    private final MemberDao memberDao = MemberDao.getInstance();
    private final PersonalDao personalDao = PersonalDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("profileImage");

        //Content-type 이 png, jpeg, jpg, gif 일 때만 받기
        String contentType = part.getContentType();
        String ext = contentType.split("/")[1];

        String[] images = {"image/png", "image/jpeg", "image/jpg", "image/gif"};

        if (!(Arrays.asList(images).contains(contentType))) {
            ScriptWriter.alertAndBack(response, "이미지 파일만 등록 가능");
        } else {
            //directory 환경변수 설정
          	String uploadDir = System.getenv("upload");

            HttpSession session = request.getSession();
            MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");
            EnterpriseDto loggedEnterprise = (EnterpriseDto) session.getAttribute("loggedEnterprise");

            if (loggedMember != null) { //개인
            	
            	//파일명 바꾸기
                String filename = "member" + loggedMember.getUserNo() + "_profileImage." + ext;
                part.write(uploadDir + File.separator + filename);
                MemberDto updateProfileMember = new MemberDto();

                updateProfileMember.setProfile(File.separator+"upload"+File.separator+filename);
                updateProfileMember.setUserNo(loggedMember.getUserNo());

                int result = memberDao.updateProfileImage(updateProfileMember);
                
                if (result > 0) {
                    //프사 변경 완료
                    MemberDto updateProfile = personalDao.memberInfo(loggedMember.getUserNo());
                    updateProfile.setPw(null);
                    session.setAttribute("loggedMember", updateProfile);
                    response.sendRedirect("../personal/member-info");
                } else {
                    ScriptWriter.alertAndBack(response, "잘못된 접근입니다.");
                }
            } else if (loggedEnterprise != null) { //사업자

                String filename = "ent" + loggedEnterprise.getEnterpriseNo() + "_profileImage." + ext;
                part.write(uploadDir + File.separator + filename);

                EnterpriseDto updateProfileEnt = new EnterpriseDto();

                updateProfileEnt.setProfile(File.separator+"upload"+File.separator+filename);
                updateProfileEnt.setEnterpriseNo(loggedEnterprise.getEnterpriseNo());

                int result = personalDao.updateProfileImage(updateProfileEnt);

                if (result > 0) {
                    //프사 변경 완료
                    EnterpriseDto updateProfile = personalDao.EnterpriseInfo(loggedEnterprise.getEnterpriseNo());
                    updateProfile.setPw(null);
                    session.setAttribute("loggedEnterprise", updateProfile);
                    response.sendRedirect("../personal/member-info");
                } else {
                    ScriptWriter.alertAndBack(response, "잘못된 접근입니다.");
                }
            } else {
                ScriptWriter.alertAndBack(response, "잘못된 접근입니다.");
            }
        }
    }
}
