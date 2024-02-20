<%@page import="project.dao.TblCustomerDao"%>
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
<p>2번 select 조회결과 확인과 같이 이번에는 insert 실행ㅇ해봅시다</p>
<%

	CustomerVo vo = new CustomerVo("sana","김사나","sana@gmail.com",23,null);
	//dao 생성해서 insert하기
	TblCustomerDao dao = new TblCustomerDao();
	dao.join(vo);
	
	%>
	<h4>CustomerVo 객체</h4>
	<table style="width: 600px">
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
	<p>아래 링크로 페이지 이동해서 insert됐는지 확인해봅시다</p>
	<a href="2_jdbc.jsp">전체 고객 조회</a>
	

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






