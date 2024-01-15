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

// 비밀번호 변경 제출 시 유효성 검사
function changePwValidate(){

    // 비밀번호 변경 관련 input 요소 얻어오기
    const currentPw = document.getElementsByName("currentPw")[0];
    const newPw = document.getElementsByName("newPw")[0];
    const newPwConfirm = document.getElementsByName("newPwConfirm")[0];

    // 비밀번호 정규표현식
    const regExp = /^[a-zA-Z0-9!@#-_]{6,30}$/;

    // 현재 비밀번호 미작성    
    if(currentPw.value.trim().length == 0){
        return printAlert(currentPw, "현재 비밀번호를 입력해주세요.");
    }

    // 새 비밀번호 미작성
    if(newPw.value.trim() == ""){
        return printAlert(newPw, "새 비밀번호를 입력해주세요.");
    }

    // 유효하지 않은 경우
    if(!regExp.test(newPw.value)){
        return printAlert(newPw, "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.");
    }

    // 새 비밀번호 확인 미작성
    if(newPwConfirm.value.trim() == ""){
        return printAlert(newPwConfirm, "새 비밀번호 확인을 입력해주세요.");
    }

    // 새 비밀번호 != 새 비밀번호 확인
    if(newPw.value != newPwConfirm.value){
        return printAlert(newPwConfirm, "새 비밀번호가 일치하지 않습니다.");
    }

    return true; // 위 조건을 모두 수행하지 않은 경우 true 반환
}

function secessionValidate(){
    const memberPw = document.getElementsByName("memberPw")[0];
    const agree = document.getElementsByName("agree")[0];

    // 비밀번호 미작성
    if(memberPw.value.trim().length == 0){
        return printAlert(memberPw, "비밀번호를 입력해주세요.");
    }

    // 약관 동의 체크 여부
    // - 체크박스요소.checked : 체크 시 true, 해제 시 false 반환
    if(!agree.checked){ // 체크를 안했을 때
        return printAlert(agree, "약관 동의 후 탈퇴 버튼을 클릭해주세요.");
    }

    // 정말 탈퇴할지 확인
    return confirm("정말 탈퇴 하시겠습니까?");
}