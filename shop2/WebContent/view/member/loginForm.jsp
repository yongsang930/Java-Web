<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String str = (String) session.getAttribute("fail");

if (str == null)
	str = "";

session.invalidate();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Kirang+Haerang&display=swap');
body {
	background-color: rgb(249, 248, 247);
	opacity: 1;
	background-size: cotain;
	font-family: 'Kirang Haerang', cursive;
}

div {
	text-align: center;
}

fieldset {
	margin-top: 300px;
	display: inline;
	border-width: 2px;
	border-style: inset;
	border-color: gray;
	display: inline;
	background-color: rgba(243, 240, 236);
	padding: 30px 45px;
}

fieldset>legend {
	font-weight: bold;
}

table {
	border-collapse: collapse;
}

button {
	font-size: 17px;
	font-weight: bold;
	color: black;
	transition: 0.8s;
	background: transparent;
	cursor: pointer;
	border-radius: 10px 10px 10px 10px/10px 10px 10px 10px;
	border: 0;
}

button:hover {
	background-color: #03826E;
	color: white;
	opacity: 1;
}

a {
	text-decoration: none;
	color: black;
}

input {
	font-size: 15px;
	padding: 5px 0;
	border: 0px;
	text-align: center;
	height: 30px;
}

td {
	font-size: 20px;
	font-weight: bold;
	width: 80px;
	height: 30px;
}

legend {
	font-size: 25px;
}

.container {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: flex-end;
}

.container>button:hover {
	background-color: rgba(253, 170, 57, 0.5);
	transition: 1s;
	cursor: pointer;
	color: black;
}

.container>button {
	margin-left: 10px;
	font-size: 15px;
	font-weight: bold;
	border: 0;
	background-color: rgba(253, 170, 57, 0.2);
	color: black;
	border-radius: 10px 10px 10px 10px/10px 10px 10px 10px;
}
</style>
</head>
<body>
	<div>
		<fieldset>
			<legend>로그인</legend>
			<form method="post"
				action="${pageContext.request.contextPath}/LoginController">
				<table border=1>
					<tr>
						<td width="50" style="text-align: center">id</td>
						<td><input type="text" name="id" autocomplete='off' autofocus></td>
					</tr>
					<tr>
						<td width="50" style="text-align: center">pwd</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr style="text-align: center;">
						<td colspan="2">
							<button type="submit">로그인</button>
							<button type="button"
								onclick="location.href='${pageContext.request.contextPath}/view/member/form.jsp'">회원가입</button>
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
		<div style="color: red">
			<b><%=str%></b>
		</div>
	</div>
</body>
</html>