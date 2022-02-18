<%@page import="jdk.javadoc.internal.doclets.formats.html.markup.Script"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	font-size: 17px;
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
	font-size: 15px;
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
	font-size: 20px;
	width: 90px;
	height: 40px;
	font-family: 'Hi Melody', cursive;
}

th {
	font-size: 23px;
	width: 90px;
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
	font-family: 'Hi Melody', cursive;
}

.gender>input {
	width: 15px;
	height: 15px;
	display: inline;
	flex-direction: row;
	font-size: 15px;
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
			onclick="location.href='${pageContext.request.contextPath}/view/member/loginForm.jsp'">로그아웃</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/form.jsp'">회원가입</button>
		<c:if test="${m.type==2 }">
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/order/myList'">주문조회</button>
		</c:if>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/ListController'">고객게시판</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/order/list'">전체
			상품보기</button>
		<c:if test="${m.type==1 }">
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/ListAllController'">주문현황</button>
		</c:if>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/editForm.jsp'">내정보</button>
	</div>
	<div>
		<fieldset>
			<legend>고객 게시판</legend>
			<form action="${pageContext.request.contextPath }/WriteController"
				method="post">
				<table border="1">
					<tr>
						<th>작성자</th>
						<td><input type="text" value="${sessionScope.m.id}"
							name="writer" size="45" readonly="readonly" required></td>
					</tr>
					<tr>
						<th>제품</th>
						<td class="select"><select name="pname" required>
								<c:forEach var="p" items="${p_list}">
									<option value="${p}">${p}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" size="45" required></td>
					</tr>
					<tr>
						<th>문의 내용</th>
						<td><textarea name="content" rows="15" cols="30" required></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="reset">초기화</button>
							<button type="submit">등록</button>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>