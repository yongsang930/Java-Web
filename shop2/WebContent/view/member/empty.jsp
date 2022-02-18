
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type='text/css' href="../editForm.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: rgb(177, 214, 198);
	opacity: 1;
	background-size: cotain;
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
	background-color: rgb(219, 230, 228);
	opacity: 1;
}

fieldset>legend {
	font-weight: bold;
}

table {
	border-collapse: collapse;
}

button {
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

#inBox {
	text-align: left;
}
#leftBox{
	width: 60px;

}
input {
	padding: 5px 0;
	border: 0px;
	text-align: center;
	width: 300px
}
</style>
</head>
<body>
	<div>
		<fieldset>
			<legend>내 정보 수정</legend>
			<c:if test="${not empty m}">
				<form action="${pageContext.request.contextPath }/EditController"
					method="post">
					<table border="1">
						<tr>
							<td id="leftBox">id</td>
							<td id="inBox">
								<input type="text" name="id" value="${m.id }"readonly> 
								<c:if test="${m.type==1 }">판매자</c:if> 
								<c:if test="${m.type==2 }">구매자</c:if>
							</td>
						</tr>
						<tr>
							<td id="leftBox">pwd</td>
							<td id="inBox"><input type="password" name="pwd"
								value="${m.pwd }"></td>
						</tr>
						<tr>
							<td id="leftBox">name</td>
							<td id="inBox"><input type="text" name="name"
								value="${m.name }"></td>
						</tr>
						<tr>
							<td id="leftBox">email</td>
							<td id="inBox"><input type="text" name="email"
								value="${m.email }"></td>
						</tr>
						<tr>
							<td id="leftBox">address</td>
							<td id="inBox"><input type="text" name="addr"
								value="${m.addr }"></td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit">수정</button>
								<button type="button" onclick="location.href='${pageContext.request.contextPath}/view/member/loginForm.jsp'">이전화면</button>
							</td>
						</tr>
					</table>
				</form>
			</c:if>
		</fieldset>
	</div>
</body>
</html>