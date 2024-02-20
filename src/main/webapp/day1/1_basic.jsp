<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 자동완선 단축키는 컨트롤 스페이스바 -->
<p>jsp에서는 html과 자바 명령어 함께 작성 및 선언 출력 가능하다</p>
<%
	String[] names = {"사나","나연","모모","쯔위","다현"};
	List<String> list = List.of("사나","나연","모모","쯔위","다현");
	CustomerVo vo = new CustomerVo("sana","김사나","sana@gmail.com",23,null);
	
	
	%>
	<h4>배열 names</h4>
	<ul>	
	<!-- 여기에 names 배여 ㄹ요소값을 자바코드 사용하여 반복문(for)출력 -->
	
<% 
	for(int i=0;i<names.length;i++){ //for시작
		
%>
		<li><%= names[i] %></li>
<%
	} //for 끝
%>
	</ul>
	<ul>
	<hr>
	<h3>컬렉션</h3>
	</ul>
	
<% 
	for(int i=0;i<list.size();i++){ //for시작
		
%>
		<li><%= list.get(i) %></li>
<%
	} //for 끝
%>
	</ul>
	<ul>
	<hr>
	<h4>컬렉션</h4>
	<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입날짜</th>
	</tr>
	<tr>
		<td><%= vo.getCustomId() %>></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getEmail() %>></td>
		<td><%= vo.getAge()  %></td>
		<td><%= vo.getReg_data() %>></td>
	</tr>
	</table>
	</ul>
	

</body>
</html>
<!-- 단축키: 
ctrl + 스페이스바 : 자동완성
ctrl + d  :한줄 삭제
ctrl + altr + 방향키 : 한줄 복사
alt + 방향키 : 줄이동
ctrl + shift +  / : 주석
shift + 엔터 : 다음줄 이동
-->






