<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- language = "java" : java ���� ������ �ȴ�.
       contentType = "text/html; charest = UTF - 8 : �������� ������� ������ html
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ȸ�� ���� - Welcome</title>
</head>
<body>
   <h1>WELCOME</h1>
    <h3>ȸ�� ������ �Ϸ�Ǿ����ϴ�.</h3>
<!-- �ڹ� ���α׷����� �ϴ� ��ũ��Ʈ �ۼ� �κ��Դϴ�(��ũ��Ʈ��) -->
<%
   /* form �±׾��� �Է¾���� ������ ����� ��, �� ���� �޾� �����ϴ� �ڵ��Դϴ�.
      getParameter �޼ҵ��̹Ƿ� �����δ� �Է� ��Ҹ� �Ķ���Ͷ�� �θ��ڽ��ϴ�.*/   
   
      // ���̵�. input ����� name �Ӽ� ���� ���ڷ� �մϴ�.
   String id = request.getParameter("");      
   String password = request.getParameter("password"); // �н����� 
   
   out.print("<h3>���̵�</h3>");
   out.print(id);
   
   out.print("<h3>��й�ȣ</h3>");
   out.print(password);
%>
    <hr>
    <p>form ���� Ȯ�� ������ �Դϴ�.</p>
   
</body>
</html>
<!--jsp�� ���������� ������ �ǰ� ������ �˴ϴ�
������ ������ .java���Ϸ� ����ǰ� 
.java�� �������ؼ� .Class�� �����մϴ� 
���������� ��û�� Ŭ���̾�Ʈ���Դ� .class ���Ϸ� html ������ �ۼ��Ͽ� �����մϴ�
��Ŭ������ jsp �� ���� �ҽ������� �����ִ� (���� ��) 
��   D:\Class231228jyj\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\jsp1\org\apache\jsp
���� ȯ�濡���� tomcat ���� �ȿ��� �ٷ� ã�����ִ�. ��Ŭ���������� ��ΰ� �̷��� �����

��Ŭ������ webapp ������ ����� ���ϵ��� jsp�����ϰ� ���⿡ �ֽ��ϴ�
��   D:\Class231228jyj\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
 ���� ����ȯ�濡���� tomcat�����ȿ��� �ٷ� ã�����ֽ��ϴ� --> 

