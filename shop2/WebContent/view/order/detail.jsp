<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
button:hover {
	background-color: rgba(253, 170, 57, 0.5);
	transition: 0.5s;
	cursor: pointer;
	color: black;
}
</style>

<script type="text/javascript">

function a() {
	var sel = f.quantity.options[f.quantity.selectedIndex].value;
	var q = parseInt(sel);
	var total = q*${p.price};
	
	f.total_price.value = total;
	
}

function b(){
	
	f.o_state.value = "1";
	f.submit();
}

</script>
</head>
<body>
	<div class="container">
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/loginForm.jsp'">로그아웃</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/form.jsp'">회원가입</button>
			<button type="button"
				onclick="location.href='${pageContext.request.contextPath}/order/myList'">주문조회</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/ListController'">고객게시판</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/order/list'">전체
			상품보기</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/editForm.jsp'">내정보</button>
	</div>
	<div>
		<fieldset>
			<legend>상세 페이지</legend>
			<form action="${pageContext.request.contextPath}/order/add" name="f"
				method="post">
				<table border="1">
					<tr>
						<th>상품명</th>
						<td>${p.name }</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${p.price}</td>
					</tr>
					<tr>
						<th>주문수량</th>
						<td><select name="quantity" onchange="a(${p.price })" required>
								<option value="0" selected="selected">0개</option>
								<option value="1">1개</option>
								<option value="2">2개</option>
								<option value="3">3개</option>
								<option value="4">4개</option>
								<option value="5">5개</option>
						</select></td>
					</tr>
					<tr>
						<th>결제금액</th>
						<td><input type="text" name="total_price" required></td>
					</tr>
					<tr>
						<th>상품이미지</th>
						<td><img alt="" src="${p.img }" width="300" height="300">
						</td>
					</tr>
					<tr>
						<th>상세설명</th>
						<td>${p.content }</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center">
							<button type="submit">즉시주문</button>
							<button type="button" onclick="b()">장바구니</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="num" value="${p.num }"> <input
					type="hidden" name="o_state" value="0">
			</form>
		</fieldset>
	</div>
</body>
</html>