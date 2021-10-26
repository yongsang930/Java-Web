<%@page import="model.MemberVO"%>
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
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");

	if (vo != null) {
	%>
	<%=vo.getName()%>님 로그인 ok!
	<a href=cafe.jsp>카페로 이동</a>
	<a href=index.jsp>홈으로 이동</a>
	<%
		} else {
	response.sendRedirect("login.jsp");
	}
	%>


</body>
</html>