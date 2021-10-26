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
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
String address = request.getParameter("address");

Member m = new Member(id,password,name,address);

%>

<h3>회원정보</h3>
<table border="1">
<tr>
<th>id</th>
<th>password</th>
<th>name</th>
<th>address</th>
</tr>

<tr>
<td><%=m.getId() %></td>
<td><%=m.getPassword() %></td>
<td><%=m.getName() %></td>
<td><%=m.getAddress() %></td>
</tr>
<tr>
<td><%=id %></td>
<td><%=password %></td>
<td><%=name%></td>
<td><%=address %></td>

</tr>
</table>
</body>
</html>