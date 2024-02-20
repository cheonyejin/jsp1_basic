<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6_selectBy</title>
</head>
<body>
   <% 
   String name= request.getParameter("name");
   String temp= request.getParameter("age");
   TblCustomerDao dao = new TblCustomerDao();
   List<CustomerVo> list = null;
   
   if((name!=null&&name.length()!=0)&&(temp!=null&&temp.length()!=0)){      
      int age = Integer.parseInt(temp);
      out.print("<h4>name</h4>");
      out.print(name);
      out.print("<h4>age</h4>");
      out.print(age);
      out.print("<h4>selectByNameAge 출력하기</h4>");
      list=dao.selectMyNameAge(name, age);
      out.print(list);
      if(list.size()==0) out.print("<h4>조회결과가 없습니다</h4>");
   //todo: name과 age값으로 테이블에서 조회하고 결과 출력하기
   //age는 정수 타입으로 변경되어야 합니다.
   }else{out.print("파라미터 값은 모두 입력하세요");}%>
</body>
</html>