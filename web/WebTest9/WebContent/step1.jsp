<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Hello JSP</h3>

	<!-- jsp주석 -->

	<%
		//자바주석

	int i;
	for (i = 1; i < 6; i++) {
	%>

	<h <%=i%>>hello</h<%=i%>>

	<%
		}
	%>

</body>
</html>