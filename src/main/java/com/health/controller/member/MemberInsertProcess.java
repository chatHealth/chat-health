package com.jjang051.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.jjang051.dao.MemberDao;
import com.jjang051.dto.MemberDto;
import com.jjang051.dto.ModalState;

@WebServlet("/member/insert-process")
public class MemberInsertProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberInsertProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadDirectory = "C:\\upload02";
		String realUploadPath = uploadDirectory;
		
		
		Part part = request.getPart("profile");
		System.out.println(part);
		String partHeader = part.getHeader("Content-disposition");
		System.out.println(partHeader);
		String partArray[] = partHeader.split("filename=");
		String originalFileName = partArray[1].trim().replace("\"", "");
		System.out.println(originalFileName);
		String newFileName = "";
		
		
		String folder = "";
		if(!originalFileName.isEmpty()) {
			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			folder = simpleDateFormat.format(now);
			File dir = new File(realUploadPath+File.separator+folder);
			if(!dir.exists()) {
				dir.mkdir();
			}
			part.write(dir+File.separator+originalFileName);
		
			String firstFileName = originalFileName.substring(0,originalFileName.lastIndexOf("."));
			String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyyMMddHHmmss");
			String strNow = simpleDateFormat02.format(now);
			newFileName =  firstFileName+strNow+ext;
			System.out.println(newFileName);
			File oldFile = new File(dir+File.separator+originalFileName);
			File newFile = new File(dir+File.separator+newFileName);
			oldFile.renameTo(newFile);
		}
		 
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		int postCode = Integer.parseInt( request.getParameter("postCode"));
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		String profile = folder+File.separator+newFileName;
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userID);
		memberDto.setName(userName);
		memberDto.setPassword(userPW);
		memberDto.setAddress(address);
		memberDto.setDetailAddress(detailAddress);
		memberDto.setEmail(email);
		memberDto.setTel(tel);
		memberDto.setPostCode(postCode);
		memberDto.setProfile(profile);
		System.out.println(memberDto.toString());
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insertMember(memberDto);
		
		if(result>0) {
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show","회원가입되었습니다.");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../member/login");
		} else {
			HttpSession session = request.getSession();
			ModalState modalState = new ModalState("show","오류입니다.");
			session.setAttribute("modalState", modalState);
			response.sendRedirect("../member/insert");
		}
	}
}
