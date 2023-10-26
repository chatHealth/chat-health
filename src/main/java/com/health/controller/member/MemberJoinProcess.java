package com.health.controller.member;

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

import com.health.dao.MemberDao;
import com.health.dto.MemberDto;
import com.health.dto.ModalState;
import com.health.util.ScriptWriter;

@WebServlet("/member/member-join-process")
public class MemberJoinProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberDao memberDao = MemberDao.getInstance();

	public MemberJoinProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 값 넘겨받기
		
				
				String id = request.getParameter("id");
				String email = request.getParameter("email");
				String name = request.getParameter("name");
				String nickname = request.getParameter("nickname");
				String pw = request.getParameter("pw");
				String gender = request.getParameter("gender");
				String address = request.getParameter("address");		
				String addressDetail = request.getParameter("addressDetail");
				Part profile = request.getPart("profile");
				
				
	
				
				//2. < 이미지 처리 >
						// 파일 업로드 경로 바깥에
						String uploadDir = "C:\\upload";
						String realUploadPath = uploadDir;

						// 파일이름찾기
						String partHeader = profile.getHeader("Content-disposition"); // 넘어오는 data -> form-data; name="profile";
																						// filename="a.png"
						String partHeaderArray[] = partHeader.split("filename=");
						String originFileName = partHeaderArray[1].trim().replace("\"", ""); // 맨뒤 따옴표 제거

						String newFileName = "";
						
						if (!originFileName.isEmpty()) {
							// 실질적인(물리적인)경로에 파일생기도록
						
							profile.write(realUploadPath + File.separator + originFileName);
							
							

							// 파일명바꾸기 -날짜붙이기
							Date now = new Date();
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
							String strNow = simpleDateFormat.format(now); // ->20230927-151801

							String firstFile = originFileName.substring(0, originFileName.lastIndexOf("."));
							String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 확장자뽑기 ->.png
							newFileName = firstFile + strNow + ext;

							File oldFile = new File(realUploadPath + File.separator + originFileName);
							File newFile = new File(realUploadPath + File.separator + newFileName);
							oldFile.renameTo(newFile);

						}
						
						//3. 데이터 set
						MemberDto parameterDto = new MemberDto();
						parameterDto.setId(id);
						parameterDto.setEmail(email);
						parameterDto.setName(name);
						parameterDto.setNickName(nickname);
						parameterDto.setPw(pw);
						parameterDto.setGender(gender);
						parameterDto.setAddress(address);
						parameterDto.setAddressDetail(addressDetail);
						parameterDto.setProfile(realUploadPath + File.separator + newFileName);
						parameterDto.setBirthDate("2023-11-11");
						
						System.out.println(parameterDto);
						
						//4. 인서트
						int result = memberDao.insertMember(parameterDto);
								
						
						if(result>0) {
							response.sendRedirect("../member/login");
						} else {
							HttpSession session = request.getSession();
							response.sendRedirect("../member/member-join-process");
							}
			}
}
