<%@page import="model.Board"%>
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
	display: inline;
	justify-content: center;
	flex-wrap: nowrap;
	padding: 20px 50px;
	border-width: 2px;
	border-style: inset;
	border-color: gray;
	background-color: rgba(243, 240, 236, 0.9);
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
	padding: 5px 10px;
}

button:hover {
	background-color: rgba(253, 170, 57, 0.5);
	transition: 1s;
	cursor: pointer;
	color: black;
}

input {
	padding: 0px;
	border: 0px;
	text-align: center;
	font-size: 16px;
	width: 320px;
	height: 60px;
}

th {
	width: 200px;
	height: 60px;
	color: white;
	background-color: rgba(3, 45, 81, 1);
	padding: 0px;
}

td {
	font-size: 25px;
	font-weight: bold;
	font-family: 'Hi Melody', cursive;
	padding: 0 0;
	margin: 0 0;
	background-color: rgba(255, 255, 255, 0.8);
}

.container {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: flex-end;
	position: sticky;
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

.container>button:hover {
	background-color: rgba(253, 170, 57, 0.5);
	transition: 1s;
	cursor: pointer;
	color: black;
}

textarea {
	border: 0px;
	width: 320px;
	text-align: center;
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

		<c:set var="str">
			<c:if test="${sessionScope.m.id != b.b_id }">
			readonly
		</c:if>
		</c:set>
		<fieldset>
			<legend style="font-size: 35px">게시글 확인</legend>

			<form
				action="${pageContext.request.contextPath }/EditBoardController"
				method="post">
				<table border="1">
					<tr>
						<th>글 번호</th>
						<td><input type="text" name="num" value="${b.b_num }" 
							readonly></td>
					</tr>
					<tr>
						<th>글 제목</th>
						<td><input type="text" name="title" value="${b.b_title }"
							${str }></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="id" value="${b.b_id}"  readonly></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td><input type="text" value="${b.b_date }" readonly></td>
					</tr>
					<tr>
						<th>제품</th>
						<td><input type="text" name="pname" value="${b.b_pname}" 
							readonly></td>
					</tr>
					<tr>
						<th>문의 내용</th>
						<td><textarea name="content" rows="15" cols="45" ${str }>${b.b_content }</textarea></td>
					</tr>
				</table>
					<c:if test="${sessionScope.m.id == b.b_id}">
						<button type="submit">수정</button>
						<button style="margin: 10px 0px 0px 10px;" type="button" onclick="location.href='${pageContext.request.contextPath }/DelBoardController?num=${b.b_num}'">삭제</button>
					</c:if>
			</form>
		</fieldset>
	</div>
</body>
</html>