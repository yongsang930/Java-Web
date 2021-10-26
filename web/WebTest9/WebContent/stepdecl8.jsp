<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!

public void jspInit(){
	Member m = new Member("나연","아이유","민아","사나");
	ServletContext context = getServletContext();
	context.setAttribute("m", m);
}

%>

	<%
Member m = (Member) application.getAttribute("m");
out.print("id:"+ m.getId()+"<br>");
out.print("password:"+ m.getPassword()+"<br>");
out.print("name:"+ m.getName()+"<br>");
out.print("address:"+ m.getAddress()+"<br>");
%>



</body>
</html>