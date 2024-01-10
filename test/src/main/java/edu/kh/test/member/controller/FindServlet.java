package edu.kh.test.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.test.member.model.service.MemberService;
import edu.kh.test.member.model.vo.Member;


@WebServlet("/test/find")
public class FindServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputName = req.getParameter("userName");
		String inputEmail = req.getParameter("userEmail");
		
		Member mem = new Member();
		mem.setMemberNickname(inputName);
		mem.setMemberEmail(inputEmail);
		
		try {
			MemberService service = new MemberService();
			
			Member findMember = service.findId(mem);
			
			
			HttpSession session = req.getSession();
			
			if(findMember != null) {
				
				session.setAttribute("message", "회원님의 아이디는 " + findMember.getMemberId() + "입니다.");
				
			}else {
				session.setAttribute("message", "회원 정보가 없습니다.");
			}
			
			resp.sendRedirect(req.getContextPath());
			
			
		} catch (Exception e) {
			
		}
		
	}
	
	
}
