<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5 파라미터 받았다 </title>
</head>
<body>
	<h3>4번 url주소에서 보낸 파라미터를 받아 값을 저장합니다.-조회</h3>
<%
	String name = request.getParameter("name");
	String temp = request.getParameter("age");
	
	//아래의  if문은 모든 파라미터 값이 전송되었을때만 실행하는 조건식입니다 
	//	실제로는 입력 파라미터는 자바스크립트에서 검사합니다
	if((name != null && name.length() ==0)&&(temp!= null && temp.length()!=0)){
		//todo : name과 age값으로 테이블에서 조회하고 결과 출력하기 
		//age는 정수타입으로 변경되어야합니다
		int age = Integer.parseInt(temp);
		
		out.print("<h4>name</h4>");
		out.print(name);
		
		out.print("<h4>age</h4>");
		out.print(temp);
		
	}else{
		out.print("파라미터 값을 모두 입력하세요.");
	}
	
	
%>

</body>
</html>