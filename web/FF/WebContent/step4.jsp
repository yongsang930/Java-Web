<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	**jsp에서 폼데이터를 받아온다**
	<br>
	<table border="2">
		<tr>
			<td>이름:<%=request.getParameter("username") %></td>
			<td>암호:<%=request.getParameter("userpass") %></td>
		</tr>
	</table>
</body>
</html>