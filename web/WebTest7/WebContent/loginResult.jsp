<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
<!-- 	���ǰ�ü�� ������ �ƴϸ� �α��� ����� result�Ӽ����� ����Ǿ� �����Ƿ� �� ���� �д´�.  -->
<!-- 	���� ������ �����̸� result�Ӽ��� ����.  -->
	
	<%
		boolean result = false;
		if (!session.isNew()) {
			result = (boolean) session.getAttribute("result");
		}
// 		  result�� true�̸� �������� �α��� ���� �޽����� ����ϰ� ���ǿ� ����� id�� �о ����Ѵ�.
//  		<a href="loginForm.jsp">�α��� ��</a>�� �α׾ƿ� �������� �̵��� �� �ֵ��� ��ũ�� �������. 
//  		����, ������ �����̶�� result�� boolean result = false;�� �ʱ�ȭ �߱� ������ false �̴�. 
		
		String id = "";
		if (result) {
			id = (String) session.getAttribute("id");
	%>
			�α��� ����<br>
			<%=id%>�� �ݰ����ϴ�.<br>
			<a href="logout.jsp">�α׾ƿ�</a>
	<%
		} else {
	%>
<!-- 	 result�� false�̸� �α��� ���� �޽����� ����Ѵ�. �α��� �� �� �ִ� ������ �̵� �Ҽ� �ִ� ��ũ�� �����ߴ�.  -->
			�α��� ����<br>
			<a href="loginForm.jsp">�α��� ��</a>
	<%
		}
	%>

</body>
</html>