package com.health.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.health.util.ScriptWriter;

@WebServlet("/member/no-accept")
public class NoAcceptAlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	  
    public NoAcceptAlert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScriptWriter sw = new ScriptWriter();
		sw.alertAndBack(response, "승인되지 않은 사업자는 글을 쓸 수 없습니다");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
