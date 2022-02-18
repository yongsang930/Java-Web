<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%-- 
<input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" id="sample4_detailAddress" placeholder="상세주소">
<input type="text" id="sample4_extraAddress" placeholder="참고항목">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
--%>

<%
	String dupl = (String) session.getAttribute("dupl");

if (dupl == null)
	dupl = "";

session.invalidate();
%>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	// 주소 관련 API
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if (roadAddr !== '') {
							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("sample4_extraAddress").value = '';
						}

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
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

.gender > input {
	width: 15px;
	height: 15px;
	display: inline;
	flex-direction: row;
	font-size: 15px;
}
</style>
</head>
<body>
	<div class="container">
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/view/member/loginForm.jsp'">홈화면</button>
	</div>
	<div>
		<fieldset>
			<legend>회원가입</legend>
			<form method="post"
				action="${pageContext.request.contextPath}/JoinController">
				<table border=1>
					<tr>
						<th>id</th>
						<td><input type="text" name="id" autocomplete='off'
							placeholder="아이디" required></td>
					</tr>
					<tr>
						<th>password</th>
						<td><input type="password" name="pwd" autocomplete='off'
							placeholder="비밀번호" required></td>
					</tr>
					<tr>
						<th>name</th>
						<td><input type="text" name="name" autocomplete='off'
							placeholder="이름" required></td>
					</tr>
					<tr>
						<th>email</th>
						<td><input type="text" name="email" autocomplete='off'
							placeholder="이메일" required></td>
					</tr>
					<tr>
						<th rowspan="3">address<br> <input id="searchAddr"
							type="button" onclick="sample4_execDaumPostcode()" value="search"></th>
						<td><input type="text" name="postcode" id="sample4_postcode"
							placeholder="우편번호" required></td>
					</tr>
					<td><input type="text" name="r_addr" id="sample4_roadAddress"
						autocomplete='off' placeholder="도로명주소" required></td>
					<tr>
						<td><input type="text" name="d_addr"
							id="sample4_detailAddress" placeholder="상세주소 입력"></td>
					</tr>
					<tr>
						<th>회원종류</th>
							<td>
						<span class="gender"> 
							<input type="radio" name="type" value="1" required>판매자 
							<input type="radio" name="type"	value="2" required>구매자 
						</span>
							</td>
					</tr>
					<tr>
						<td class="test" colspan="2">
							<button type="reset">초기화</button>
							<button type="submit">가입</button>
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
		<div style="color: red">
			<b><%=dupl%></b>
		</div>
	</div>
</body>

</html>