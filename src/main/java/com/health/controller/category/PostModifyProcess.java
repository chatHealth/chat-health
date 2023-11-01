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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.TypeReference;

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
		

		// 0. nav
		HttpSession session = request.getSession();
		if(session.getAttribute("navSymptomList")==null) {
			session.setAttribute("navSymptomList", SymptomDao.getInstance().getAllSymptom());
		}
		
		// 1. 값 넘겨받기
		// String admin= request.getParameter("admin");
		String enpriseNo= request.getParameter("enpriseNo");
		int enNo = 0;    // if 0 이면, admin이다 
		if(enpriseNo!=null&& !enpriseNo.isEmpty()) {
			 enNo = Integer.parseInt(enpriseNo);
			 
		}
		Part titleImg = request.getPart("titleImg");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String symptomOptions[] = request.getParameterValues("symptomOptions");  //new 
		String materialOptions[] = request.getParameterValues("materialOptions");
		String selectedSymptomList = request.getParameter("selectedSymptomList");  //origin
		String selectedMaterialList = request.getParameter("selectedMaterialList");
		
		
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
		
		
		
		
		
		// 4. symptom, material insert,delete
		
		// 1) symptom ) array -> list
		List<Integer> newSymptom = new ArrayList<>();
		if (symptomOptions != null) {
			for (String element : symptomOptions) {
				newSymptom.add(Integer.parseInt(element));
			}
		}
		
		List<Integer> originSymptom = new ArrayList<>();
		String cleanInput = selectedSymptomList.replaceAll("[\\[\\] ]", "");
		if (!cleanInput.isBlank()) {
			String[] parts = cleanInput.split(",");
			for (String part : parts) {
				originSymptom.add(Integer.parseInt(part));
			}
		}

		// 2) symptom insert,delete
		if (!(originSymptom.size() == newSymptom.size() && originSymptom.containsAll(newSymptom))) { // 1- 같을땐 pass

			
			// 2- 새로운 요소를 찾아서 insert
			for (Integer item : newSymptom) {
				if (!originSymptom.contains(item)) {
					SymptomPostDto spDto= new SymptomPostDto();
					spDto.setPostNo(postNo);
					spDto.setsympNo(item);
					spDao.insertSymptomPost(spDto);
					
				}
			}

			// 3- 삭제된 요소를 찾아서 delete
			for (Integer item : originSymptom) {
				if (!newSymptom.contains(item)) {
					SymptomPostDto spDto= new SymptomPostDto();
					spDto.setPostNo(postNo);
					spDto.setsympNo(item);
					spDao.deleteSymptomPost(spDto);
				}
			}
		}
		
		// 3) material) array -> list
		List<Integer> newMaterial = new ArrayList<>();
		if(materialOptions != null) {
		for (String element : materialOptions) {
			newMaterial.add(Integer.parseInt(element));
			}
		}
		
		List<Integer> originMaterial = new ArrayList<>();
		String cleanInput2 = selectedMaterialList.replaceAll("[\\[\\] ]", "");
		if (!cleanInput2.isBlank()) {
			String[] parts2 = cleanInput2.split(",");
			for (String part : parts2) {
				originMaterial.add(Integer.parseInt(part));
			}
		}

		// 4) material insert,delete
		if (!(originMaterial.size() == newMaterial.size() && originMaterial.containsAll(newMaterial))) { // 1- 같을땐 pass

			
			// 2- 새로운 요소를 찾아서 insert
			for (Integer item : newMaterial) {
				if (!originMaterial.contains(item)) {
					MaterialPostDto mpDto= new MaterialPostDto();
					mpDto.setPostNo(postNo);
					mpDto.setMaterialNo(item);
					mpDao.insertMaterialPost(mpDto);
				}
			}

			// 3- 삭제된 요소를 찾아서 delete
			for (Integer item : originMaterial) {
				if (!newMaterial.contains(item)) {
					MaterialPostDto mpDto= new MaterialPostDto();
					mpDto.setPostNo(postNo);
					mpDto.setMaterialNo(item);
					mpDao.deleteMaterialPost(mpDto);
				}
			}
		}


		
		// 5. res: pos insert 되었는지 확인
		if(postRes > 0) {
			//HttpSession session = request.getSession();
			//ModalState modalState = new ModalState("show", "글이 등록되었습니다"); 
			//session.setAttribute("modalState", modalState);
			
			request.setAttribute("no", postNo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/product.jsp");
			dispatcher.forward(request, response);
		}
		else {
			System.err.println("글이 수정되지 않았습니다"); 
		}
		
		
	}
}
