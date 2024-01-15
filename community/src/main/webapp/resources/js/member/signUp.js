// signUp.js

// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    "memberEmail"       : false,
    "memberPw"          : false,
    "memberPwConfirm"   : false,
    "memberNickname"    : false,
    "memberTel"         : false
};

// 전화번호 유효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

// ** input 이벤트 **
// -> 입력과 관련된 모든 동작(key관련, mouse관련, 붙여넣기)
memberTel.addEventListener("input", function(){
    
    // 입력이 되지 않은 경우
    if(this.value.length == 0){
        telMessage.innerHTML = "전화번호를 입력해주세요.(- 제외)";
        // telMessage.classList.remove('error');
        // telMessage.classList.remove('confirm');
        telMessage.classList.remove('confirm','error');

        checkObj.memberTel = false; // 유효하지 않은 상태임을 기록

        return;
    }

    // 전화번호 정규식
    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if(regExp.test(this.value)){ // 유효한 경우
        telMessage.innerHTML = "유효한 전화번호 형식입니다.";
        telMessage.classList.remove('error');
        telMessage.classList.add("confirm");

        checkObj.memberTel = true; // 유효한 상태임을 기록

    } else { // 유효하지 않은경우
        telMessage.innerHTML = "전화번호 형식이 올바르지 않습니다.";
        telMessage.classList.remove('confirm');
        telMessage.classList.add("error");

        checkObj.memberTel = false; // 유효하지 않은 상태임을 기록
    }

})

// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");

memberEmail.addEventListener("input", function(){

    // 입력이 되지 않은 경우
    if(this.value.trim().length == 0){
        emailMessage.innerHTML = "메일을 받을 수 있는 이메일을 입력해주세요.";
        emailMessage.classList.remove('confirm','error');
        checkObj.memberEmail = false; // 유효하지 않은 상태임을 기록

        return;
    }

    // 입력된 경우
    const regExp = /^[\w_-]{4,}@[\w_-]+(\.\w+){1,3}$/;
    // user01@naver.com
    // user-02@kh.or.kr
    // test_03@iei.or.kr

    if(regExp.test(this.value)){ // 유효한 경우
        emailMessage.innerHTML = "유효한 이메일 형식입니다.";
        emailMessage.classList.remove('error');
        emailMessage.classList.add("confirm");

        checkObj.memberEmail = true; // 유효한 상태임을 기록

        // *************** 이메일 중복 검사(ajax) 진행 예정 ***************

    } else { // 유효하지 않은경우
        emailMessage.innerHTML = "이메일 형식이 올바르지 않습니다.";
        emailMessage.classList.remove('confirm');
        emailMessage.classList.add("error");

        checkObj.memberEmail = false; // 유효하지 않은 상태임을 기록
    }
})

// 닉네임 유효성 검사
const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input", function(){

    // 입력되지 않은 경우
    if(this.value.trim().length == 0){
        nicknameMessage.innerHTML = "닉네임을 입력해주세요.";
        nicknameMessage.classList.remove("confirm","error");
        checkObj.memberNickname = false; // 유효하지 않은 상태임을 기록

        return;
    }
    const regExp = /^[a-zA-Z0-9가-힣]{2,10}$/;

    if(regExp.test(this.value)){ // 유효한 경우
        nicknameMessage.innerHTML = "유효한 닉네임입니다.";
        nicknameMessage.classList.remove('error');
        nicknameMessage.classList.add("confirm");

        checkObj.memberNickname = true; // 유효한 상태임을 기록

        // *************** 닉네임 중복 검사(ajax) 진행 예정 ***************

    } else { // 유효하지 않은경우
        nicknameMessage.innerHTML = "닉네임 유효하지 않습니다.";
        nicknameMessage.classList.remove('confirm');
        nicknameMessage.classList.add("error");

        checkObj.memberNickname = false; // 유효하지 않은 상태임을 기록
    }

})

// 비밀번호 유효성 검사
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessage");

memberPw.addEventListener("input", function(){

    // 입력되지 않은경우
    if(memberPw.value.trim().length == 0){
        pwMessage.innerHTML = "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.";
        pwMessage.classList.remove("confirm","error");

        checkObj.memberPw = false; // 유효하지 않은 상태임을 기록
    
        return;
    }

    // 입력된 경우
    const regExp = /^[\w!@#_-]{6,30}$/;

    if(regExp.test(this.value)){ // 비밀번호 유효한 경우
        
        if(memberPwConfirm.value.trim().length == 0){ // 비밀번호 유효, 확인 작성 X
            pwMessage.innerHTML = "유효한 비밀번호 형식입니다.";
            pwMessage.classList.remove('error');
            pwMessage.classList.add("confirm");

            checkObj.memberPw = true; // 유효한 상태임을 기록

        }else{ // 비밀번호 유효, 확인 작성 O

            checkPw(); // 비밀번호 일치 검사 함수 호출()
            
        }

    } else {  // 유효하지 않은 경우
        pwMessage.innerHTML = "비밀번호 형식이 유효하지 않습니다.";
        pwMessage.classList.remove('confirm');
        pwMessage.classList.add("error");

        checkObj.memberPw = false; // 유효하지 않은 상태임을 기록
    }
})

// 비밀번호 확인 유효성 검사

// 함수명() : 함수 호출(수행)
// 함수명   : 함수에 작성된 코드 반환
memberPwConfirm.addEventListener("input", checkPw);
// -> 이벤트가 발생 되었을 때 정의된 함수를 호출하겠다.

function checkPw(){ // 비밀번호 일치 검사

    // 비밀번호/ 비밀번호 확인이 같을 경우
    if(memberPwConfirm.value == memberPw.value){
        pwMessage.innerHTML = "비밀번호가 일치합니다.";
        pwMessage.classList.remove('error');
        pwMessage.classList.add("confirm");
        checkObj.memberPwConfirm = true; // 유효한 상태임을 기록

    } else { 
        pwMessage.innerHTML = "비밀번호가 일치하지 않습니다.";
        pwMessage.classList.remove('confirm');
        pwMessage.classList.add("error");
        checkObj.memberPwConfirm = false; // 유효하지 않은 상태임을 기록
    }
}

// 회원 가입 버튼 클릭 시 유효성 검사가 완료 되었는지 확인하는 함수
function signUpValidate(){

    // checkObj에 있는 모든 속성을 반복 접근하여
    // false가 하나라도 있는 경우에는 form태그 기본 이벤트 제거
    
    let str;

    // 객체용 향상된 for문
    for (let key in checkObj) {

        // 현재 접근 중인 key의 value가 false인 경우
        if(!checkObj[key]){

            switch(key){
                case "memberEmail"    : str="이메일이"; break;
                case "memberNickname" : str="닉네임이"; break;
                case "memberPw"       : str="비밀번호가"; break;
                case "memberPwConfirm": str="비밀번호 확인이"; break;
                case "memberTel"      : str="전화번호가"; break;
            }

            str += " 유효하지 않습니다.";

            alert(str);

            document.getElementById(key).focus();

            return false; // form 태그 기본 이벤트 제거
        }
    }

    return true; // form 태그 기본 이벤트 수행

}



