<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>모든 고객을 조회하여 출력하기</h3>
	<p>TblCustomerDao 메소드로 db접속 및 조회결과하는 연습입니다</p>
	<hr>
<%
	TblCustomerDao dao = new TblCustomerDao();
	List<CustomerVo> list = dao.allCustomers();
%>
	<table>
	
<% 
	for(CustomerVo vo :list){ //for시작
		
%>
	<tr>
		<td><%= vo.getCustomId() %></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getEmail() %></td>
		<td><%= vo.getAge() %></td>
		<td><%= vo.getReg_data() %></td>
	</tr>
<%
	} //for 끝
%>
	</table>
	
	

</body>
</html>