<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Member"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Member m = (Member)session.getAttribute("m");
%>
<h3>내 정보 수정</h3>
	<form method="post" action="<%=request.getContextPath()%>/EditController">
	id: <input type="text" name="id" value="<%=m.getId()%>" readonly="readonly"><br>
	pwd: <input type="password" name="pwd"><br>
	name: <input type="text" name="name" ><br>
	email: <input type="text" name="email"><br>
	<button type="reset">초기화</button>
	<button type="submit">수정</button>
	</form>
</body>
</html>