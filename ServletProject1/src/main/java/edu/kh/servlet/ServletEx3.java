package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("userId");
		String userPw1 = req.getParameter("userPw1");
		String userPw2 = req.getParameter("userPw2");
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");
		
		String[] color = req.getParameterValues("color");
		
		// Dynamic Web Project(동적 웹 프로젝트)
		// - 요청에 따라 응답 화면(HTML)을 실시간으로 만드는 것(동적)

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		
		out.print("<html>");
		
		out.print("<head>");
		out.print("<title>회원 정보 조회</title>");
		out.print("</head>");
		
		out.print("<body>");
		if(!userPw1.equals(userPw2)) {
			out.print("<h1>비밀번호가 일치하지 않습니다.</h1>");

		}else {
			out.print("<ul>");
			
			out.print("<li>아이디 : " + userId);
			out.print("</li>");
			out.print("<li>이름 : " + userName);
			out.print("</li>");
			out.print("<li>이메일 : " + userEmail);
			out.print("</li>");
			out.print("<li>좋아하는색 : ");
			if(color != null ) {
				for (String c : color) {
					out.print(c + " ");
				}
				out.print("</li>");
				
			} else {
				out.print("없습니다");
				out.print("</li>");
			}
			
			out.print("</ul>");
		}
		out.print("</body>");
		out.print("</html>");

	}

}