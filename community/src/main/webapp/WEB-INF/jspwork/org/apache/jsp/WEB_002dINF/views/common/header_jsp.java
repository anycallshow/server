/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.84
 * Generated at: 2024-01-19 15:44:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("\r\n");
      out.write("	<!-- 클릭 시 메인페이지로 이동하는 로고 -->\r\n");
      out.write("	<section>\r\n");
      out.write("	\r\n");
      out.write("	<!-- header를 별도의 jsp로 분리한 경우\r\n");
      out.write("		상대경로로 작성된 이미지의 경로가 일치하지 않게됨\r\n");
      out.write("		\r\n");
      out.write("		* 지금처럼 분리시켜둔 jsp에서 경로를 지정하는 경우\r\n");
      out.write("		상대경로로 작성 시 문제가 발생할 가능성이 높음!!\r\n");
      out.write("		-> 절대 경로 사용이 바람직함\r\n");
      out.write("	 -->\r\n");
      out.write("	 \r\n");
      out.write("	\r\n");
      out.write("	  <!--\r\n");
      out.write("	 	 /community \r\n");
      out.write("	  \r\n");
      out.write("	  	 <= request.getContextpath() %>\r\n");
      out.write("	     ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.servletContext.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("	     \r\n");
      out.write("	     위에 작성된 내용은 모두 같은 결과이나 문제가 조금씩 있음..\r\n");
      out.write("	     -> 모든 주소 요청 시 동작하는 EncodingFilter에서 \r\n");
      out.write("	     application scope 에 최상위 주소를 간단히 부를 수 있는 형태로 저장\r\n");
      out.write("    	-->\r\n");
      out.write("		<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/logo.jpg\"\r\n");
      out.write("			id=\"home-logo\">\r\n");
      out.write("		</a>\r\n");
      out.write("	</section>\r\n");
      out.write("\r\n");
      out.write("	<!-- header의 두번째 자식 div -->\r\n");
      out.write("	<section>\r\n");
      out.write("		<article class=\"search-area\">\r\n");
      out.write("\r\n");
      out.write("			<!-- form 내부 input 태그 값을 서버 또는 페이지로 전달 -->\r\n");
      out.write("			<form action=\"#\" name=\"search-form\">\r\n");
      out.write("				<!-- fieldset : form 내부에서 input을 종류별로 묶는 용도로 많이 사용 -->\r\n");
      out.write("				<fieldset>\r\n");
      out.write("					<input type=\"search\" id=\"query\" name=\"query\"\r\n");
      out.write("						placeholder=\"검색어를 입력해주세요.\" autocomplete=\"off\">\r\n");
      out.write("\r\n");
      out.write("					<!-- 검색 버튼 -->\r\n");
      out.write("					<button type=\"submit\" id=\"search-btn\"\r\n");
      out.write("						class=\"fa-solid fa-magnifying-glass\"></button>\r\n");
      out.write("				</fieldset>\r\n");
      out.write("\r\n");
      out.write("			</form>\r\n");
      out.write("\r\n");
      out.write("		</article>\r\n");
      out.write("	</section>\r\n");
      out.write("\r\n");
      out.write("	<section></section>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("	<ul>\r\n");
      out.write("		<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/list?type=1\">공지사항</a></li>\r\n");
      out.write("		<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/list?type=2\">자유 게시판</a></li>\r\n");
      out.write("		<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/list?type=3\">질문 게시판</a></li>\r\n");
      out.write("		<li><a href=\"#\">FAQ</a></li>\r\n");
      out.write("		<li><a href=\"#\">1:1문의</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("</nav>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
