<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>로그아웃 되었습니다.</h3>
	<%
// 		session.removeAttribute("result");
// 		session.removeAttribute("id");
		
        session.invalidate();
	%>
	<a href="loginResult.jsp">loginResult.jsp로 이동</a>
</body>
</html>