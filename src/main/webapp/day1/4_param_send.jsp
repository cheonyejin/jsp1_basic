<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4 파라미터 보낸다 </title>
</head>
<body>
	<h3>a태그의 url주소에 파라미터 값을 포함해서 전송하기</h3>
	<p>이것은 메뉴또는 조회 동작을할때 사용되는 방식입니다 <br>
	실행하고 url 주소창도 잘 확인해보세요</p>
	<hr>
	<ul>
	<!-- 4번에서 실행하면 5번으로 넘어가서 실행된다   -->
		<li><a href="5_param_recieve.jsp?name=sana&age=25">name,age 2개의 파라미터 보내기</a></li>
		<!-- 2개모두 출력됨-->
		
		<li><a href="5_param_recieve.jsp?name=sana">name,age 2개의 파라미터 보내기</a></li>
		<!-- age가 null -->
		
		<li><a href="5_param_recieve.jsp?name=sana&age=">name,age 2개의 파라미터 보내기</a></li>
		<!-- age는 length가 0인 문자열 , 값이 없는것 -->
		
	</ul>
	<hr>
	<ul>
	<!-- 4번에서 실행하면 6번으로 넘어가서 실행된다   -->
		<li><a href="6_selectBy.jsp?name=sana&age=25">name,age 2개의 파라미터 보내기</a></li>
		<!-- 2개모두 출력됨-->
		
		<li><a href="6_selectBy.jsp?name=sana">name,age 2개의 파라미터 보내기</a></li>
		<!-- age가 null -->
		
		<li><a href="6_selectBy.jsp?name=sana&age=">name,age 2개의 파라미터 보내기</a></li>
		<!-- age는 length가 0인 문자열 , 값이 없는것 -->
		
		
	
	</ul>





</body>
</html>