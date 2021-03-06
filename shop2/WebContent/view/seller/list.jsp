<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type='text/css' href="../loginForm.css">
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

span {
	text-align: right;
	margin-left: 950px;
	margin-bottom: 20px;
}

fieldset {
	margin-top: 50px;
	display: inline;
	border-width: 2px;
	border-style: inset;
	border-color: gray;
	display: inline;
	background-color: rgba(243, 240, 236, 0.9);
	padding: 20px 50px;
}

fieldset>legend {
	font-weight: bold;
	font-size: 25px;
}

table {
	border-collapse: collapse;
}

button {
	font-size: 20px;
	font-weight: bold;
	font-family: 'Hi Melody', cursive;
	border: 0;
	color: black;
	border-radius: 10px 10px 10px 10px/10px 10px 10px 10px;
}

input {
	padding: 5px 0;
	border: 0px;
	text-align: center;
}

th {
	width: 200px;
	height: 60px;
	color: white;
	background-color: rgba(3, 45, 81, 1);
}

td {
	font-size: 25px;
	font-weight: bold;
	font-family: 'Hi Melody', cursive;
	height: 150px;
	padding: 0;
	margin: 0 0;
	background-color: rgba(255, 255, 255, 0.8);
}

.container {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: flex-end;
}

.container>button {
	margin-left: 10px;
	font-size: 15px;
	font-weight: bold;
	font-family: 'Hi Melody', cursive;
	border: 0;
	background-color: rgba(253, 170, 57, 0.2);
	color: black;
	border-radius: 10px 10px 10px 10px/10px 10px 10px 10px;
}

button:hover {
	background-color: rgba(253, 170, 57, 0.5);
	transition: 0.5s;
	cursor: pointer;
	color: black;
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
		<fieldset>
			<legend>?????? ????????? ??????<br>(????????? ??????)</legend>
			<span style="display: flex; justify-content: flex-end;">
				<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/seller/AddForm'">
					?????? ?????? ??????</button>
			</span>
			<table border=1>
				<tr>
					<th style="width: 50px">??????</th>
					<th style="width: 200px">???????????????</th>
					<th style="width: 200px">?????????</th>
					<th>??????</th>
					<th>??????</th>
					<th>?????????</th>
				</tr>
				<c:forEach var="p" items="${products }">
					<tr>
						<td>${p.num }</td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/seller/detail?num=${p.num}'">
								<img alt="???????????????" src="${p.img}" width="200" height="180">
							</button></td>
						<td><button
								onclick="location.href='${pageContext.request.contextPath }/seller/detail?num=${p.num}'">${p.name}</button>
						</td>
						<td>${p.quantity }</td>
						<td>${p.price}</td>
						<td>${p.s_id }</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</div>
</body>
</html>