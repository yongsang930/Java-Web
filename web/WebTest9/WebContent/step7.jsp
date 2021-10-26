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

private String name = "나연";
	
public int getAge(){
	return 25;
}

%>

이름: <%=name %>, 나이:<%=getAge() %>

</body>
</html>