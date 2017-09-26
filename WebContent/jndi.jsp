<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="javax.naming.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//定义context
		Context context = new InitialContext();
		//使用lookup查找资源信息  注意固定前缀java:com/eve/
		String result = (String)context.lookup("java:com/eve/tjndi");
		out.print(result);
	%>
</body>
</html>