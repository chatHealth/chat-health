package com.health.controller.personal;

import com.health.dao.MemberDao;
import com.health.dto.MemberDto;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("profileImage");
        System.out.println(part.toString());


        //root/uploadPath 경로 설정
        String path = (File.separator + "uploadPath");
        File Folder = new File(path);
        if (!Folder.exists()) {
            try{
                Folder.mkdir(); //폴더 생성합니다. ("새폴더"만 생성)
                System.out.println("폴더가 생성완료.");
            }
            catch(Exception e){
                e.getStackTrace();
            }
        }
        System.out.println("path = " + path);

        //folder 없으면 만들기

        //Content-type 이 png, jpeg, jpg, gif 일 때만 받기
        String contentType = part.getContentType();
        String ext = contentType.split("/")[1];

        String[] images = {"image/png", "image/jpeg", "image/jpg", "image/gif"};

        if (!(Arrays.asList(images).contains(contentType))) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('png, jpg, jpeg, gif만 등록 가능'); history.go(-1);</script>");
            out.flush();
            response.flushBuffer();
            out.close();
        } else {
            String uploadDir = "/Users/wonu/Desktop/uploadProfile";
            System.out.println(uploadDir);

//        File profileImageDir = new File(uploadDir);

            HttpSession session = request.getSession();
            MemberDto loginMember = (MemberDto) session.getAttribute("loginSession");

            String filename = loginMember.getID() + "_profileImage." + ext;

            System.out.println(filename);

            part.write(path + filename);

            MemberDto updateProfileMember = new MemberDto();

            updateProfileMember.setProfile(filename);
            updateProfileMember.setUserNo(loginMember.getUserNo());

            int result = memberDao.updateProfileImage(updateProfileMember);

            if (result > 0) {
                //프사 변경 완료
                response.sendRedirect("../personal/member-info");
            } else {
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('실패! 다시 시도 하세요'); history.go(-1);</script>");
                out.flush();
                response.flushBuffer();
                out.close();
            }
        }
    }
}
