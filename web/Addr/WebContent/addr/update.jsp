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
		Member m = (Member) request.getAttribute("m");
	%>

	<form method="post" action="<%=request.getContextPath()%>/control?num=<%=m.getNum()%>">
	<input type="hidden" name="type" value="edit">
		이름: <input type="text" name="name" value="<%=m.getName()%>">
		전화번호: <input type="text" name="tel" value="<%=m.getTel()%>">
		주소: <input type="text" name="address" value="<%=m.getAddress()%>">
		우편번호: <input type="text" name="postal" value="<%=m.getPostal()%>">
		<input type="submit" value="수정">
	</form>
</body>
</html>