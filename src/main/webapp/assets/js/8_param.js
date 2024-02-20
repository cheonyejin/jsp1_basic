document.getElementById('search').addEventListener('click', function() {
    //input에 입력한 값 가져오기
    const name = document.getElementById('name').value
    const age = document.querySelector('#age').value
    
    console.log('입력값 : ',name,age)
    
    //url 6번 파일로 파라미터 포함하여 웹브라우저 수조 변경하기 :
    // locationㅅ객체의 href속성값은 url주소 
    //location.href="6_selectBy.jsp?name=sana&age=25"
    location.href=`6_selectBy.jsp?name=${name}&age=${age}`
})
//js파일은 8_param_javascripty.js에 포함되므로 8번 jsp파일과 같은 폴더입니다.
;