<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디/비밀번호 찾기</title>
    <link rel="stylesheet" href="resources/css/find.css">
    <link rel="stylesheet" href="resources/css/header_footer.css">
</head>
<body>

    <header>

        <section>
            <a href="메인화면.html">
                <img src="resources/images/세미 로고.png" id="logoImg"> 
            </a>
        </section>

        <section class="headerTop">
            <section>
                <a href="#">
                    <div>공지사항</div>
                </a>
            </section>
            <section>
                <a href="login.html">
                    <div>로그인</div>
                </a>
                <a href="#">
                    <div>회원가입</div>
                </a>
            </section>
        </section>
        
        <nav>
            <ul>
                <a href="#">
                    <li>질병체크</li>
                </a>
                <a href="#">
                    <li>병원,약국 검색</li>
                </a>
                <a href="#">
                    <li>후기게시판</li>
                </a>
                <a href="board.html">
                    <li>자랑게시판</li>
                </a>
            </ul>
        </nav>
    </header>

    <div class="content">

        <div class="idFrom">
            <h1>아이디 찾기</h1>
            <form action="test/find" method="post" id="find-form">
                <input type="text" name="userName" id="idName" placeholder=" 이름"> <br>
                <input type="email" name="userEmail" id="idEmail" placeholder=" 이메일"><br><br>
                <button>아이디 찾기</button>
            </form>
        </div>

        <div class="pwForm">
            <h1>비밀번호 찾기</h1>
            <form action="#">
                <input type="text" name="userId" id="pwId" placeholder=" 아이디"> <br>
                <input type="text" name="userName" id="pwName" placeholder=" 이름"> <br>
                <input type="email" name="userEmail" id="pwEmail" placeholder=" 이메일"><br><br>
                <button>비밀번호 찾기</button>
            </form>
            
        </div>

    </div>
	
    <footer></footer>

    <c:if test="${!empty sessionScope.message}">
        <script>
            alert("${message}");
        </script>

        <c:remove var="message" scope="session"/>
    </c:if>
    
</body>
</html>