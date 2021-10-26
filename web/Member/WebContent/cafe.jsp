<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		var flag = confirm("로그아웃 하시겠습니까?");
		if (flag) {
			location.href = "LogoutServlet";
		} else {
			location.href = "cafe.jsp";
		}
	}
</script>

</head>
<body>
	<%
		MemberVO vo = (MemberVO) session.getAttribute("loginInfo");
	if (vo != null) {
	%>
	<%=vo.getName()%>님 입장을 환영합니다.
	<input type="button" value="로그아웃" onclick="logout()">

	<%
		} else {
	%>
	<script type="text/javascript">
		alert("로그인 해야 입장가능");
		location.href = "login.jsp"
	</script>
	<%
		}
	%>
</body>
</html>