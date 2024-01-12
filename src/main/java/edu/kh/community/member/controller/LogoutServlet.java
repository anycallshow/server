package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet { 
	// a태그를 이용한 요청은 무조건 get 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// *** 로그아웃 *** 
		// Session Scope 에 세팅된 회원 정보를 없앰
		
		// Session 얻어오기
		HttpSession session = req.getSession();
		
		
		// 1) Session에서 회원 정보를 없앰
//		session.removeAttribute("loginMember");
		
		
		// 2) Sesson 전체를 없애고 새로운 Session 만들기
		session.invalidate(); // 세션을 무효화 
							  // 현재 세션을 없앰 -> 자동으로 새로운 새션이 생성됨
		
		// 메인페이지로 돌아가기 
		// 1) forward : 로그아웃 응답화면을 만든다.(부적절) 
		// 2) redirect : 메인페이지 재요청(이거!) 
					// 메인페이지 == 최상위 주소 (/community)로 요청했을 때 화면
		// 최상위 주소 얻어옴 req.getContextPath()
		resp.sendRedirect(req.getContextPath());
		
	}
}
