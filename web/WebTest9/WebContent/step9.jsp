<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
MemberVO vo = new MemberVO("JAVA","1234","아이유","판교");
%>

<%if(vo.getId().equals("java") && vo.getPassword().equals("1234")){%>
회원 아이디: <%=vo.getId() %>
회원 이름: <%=vo.getName() %>
회원 주소: <%=vo.getAddress() %>
<%}else{%>
회원이 아닙니다.
<%} %>
</body>
</html>