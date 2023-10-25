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
import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.dto.ModalState;

@WebServlet("/member/member-join-process")
public class MemberJoinProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberDao memberDao = MemberDao.getInstance();
       
    public MemberJoinProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 값 넘겨받기
				String id = request.getParameter("id");
				String email = request.getParameter("email");
				String name = request.getParameter("name");
				String pw = request.getParameter("pw");
				String pw2 = request.getParameter("pw2");
				String address = request.getParameter("address");		
				String addressDetail = request.getParameter("addressDetail");
				Part profile = request.getPart("profile");
				int grade = Integer.parseInt(request.getParameter("grade"));
				
				// 비번 일치여부 확인
				if(pw == pw2) {
					return;
				}else {
					HttpSession session = request.getSession();
					ModalState modalState = new ModalState("show","오류입니다.");
					session.setAttribute("modalState", modalState);
					response.sendRedirect("../member/member-join");
					}
				
				//2. < 이미지 처리 >
						// 파일 업로드 경로 바깥에
						String uploadDir = "C:\\Users\\user\\Pictures";
						String realUploadPath = uploadDir;

						// 파일이름찾기
						String partHeader = profile.getHeader("Content-disposition"); // 넘어오는 data -> form-data; name="profile";
																						// filename="a.png"
						String partHeaderArray[] = partHeader.split("filename=");
						String originFileName = partHeaderArray[1].trim().replace("\"", ""); // 맨뒤 따옴표 제거

						String newFileName = "";
						System.out.println(newFileName);
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
						parameterDto.setID(id);
						parameterDto.setEmail(email);
						parameterDto.setName(name);
						parameterDto.setPW(pw);
						parameterDto.setAddress(address);
						parameterDto.setAddressDetail(addressDetail);
						parameterDto.setProfile(realUploadPath + File.separator + newFileName);
						parameterDto.setGrade(grade);
						
						//4. 인서트
						int result = memberDao.insertMember(parameterDto);
								
						
						if(result>0) {
							HttpSession session = request.getSession();
							ModalState modalState = new ModalState("show","회원가입되었습니다.");
							session.setAttribute("modalState", modalState);
							response.sendRedirect("../member/login");
						} else {
							HttpSession session = request.getSession();
							ModalState modalState = new ModalState("show","오류입니다.");
							session.setAttribute("modalState", modalState);
							response.sendRedirect("../member/enterprise-join");
							}
			}
	}


