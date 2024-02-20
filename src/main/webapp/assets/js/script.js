document.getElementById('join').addEventListener('click', function(event) {
    event.preventDefault(); // 기본 동작 방지
    enter(); // 회원가입 유효성 검사 함수 호출
});