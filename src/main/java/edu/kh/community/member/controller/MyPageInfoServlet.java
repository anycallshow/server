package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;


@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet{
	
	
	// 메인페이지 -> 별명 클릭시 요청 (GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	// 회원 정보 수정 요청(POST)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어 오기 + 배열 -> 문자열로 만들기
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		
		
		String[] address = req.getParameterValues("memberAddress");
		
		// 주소가 입력되지 않으면 null이 아니라 빈칸 3개
		String memberAddress = null;
		
		if(!address[0].equals("")) { // 우편번호가 빈칸이 아니라면 == 주소 작성
			memberAddress = String.join(",,", address);
			// String.join("구분자", 배열)
			// -> 배열 요소를 하나의 문자열로 반환
			// 요소 사이에 "구분자" 추가
		}
		
		// *** 세션에서 로그인한 회원 정보 얻어오기***
		HttpSession session = req.getSession();
		// 얕은 복사 (세션에 있는 회원 정보 객체 주소)
		// -> logionMember를 수정하면 세션에 저장된 내용이 수정된
		Member loginMember =(Member)session.getAttribute("loginMember");
		
		int memberNo = loginMember.getMemberNo(); // 회원 번호 얻어오기 성공 ! 
		
		// 업데이트에 필요한 정보를 모아둔 Member객체 생성
		Member mem = new Member();
		mem.setMemberNo(memberNo);
		mem.setMemberNickname(memberNickname);
		mem.setMemberTel(memberTel);
		mem.setMemberAddress(memberAddress);
		
		try {
			// 수정 성공/ 실패에 따른 메세지 출력 제어
			MemberService service = new MemberService();
			// 회원가입 서비스 호출 후 결과 반환 받기
			int result = service.myPage(mem);
			if(result>0) { // 성공
				session.setAttribute("message", "회원정보 수정성공");
				// DB는 수정 되었지만
				// 로그인한 회원 정본가 담겨있는 Session의 정보는 그대로다!
				// -> 동기화 작업 
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberAddress(memberAddress);
				loginMember.setMemberTel(memberTel);
			}else { // 실패
				session.setAttribute("message", "회원정보 수정실패");
				
			}
			// 성공 / 실패 여부 관계 없이 "내 정보" 화면 재요청
			
			// 절대 경로
			resp.sendRedirect( req.getContextPath()+"/member/myPage/info" );
			
			// 상대 경로 
//			resp.sendRedirect("info");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
