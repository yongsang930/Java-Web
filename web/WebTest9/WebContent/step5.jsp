<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>구구단</h3>
	<table border="1">
		<tr>
			<%
				int i, j;
			for (i = 1; i < 10; i++) {
			%>

			<td><%=i%>단</td>
			<%
				}
			%>
		</tr>
		<tr>
			<%
				for (i = 1; i < 10; i++) {
				out.print("<td>");
				for (j = 1; j < 10; j++) {
					out.print(i + "*" + j + "=" + i * j+"<br>");
				}
				out.print("</td>");
			}
			%>
		</tr>
	</table>
</body>
</html>