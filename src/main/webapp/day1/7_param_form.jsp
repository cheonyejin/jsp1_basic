<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>테이블 행 조회에 필요한 조건값(name,age)을 input에 입력하고 전송하기</h3>
	<hr>
	<form action="6_selectBy.jsp">
	<!--input의 required는 form에서만 동작을한다   -->
	<input type="text" name="name" placeholder="이름을 입력하세요" required="required">
	<input type="number" name="age" placeholder="나이를 입력하세요" required="required">
	<button>조회</button>
	<!-- 기본 type= submit,ㅋ ㅡㄹ릭하면 action에 지정된 url로 전송굅니다 
	실행하면 url을 확인해보세요 4번파일 url과 같습니다 
	form method="get"(기본값)이면 파라미터가 url에 포함됩니다-조회-->
	
	
	</form>

</body>
</html>