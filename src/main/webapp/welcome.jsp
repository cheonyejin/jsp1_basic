<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- language = "java" : java 언어로 컴파일 된다.
       contentType = "text/html; charest = UTF - 8 : 응답으로 만들어질 형식은 html
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 - Welcome</title>
</head>
<body>
   <h1>WELCOME</h1>
    <h3>회원 가입이 완료되었습니다.</h3>
<!-- 자바 프로그래밍을 하는 스크립트 작성 부분입니다(스크립트릿) -->
<%
   /* form 태그안의 입력양식이 서버로 제출될 때, 그 값을 받아 저장하는 코드입니다.
      getParameter 메소드이므로 앞으로는 입력 요소를 파라미터라고 부르겠습니다.*/   
   
      // 아이디. input 요소의 name 속성 값을 인자로 합니다.
   String id = request.getParameter("");      
   String password = request.getParameter("password"); // 패스워드 
   
   out.print("<h3>아이디</h3>");
   out.print(id);
   
   out.print("<h3>비밀번호</h3>");
   out.print(password);
%>
    <hr>
    <p>form 제출 확인 페이지 입니다.</p>
   
</body>
</html>
<!--jsp는 서버측에서 컴파일 되고 실행이 됩니다
컴파일 전에는 .java파일로 변경되고 
.java를 컴파일해서 .Class를 생성합니다 
웹페이지를 요청한 클라이언트에게는 .class 파일로 html 문서를 작성하여 응답합니다
이클립스는 jsp 에 대한 소스파일은 여기있다 (존나 김) 
ㄴ   D:\Class231228jyj\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\jsp1\org\apache\jsp
실제 환경에서는 tomcat 폴더 안에서 바로 찾을수있다. 이클립스에서만 경로가 이렇게 긴거임

이클립스는 webapp 폴더에 저장된 파일들은 jsp제외하고 여기에 있습니다
ㄴ   D:\Class231228jyj\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
 실제 실행환경에서는 tomcat폴더안에서 바로 찾을수있습니다 --> 

