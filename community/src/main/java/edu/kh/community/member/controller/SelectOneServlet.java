package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/selectOne")
public class SelectOneServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 얻어오기
		String memberEmail = req.getParameter("memberEmail");
		
		
		try {
			MemberService service = new MemberService();
			
			// 회원 정보 조회 Service 호출 후 결과(Member 객체) 반환 받기
			Member selectMember = service.selectOne(memberEmail);
			
			// 조회 결과를 응답용 스트림으로 출력
			resp.getWriter().print(selectMember);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
