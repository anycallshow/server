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


// 회원 프로필 이미지 변경
const inputImage = document.getElementById("input-image");

if(inputImage != null){ // inputImage 요소가 화면에 존재 할 때
    // input type = "file" 요소는 파일이 선택 될 때 change 이벤트가 발생한다.
    inputImage.addEventListener("change",function(){
        // this : 이벤트가 발생한 요소 (input type = "file")

        // files : input type="file"만 사용 가능한 속성으로 
        //          선택된 파일 목록(배열) 반환

        //console.log(this.file[0]); // 파일목록에서 첫 번째 파일 객체를 선택
        if(this.files[0] != undefined){ // 파일 선택되었을 때

            const reader = new FileReader();
            // 자바 스크립트의 fileReader
            // - 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체

            reader.readAsDataURL(this.files[0]) 
            // FileReader.readAsDataURL(파일)
            // - 지정된 파일의 내용을 읽기 시작함
            // - 읽어오는게 완료되면 result 속성 data에 
            // 읽어온 파일의 위치를 나타내는 URL이 포함된다.
            // -> 해당 URL을 이용해서 브라우저에 이미지를 볼 수 있다.
            

            // FileReader.onload =funtion(){}
            // - FileReader가 파일을 다 읽어온 경우 함수를 수행
            reader.onload =function(e){ // 고전 이벤트 모델
                // e: 이벤트가 발생 객체 
                // e.target : 이벤트가 발생한 요소(객체) -> FileReader
                // e.target.result : FIleReader가 읽어온 파일의 URL 

                // 프로필 이미지의 src 속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profile-image");
                profileImage.setAttribute("src",e.target.result);
                // -> setAttribute() 호출 시 중복되는 속성이 존재하면 덮어쓰기

                document.getElementById("delete").value = 0;
                // 새로운 이미지가 선택 되었기 때문에 1 -> 0(안눌러진 상태)으로 변경


            }
        }
    })

}

function profileValidate(){
    const inputImage =document.getElementById("input-image")

    const del = document.getElementById("delete"); // hidden 타입
    if(inputImage.value =='' && del.value == 0){
        // 빈문자열 == 파일 선택 X 
        // 아무것도 안하고 변경 버튼을 클릭한 경우
        alert("이미지를 선택한 후 변경 버튼을 눌러주세요.")
        return false;
    }
    return true;
    
}

// 프로필 이미지 옆 x버튼 클릭 시 
document.getElementById("delete-image").addEventListener("click", function(){
    // 0 : 안눌러짐
    // 1 : 눌러짐

    const del = document.getElementById("delete");

    if(del.value == 0){ // 눌러지지 않은 경우

        // 1) 프로필 이미지를 기본 이미지로 변경
        const profileImage = document.getElementById("profile-image");
        profileImage.setAttribute("src", contextPath+"/resources/images/user.png");
    
        // 2) input type="file"에 저장된 값(value)에
        const inputImage = document.getElementById("input-image");
        inputImage.value = "";

        del.value = 1; // 눌러진걸로 인식
    }
})