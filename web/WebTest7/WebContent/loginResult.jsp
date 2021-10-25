<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
<!-- 	세션객체가 새것이 아니면 로그인 결과가 result속성으로 저장되어 있으므로 이 값을 읽는다.  -->
<!-- 	만약 세션이 새것이면 result속성이 없다.  -->
	
	<%
		boolean result = false;
		if (!session.isNew()) {
			result = (boolean) session.getAttribute("result");
		}
// 		  result가 true이면 페이지에 로그인 성공 메시지를 출력하고 세션에 저장된 id를 읽어서 출력한다.
//  		<a href="loginForm.jsp">로그인 폼</a>은 로그아웃 페이지로 이동할 수 있도록 링크를 만들었다. 
//  		만약, 세션이 새것이라면 result는 boolean result = false;로 초기화 했기 때문에 false 이다. 
		
		String id = "";
		if (result) {
			id = (String) session.getAttribute("id");
	%>
			로그인 성공<br>
			<%=id%>님 반갑습니다.<br>
			<a href="logout.jsp">로그아웃</a>
	<%
		} else {
	%>
<!-- 	 result가 false이면 로그인 실패 메시지를 출력한다. 로그인 할 수 있는 폼으로 이동 할수 있는 링크를 구현했다.  -->
			로그인 실패<br>
			<a href="loginForm.jsp">로그인 폼</a>
	<%
		}
	%>

</body>
</html>