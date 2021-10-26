<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!

public ArrayList getList(){
	ArrayList list = new ArrayList();
	list.add("아이유");
	list.add("태연");
	list.add("나연");
	list.add("미나");
	list.add("모모");
	list.add("사나");
	list.add("채영");
	list.add("소희");
	
	return list;
}

%>

<table border="2">
<%
ArrayList list=getList();

for(int i=0; i<list.size(); i++){
%>
<tr>
<td><%=i %></td>
<td><%=list.get(i) %></td>
</tr>

<%} %>
</table>
</body>
</html>