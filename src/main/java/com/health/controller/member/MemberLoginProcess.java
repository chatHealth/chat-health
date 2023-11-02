package com.health.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.health.dao.MemberDao;
import com.health.dto.EnterpriseDto;
import com.health.dto.MemberDto;
import com.health.util.ScriptWriter;
import com.health.util.CookieManager;


@WebServlet("/member/login-process")
public class MemberLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberDao memberDao = MemberDao.getInstance();

	public MemberLoginProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession loginSession = request.getSession();
        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");
        String isEnterprise = request.getParameter("isEnterprise");
        String saveID = request.getParameter("saveID");

        if (isEnterprise.equals("enterprise")) { // 사업자
            EnterpriseDto enterpriseDto = new EnterpriseDto();
            EnterpriseDto loggedEnterprise = null;
            enterpriseDto.setId(userID);
            enterpriseDto.setPw(userPW);
            loggedEnterprise = memberDao.loginEnterprise(enterpriseDto);

            if (loggedEnterprise != null) { // 로그인 성공
                loginSession = request.getSession();
                loggedEnterprise.setPw(null);
                loginSession.setAttribute("loggedEnterprise", loggedEnterprise);

                if (saveID != null) { // 로그인 성공은 했는데 아이디 기억하기 체크했으면
                    CookieManager.createCookie(response, "saveIDCookie", userID, 60 * 60 * 24 * 5); // 쿠키 유효기간 5일
                } else { // 로그인 성공은 했는데 아이디 기억하기 체크 안했으면
                    CookieManager.deleteCookie(response, "saveIDCookie");
                }
                response.sendRedirect("../index/index");
            } else { // 로그인 실패
                ScriptWriter.alertAndBack(response, "아이디 혹은 비밀번호가 일치하지 않습니다.");
            }
            
        } else { // 사업자가 아닌 경우
            MemberDto memberDto = new MemberDto();
            MemberDto loggedMember = null;
            memberDto.setId(userID);
            memberDto.setPw(userPW);

            loggedMember = memberDao.loginMember(memberDto);

            if (loggedMember != null) { // 로그인 성공
                loginSession = request.getSession();
                loggedMember.setPw(null);

                if (loggedMember.getGrade() == 1) { // 로그인 성공 관리자
                    loginSession.setAttribute("loggedAdmin", loggedMember);
                    response.sendRedirect("../personal/member-manage"); // 관리자페이지로 이동
                } else if (loggedMember.getGrade() > 1){ // 로그인 성공 일반회원
                    loginSession.setAttribute("loggedMember", loggedMember);

                    if (saveID != null) { // 로그인 성공은 했는데 아이디 기억하기 체크했으면
                        CookieManager.createCookie(response, "saveIDCookie", userID, 60 * 60 * 24 * 5); // 쿠키 유효기간 5일
                    } else { // 로그인 성공은 했는데 아이디 기억하기 체크 안했으면
                        CookieManager.deleteCookie(response, "saveIDCookie");
                    }
                    response.sendRedirect("../index/index");
                }
            } else {
                ScriptWriter.alertAndBack(response, "아이디 혹은 비밀번호가 일치하지 않습니다.");
            }
        }

    }
}