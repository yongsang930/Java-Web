<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
<body>
	<div class="container">
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/loginForm.jsp'">๋ก๊ทธ์์</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/form.jsp'">ํ์๊ฐ์</button>
		<c:if test="${m.type==2 }">
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/order/myList'">์ฃผ๋ฌธ์กฐํ</button>
		</c:if>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/ListController'">๊ณ?๊ฐ๊ฒ์ํ</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/order/list'">์?์ฒด
			์ํ๋ณด๊ธฐ</button>
		<c:if test="${m.type==1 }">
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/ListAllController'">์ฃผ๋ฌธํํฉ</button>
		</c:if>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/editForm.jsp'">๋ด์?๋ณด</button>
	</div>
	<div>
		<fieldset>
			<c:forEach var="o" items="${o_list }">
				<c:if test="${o.o_state==0 }">
					<legend> ์ฃผ๋ฌธ ๋ชฉ๋ก </legend>
				</c:if>
				<c:if test="${o.o_state==1 }}">
					<legend> ์ฅ๋ฐ๊ตฌ๋ ๋ชฉ๋ก </legend>
				</c:if>
				<table border="1">
					<tr>
						<th>์ฃผ๋ฌธ๋ฒํธ</th>
						<th>์?ํ๋ช</th>
						<th>์?ํ ์ด๋ฏธ์ง</th>
						<th>์ฃผ๋ฌธ์๋</th>
						<th>๊ฒฐ์?๊ธ์ก</th>
						<th>์ฃผ๋ฌธ์ผ</th>
					</tr>
					<c:forEach items="${o_list }" varStatus="status">
						<tr>
							<td>${o.num }</td>
							<td><button
									href="${pageContext.request.contextPath }/seller/detail?num=${p_list[status.index].num}">${p_list[status.index].name }
								</button></td>
							<td>
								<button>
									<img alt="" src="${p_list[status.index].img }" width="200"
										height="150">
								</button>
							</td>
							<td>${o.order_num }</td>
							<td>${o.total_price }</td>
							<td>${o.o_date }</td>
						</tr>
					</c:forEach>
				</table>
			</c:forEach>
		</fieldset>
	</div>
</body>
</html>