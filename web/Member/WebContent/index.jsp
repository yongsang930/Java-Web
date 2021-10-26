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

	Model2 MVC 적용 회원 관리 프로그램
	<a href="find.html">회원검색</a>

	<%
		MemberVO vo = (MemberVO) session.getAttribute("loginIfo");
	if (vo == null) {
	%>
	<a href="register.jsp">회원가입</a>
	<a href="login.jsp">로그인</a>

	<%
		} else {
	%>
	<%=vo.getName()%>
	님 로그인 중 입니다.
	<a href="update.jsp"> 회원정보수정</a>
	<%
		}
	%>
</body>
</html>