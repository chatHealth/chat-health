package com.health.controller.category;

import jakarta.servlet.RequestDispatcher;
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

import com.health.dao.MaterialDao;
import com.health.dao.MaterialPostDao;
import com.health.dao.PostDao;
import com.health.dao.SymptomDao;
import com.health.dao.SymptomPostDao;
import com.health.dto.MaterialPostDto;
import com.health.dto.PostDto;
import com.health.dto.SymptomPostDto;

@WebServlet("/post/modify-process")
public class PostModifyProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostModifyProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private final PostDao postDao = PostDao.getInstance();
	private final SymptomPostDao spDao = SymptomPostDao.getInstance();
	private final MaterialPostDao mpDao = MaterialPostDao.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 값 넘겨받기
		int enNo = Integer.parseInt(request.getParameter("enNo"));
		Part titleImg = request.getPart("titleImg");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String symptomOptions[] = request.getParameterValues("symptomOptions");
		String materialOptions[] = request.getParameterValues("materialOptions");

		
		//2. < 이미지 처리 >
		// 파일 업로드 경로 바깥에
		String uploadDir = "C:\\upload";
		String realUploadPath = uploadDir;

		// 파일이름찾기
		String partHeader = titleImg.getHeader("Content-disposition"); // 넘어오는 data -> form-data; name="profile";
																		// filename="a.png"
		String partHeaderArray[] = partHeader.split("filename=");
		String originFileName = partHeaderArray[1].trim().replace("\"", ""); // 맨뒤 따옴표 제거

		String newFileName = "";
		String saveDir = "";
		if (!originFileName.isEmpty()) {
			// 실질적인(물리적인)경로에 파일생기도록
			titleImg.write(realUploadPath + File.separator + originFileName);

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
			
			saveDir="/upload";

		}else {
			//대표 이미지 선택안했을경우, img파일의 기본이미지로 대체
			saveDir = request.getContextPath()+ File.separator + "img";
			newFileName = "basic_post.svg";
		}
		
		//3. post insert
		int postNo = Integer.parseInt(request.getParameter("postNo")); 
		
		PostDto postDto = new PostDto();
		postDto.setPostNo(postNo);
		postDto.setEnterpriseNo(enNo);
		postDto.setTitle(title);
		postDto.setContent(content);
		postDto.setPostImg(saveDir + File.separator + newFileName);
		int postRes = postDao.updatePost(postDto);
		
		
//		// 4. symptom, material insert
//		int tmp;
//		int symptomRes = 0;
//		if (symptomOptions != null) {
//			for (String symptom : symptomOptions) {
//				SymptomPostDto spDto= new SymptomPostDto();
//				spDto.setPostNo(postNo);
//				spDto.setsympNo(Integer.parseInt(symptom));
//				tmp = spDao.insertSymptomPost(spDto);
//				symptomRes+=tmp;
//			}
//		}
//		
//		int materialRes = 0;
//		if (materialOptions != null) {
//			for (String material : materialOptions) {
//				MaterialPostDto mpDto= new MaterialPostDto();
//				mpDto.setPostNo(postNo);
//				mpDto.setMaterialNo(Integer.parseInt(material));
//				tmp = mpDao.insertMateriaPost(mpDto);
//				materialRes+=tmp;
//			}
//		}
//		
//		
//		// 5. res: 모두 insert 되었는지 확인
//		int sLen = 0;
//		if (symptomOptions != null) { sLen = symptomOptions.length; }
//		
//		int mLen = 0;
//		if (materialOptions != null) { mLen = materialOptions.length; }
//		
//		if(postRes + symptomRes + materialRes == sLen + mLen + 1) {
//			//HttpSession session = request.getSession();
//			//ModalState modalState = new ModalState("show", "글이 등록되었습니다"); 
//			//session.setAttribute("modalState", modalState);
//			
//			request.setAttribute("no", postNo);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/product.jsp");
//			dispatcher.forward(request, response);
//		}
//		else {
//			System.err.println("글이 작성되지 않았습니다"); 
//			if(postRes == 0) System.err.println("글이잘못되었습니다");
//			if(symptomRes < sLen) System.err.println("증상이 잘못되었습니다");
//			if(materialRes < mLen) System.err.println("원재료가 잘못되었습니다");
//		}
		
		
	}
}
