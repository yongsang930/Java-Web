<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="<%=request.getContextPath()%>/JoinController" method="post">
	id: <input type="text" name="id"><br>
	pwd: <input type="password" name="pwd"><br>
	name: <input type="text" name="name"><br>
	email: <input type="text" name="email"><br>
	<button type="submit">가입신청</button>
	<button type="reset">초기화</button>
	
	</form>
</body>
</html>



