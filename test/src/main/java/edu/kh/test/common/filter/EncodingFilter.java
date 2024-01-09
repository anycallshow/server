package edu.kh.test.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
public class EncodingFilter extends HttpFilter implements Filter {

	// 서버 실행 시 또는 필터 코드 변경 시 필터 객체가 자동 생성되는데
	// 그 때, 필터에 필요한 내용을 초기화 하는 메소드
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("문자 인코딩 필터 초기화");
	}
	
	// 서버 실행 중 필터 코드가 변경되어
	// 기존 필터를 없애야 할 때 수행되는 메소드
	public void destroy() {
		System.out.println("문자 인코딩 필터 파괴");
	}
	
	// 필터 역할을 수행하는 메소드 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// ServletRequest == HttpServletRequest의 부모 타입
		// ServletResponse == HttpServletResponse의 부모 타입
		// -> 필요 시 다운캐스팅
		
		// 모든 요청의 문자 인코딩을 UTF-8로 설정
		request.setCharacterEncoding("UTF-8");
		
		// 모든 응답의 문자 인코딩을 UTF-8로 설정
		response.setCharacterEncoding("UTF-8");

		// 연결된 다음 필터 수행(없으면 Servlet 수행)
		chain.doFilter(request, response);
	}

}