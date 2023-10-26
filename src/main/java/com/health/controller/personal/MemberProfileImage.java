package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dao.PersonalDao;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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


        //root/uploadPath 경로 설정
//        String path = (File.separator + "uploadPath");
//        File Folder = new File(path);
//        if (!Folder.exists()) {
//            try{
//                Folder.mkdir(); //폴더 생성합니다. ("새폴더"만 생성)
//                System.out.println("폴더가 생성완료.");
//            }
//            catch(Exception e){
//                e.getStackTrace();
//            }
//        }

        //folder 없으면 만들기

        //Content-type 이 png, jpeg, jpg, gif 일 때만 받기
        String contentType = part.getContentType();
        String ext = contentType.split("/")[1];

        String[] images = {"image/png", "image/jpeg", "image/jpg", "image/gif"};

        if (!(Arrays.asList(images).contains(contentType))) {
            ScriptWriter.alertAndBack(response, "이미지 파일만 등록 가능");
        } else {
            String uploadDir = "/Users/wonu/Desktop/uploadProfile";

//        File profileImageDir = new File(uploadDir);

            HttpSession session = request.getSession();
//            MemberDto loginMember = (MemberDto) session.getAttribute("loginSession");
            MemberDto loggedMember = (MemberDto) session.getAttribute("loggedMember");

            String filename = loggedMember.getUserNo() + "_profileImage." + ext;


            part.write(uploadDir + File.separator +filename);

            MemberDto updateProfileMember = new MemberDto();

            updateProfileMember.setProfile(filename);
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
        }
    }
}
