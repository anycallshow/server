// 내 정보 수정 유효성 검사
function infoValidate(){
    const memberNickname = document.getElementsByName("memberNickname")[0];
    const memberTel = document.getElementsByName("memberTel")[0];

    const regExp1 = /^[a-zA-Z0-9가-힣]{2,10}$/; // 닉네임 정규식
    const regExp2 = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/; // 전화번호 정규식

    // 닉네임 유효성 검사
    if(memberNickname.value.trim() == ""){ // 미작성 시
        alert("닉네임을 입력해주세요.");
        memberNickname.focus();
        return false;
    }

    if(!regExp1.test(memberNickname.value)){
        alert("닉네임은 영어/숫자/한글 2~10글자 사이로 작성해주세요.")
        memberNickname.focus();
        return false;
    }

    // 전화번호 유효성 검사
    if(memberTel.value.trim() == ""){
        // alert("전화번호를 입력해주세요.(- 제외)");
        // memberTel.focus();
        // return false;

        return printAlert(memberTel, "전화번호를 입력해주세요.(- 제외)");
    }

    if(!regExp2.test(memberTel.value)){
        // alert("전화번호 형식이 올바르지 않습니다.")
        // memberTel.focus();
        // return false;

        return printAlert(memberTel, "전화번호 형식이 올바르지 않습니다.");

    }

    return true;
}

// 경고 출력 + 포커스 + false 반환 함수
function printAlert(el, message){ // 매개변수 el은 요소
    alert(message);
    el.focus();
    return false;
}

// 비밀번호 변경 유효성 검사
function changePwValidate(){
    const currentPw = document.getElementsByName("currentPw")[0];
    const newPw = document.getElementsByName("newPw")[0];
    const newPwConfirm = document.getElementsByName("newPwConfirm")[0];

    const regExp = /^[a-zA-Z0-9!@#\-_]{6,30}$/;

    if(currentPw.value.trim() == ""){
        return printAlert(currentPw, "현재 비밀번호를 입력해주세요.");
    }

    if(newPw.value.trim() == ""){
        return printAlert(newPw, "새 비밀번호를 입력해주세요.");
    }

    if(!regExp.test(newPw.value)){
        return printAlert(newPw, "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.");
    }

    if(newPwConfirm.value.trim() == ""){
        return printAlert(newPwConfirm, "새 비밀번호 확인을 입력해주세요.");
    }

    if(newPw.value != newPwConfirm.value){
        return printAlert(newPwConfirm, "새 비밀번호 확인가 일치하지 않습니다.");
    }

    return true;


}
