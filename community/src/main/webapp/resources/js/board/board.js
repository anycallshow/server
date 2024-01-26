// 상세조회, 게시글 작성 - 목록으로 버튼
(function(){
    const goToListBtn = document.getElementById("goToListBtn");

    if(goToListBtn != null){ // 목록으로 버튼이 화면에 있을 때만 이벤트 추가

        goToListBtn.addEventListener("click",function(){
            // location 객체(BOM)

            // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

            // 문자열.indexOf("검색 문자열", 시작 인덱스)
            // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            //   단, 시작 인덱스 이후 부터 검색

            const pathname = location.pathname; // 주소상에서 요청 경로 반환
            //    /community/board/detail

            // 이동할 주소 저장
            let url = pathname.substring( 0, pathname.indexOf("/", 1) );
            // /community

            url += "/board/list?" // /community/board/list?

            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이즈 주소 + 쿼리스트링
            // URL.searchParams : 쿼리 스트링만 별도 객체로 반환

            // http://localhost:8080/community/board/detail?no=500&cp=1&type=1
            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type"); // tpye=1

            let cp;

            if(params.get("cp") != null){ // 쿼리스트링에 cp가 있을 경우
                
                cp = "cp=" + params.get("cp");

            } else{
                cp = "cp=1";
            }


            // 조립
            url+=type + "&" + cp;


            // location.href = "주소"; -> 해당 주소로 이동
            location.href = url;
        })
    }

})();