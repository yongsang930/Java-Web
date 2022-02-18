<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function a() {

		var flag = confirm("정말 삭제하시겠습니까?");

		if (flag) {
			document.f.action = "${pageContext.request.contextPath}/seller/Del?num=${p.num}";
			document.f.submit();
		} else
			alert("삭제가 취소 되었습니다.");
	}
</script>
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
	margin-left: 530px;
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
	margin: 10px 0px;
	font-size: 20px;
	font-weight: bold;
	font-family: 'Hi Melody', cursive;
	border: 0;
	color: white;
	background-color: rgba(3, 45, 81, 1);
	border-radius: 10px 10px 10px 10px/10px 10px 10px 10px;
	font-size: 20px;
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
	width: 400px;
	height: 80px;
	font-size: 18px;
	background-color: rgba(243, 250, 253, 0.8);
	font-weight: bold;
}

th {
	width: 150px;
	height: 80px;
	color: white;
	background-color: rgba(3, 45, 81, 1);
}

td {
	font-weight: bold;
	font-family: 'Hi Melody', cursive;
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
</style>
</head>
<body>
	<div class="container">
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/loginForm.jsp'">로그아웃</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/form.jsp'">회원가입</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/ListController'">고객게시판</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/order/list'">전체
			상품보기</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/ListAllController'">주문현황</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/seller/Add'">내
			판매목록</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/editForm.jsp'">내정보</button>
	</div>
	<div>
		<fieldset style="display: inline;">
			<legend>상세 페이지</legend>
			<form name="f"
				action="${pageContext.request.contextPath }/seller/Edit"
				method="post" style="padding: 0px 0px">
				<table border="1">
					<tr>
						<th>상품명</th>
						<td><input type="text" name="name" value="${p.name}"></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="price" value="${p.price }"></td>
					</tr>
					<tr>
						<th>수량</th>
						<td><input type="text" name="quantity" value="${p.quantity }"></td>
					</tr>
					<tr>
						<th>상세 이미지</th>
						<td>${p.img }<br> <img alt="푸마" src="${p.img }"
							width="400" height="300">
						</td>
					</tr>
					<tr>
						<th>상세 설명</th>
						<td><input type="text" name="content" value="${p.content }"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center">
							<button type="submit">수정</button>
							<button type="reset" onclick="a()">삭제</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="num" value="${p.num }">
			</form>
		</fieldset>
	</div>
</body>
</html>