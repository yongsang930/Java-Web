<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>메뉴</h3>
	<%
		boolean flag = false;
	if (!session.isNew())
		flag = (boolean) session.getAttribute("flag");
	if (flag) {
		String id = (String) session.getAttribute("id");
	%>
	<%=id%>님 로그인
	<br>
	<a href="<%=request.getContextPath()%>/SearchController">내정보수정</a>
	<br>
	<a href="<%=request.getContextPath()%>/LogoutController">로그아웃</a>
	<br>
	<a href="<%=request.getContextPath()%>/DelController">탈퇴</a>
	<br>
	<%
		} else {
	%>
	<h3>로그인 실패</h3>
	<a href="<%=request.getContextPath()%>/member/loginForm.jsp">초기화면</a>
	<%
		}
	%>
</body>
</html>