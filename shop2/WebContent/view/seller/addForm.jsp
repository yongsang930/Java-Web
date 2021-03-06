<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');

body {
	background-color: rgb(249, 248, 247);
	opacity: 1;
	background-size: cotain;
	font-size: 20px;
	font-family: 'Hi Melody', cursive;
}

div {
	text-align: center;
}

fieldset {
	margin-top: 250px;
	padding: 30px 40px;
	display: inline;
	border-width: 2px;
	border-style: inset;
	border-color: gray;
	display: inline;
	background-color: rgba(243, 240, 236, 0.9);
	opacity: 1;
	display: inline;
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
	font-size: 20px;
	font-family: 'Hi Melody', cursive;
}

fieldset>legend {
	font-weight: bold;
	font-size: 25px;
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
	padding: 5px 0;
	border: 0px;
	text-align: center;
	font-size: 20px;
	height: 40px;
	width: 300px;
}

#searchAddr {
	color: white;
	transition: 0.8s;
	background-color: #0C8035;
	cursor: pointer;
	border: 0;
	margin-top: 3px;
	padding: 2px 5px;
	height: 30px;
	width: 70px
}

td {
	padding: 0;
	font-size: 18px;
	width: 90px;
	height: 40px;
}

th {
	font-size: 20px;
	width: 110px;
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

textarea {
	width: 300px;
	padding: 0px;
	text-align: center;
	font-size: 15px;
	border: 0px;
}
</style>
</head>
<body>
	<div class="container">
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/loginForm.jsp'">????????????</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/form.jsp'">????????????</button>
		<c:if test="${m.type==2 }">
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/order/myList'">????????????</button>
		</c:if>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/ListController'">???????????????</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/order/list'">??????
			????????????</button>
		<c:if test="${m.type==1 }">
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/ListAllController'">????????????</button>
		</c:if>
				<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/seller/Add'">??? ????????????</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/editForm.jsp'">?????????</button>
	</div>
	<div>
		<form action="${pageContext.request.contextPath }/seller/Add"
			method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>?????? ??????</legend>
				<table border=1>
					<tr>
						<th>?????????</th>
						<td><input type="text" name="name">
					</tr>
					<tr>
						<th>??????</th>
						<td><input type="text" name="quantity"></td>
					</tr>
					<tr>
						<th>??????</th>
						<td><input type="text" name="price"></td>
					</tr>
					<tr>
						<th>?????? ????????? <br>??????
						</th>
						<td style="background-color: white;"><input type="file"
							name="img" width="30" height="0" style="font-size: 12px">
						</td>
					</tr>
					<tr>
						<th>????????????</th>
						<td><textarea rows="10" cols="30" name="content"></textarea></td>
					</tr>
				</table>
				<button type="submit">?????? ??????</button>
				<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/seller/List'">??????</button>
			</fieldset>
		</form>
	</div>
</body>
</html>