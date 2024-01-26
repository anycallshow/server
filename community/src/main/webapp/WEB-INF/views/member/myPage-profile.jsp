<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 문자열 관련 함수(메소드) 제공 JSTL (EL형식으로 작성) -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MY Page</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <script src="https://kit.fontawesome.com/0537c4177e.js" crossorigin="anonymous"></script>

</head>
<body>

    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
        <!-- 마이페이지 - 내정보 -->
        <section class="myPage-content">

            <%-- 사이드메뉴 include --%>
            <jsp:include page="/WEB-INF/views/member/sideMenu.jsp" />

            <!-- 오른쪽 마이페이지 주요 내용 부분 -->
               <!-- 오른쪽 마이페이지 주요 내용 부분 -->
            <section class="myPage-main">
                <h1 class="myPage-title">프로필</h1>
                <span class="myPage-explanation">프로필이미지를 수정할 수 있습니다.</span>

                <%-- 
                    enctype : form태그가 데이터를 서버로 제출할 때 
                            데이터의 인코딩 형식을 지정한느 속성
                    1) application/x-www-form-urlencoded
                        - 모두 문자를 서버로 제출하기 전에 인코딩 (모든 데이터가 문자)
                    2) multipart/form-data : 제출할 때 인코딩을 하지 않음
                        -> 모든 데이터가 원본 형태를 유지 (파일이 파일상태로 서버에 제출)
                        (주의) multipart/form-data로 설정 시 method는 무조건 POST
                 --%>
                <form action="profile" method="post" name="myPage-form"
                             enctype="multipart/form-data" onsubmit="return profileValidate()">
                    <div class="profile-image-area">
                    <c:if test="${!empty loginMember.profileImage}">
                        
                            <img src= "${contextPath}${loginMember.profileImage}"id="profile-image">
                        
                    </c:if>
                    <c:if test="${empty loginMember.profileImage}">
                            <img src="${contextPath}/resources/images/user.png" id="profile-image">
                    </c:if>
                    <span id="delete-image">x</span>
                    </div>
                    
                    <div class="profile-btn-area">
                        <!-- 프로필 이미지 삭제 버튼 --> 
                        <label for="input-image">이미지 선택</label>
                        <input type="file" name="profileImage" id="input-image" accept="image/*">
                        <%-- accept = "image/* : 이미지 파일 확장자만 선택 가능" --%>
                        <%-- accept = "video/* : 동영상 파일 확장자만 선택 가능" --%>
                        <%-- accept = ".pdf/* : pdf 파일 확장자만 선택 가능" --%>
                        <button type="submit">변경하기</button>
                    </div>

                    <div class="myPage-row">
                        <label>이메일</label>
                        <span>${loginMember.memberEmail}</span>
                    </div>
                    <div class="myPage-row">
                        <label>가입일</label>
                        <span>${loginMember.enrollDate}</span>
                    </div>

                  <!-- 삭제 버튼(x)이 눌러짐을 기록하는 숨겨진 input 태그  -->
                  <!-- 0 : 안 눌러짐 / 1: 눌러짐 -->
                    <input type="hidden" name="delete" id="delete" value="0">
                </form>
            </section>
            
        </section>
           
        
    </main>
     <jsp:include page="/WEB-INF/views/common/footer.jsp" />

     <script>
        const contextPath = "${contextPath}"; // 최상위 주소
     </script>

     <%-- myPage.js 추가 --%>
    <script src="${contextPath}/resources/js/member/myPage.js"></script>
</body>
</html>