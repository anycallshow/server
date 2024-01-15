<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 왼쪽 사이드 메뉴 -->
<section class="left-side">
    사이드메뉴

    <ul class="list-group">
        <li> <a href="#">프로필</a></li>

        <li> <a href="${contextPath}/member/myPage/info">내 정보</a></li>

        <li> <a href="${contextPath}/member/myPage/changePw">비밀번호 변경</a></li>

        <li> <a href="${contextPath}/member/myPage/secession">회원 탈퇴</a></li>
    </ul>
</section>