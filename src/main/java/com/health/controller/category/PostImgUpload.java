package com.health.controller.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class PostImgUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostImgUpload() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. < 이미지 처리 >
		// 파일 업로드 경로 바깥에
		String uploadDir = "C:\\upload";
		String realUploadPath = uploadDir;

		// 파일이름찾기
		Part part = request.getPart("upload");
		String partHeader = part.getHeader("Content-disposition"); ;																	
		String partHeaderArray[] = partHeader.split("filename=");
		String originFileName = partHeaderArray[1].trim().replace("\"", ""); 

		String newFileName = "";
		if (!originFileName.isEmpty()) {
			// 실질적인(물리적인)경로에 파일생기도록
			part.write(realUploadPath + File.separator + originFileName);

			// 파일명바꾸기 -날짜붙이기
			Date now = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
			String strNow = simpleDateFormat.format(now); 
			String firstFile = originFileName.substring(0, originFileName.lastIndexOf("."));
			String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 확장자뽑기 ->.png
			newFileName = firstFile + strNow + ext;

			File oldFile = new File(realUploadPath + File.separator + originFileName);
			File newFile = new File(realUploadPath + File.separator + newFileName);
			oldFile.renameTo(newFile);

		} 
		
		
		// 2. 결과 보내기
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		map.put("url", request.getContextPath()+"/upload/"+newFileName);
		map.put("uploaded", true);
		String resultJson =gson.toJson(map);
		
		request.setAttribute("resultJson", resultJson);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/post/img-upload.jsp");
		dispatcher.forward(request, response);
		
	}

}
