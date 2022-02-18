<%@page import="model.Board"%>
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

span {
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
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
}

table {
	border-collapse: collapse;
}

button {
	font-size: 20px;
	font-weight: bold;
	font-family: 'Hi Melody', cursive;
	border: 0;
	background-color: rgba(253, 170, 57, 0.2);
	color: black;
	border-radius: 10px 10px 10px 10px/10px 10px 10px 10px;
	margin-left: 10px;
	margin-bottom: 10px;
}

button:hover {
	background-color: rgba(253, 170, 57, 0.5);
	transition: 0.5s;
	cursor: pointer;
	color: black;
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
	height: 50px;
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
.container > button:hover {
	background-color: rgba(253, 170, 57, 0.5);
	transition: 1s;
	cursor: pointer;
	color: black;
}


a {
	text-decoration: none; 
	color: navy;
	background-image: linear-gradient(white -1000%, currentcolor 2000%);
	background-position: 0 0.95em;
	background-repeat: repeat-x;
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
			<legend style="font-size: 35px">게시글 목록</legend>
			<c:if test="${sessionScope.m.type==2}">
				<span style="display: flex; justify-content: flex-end;">
					<button type="button"
						onclick="location.href='${pageContext.request.contextPath}/view/board/form.jsp'">문의글
						작성</button>
				</span>
			</c:if>
			<c:if test="${not empty b_list }">
				<table border="1" cellspacing="0">
					<tr>
						<th>글번호</th>
						<th>제품명</th>
						<th style="width: 350px;">제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
					<c:forEach var="b" items="${b_list }">
						<tr>
							<td>${b.b_num }</td>
							<td>${b.b_pname }</td>
							<td><a
								href="${pageContext.request.contextPath }/ReadController?num=${b.b_num}">${b.b_title }</a>
							</td>
							<td>${b.b_id }</td>
							<td>${b.b_date }</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${ empty b_list }">
		작성된 글이 없습니다.
	</c:if>
		</fieldset>
	</div>
</body>
</html>