package edu.kh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet 클래스를 만들 때는
// 반드시 HttpServlet을 상속 받아야 한다!!
public class ServletEx2 extends HttpServlet{

	// GET 방식 요청을 처리하는(do) 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터(Parameter) == 요청 시 전달된 input 태그의 값
		String orderer = req.getParameter("orderer");
		// -> getParameter()는 전달된 input태그의 name이 하나일 때 만 가능
		
		String[] coffee = req.getParameterValues("coffee");
		// 체크박스에 체크된 메뉴들이 모두 배열에 담김
		// --> 체크가 안되면 배열에 하나도 담기지 않음
		
		if(coffee != null) { // 체크된 메뉴가 있는지 검사
			
			System.out.println("주문자 : " + orderer);
			
			// 향상된 for문
			for (String c : coffee) {
				System.out.println(c);
			}
			
		}
	}
	
}