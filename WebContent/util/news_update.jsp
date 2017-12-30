<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.NewsDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>"><!-- base 的作用？？ -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    	long id=Long.parseLong(request.getParameter("id"));
    	
    %> 
   <span id="timer">5</span>秒返回，<a href="admin.jsp">返回</a>
  </body>
   <script>
       var d=document.getElementById("timer").innerHTML;
   		window.setInterval(function(){
   			 d--;
   			 if(d<1)
   				 {
   				 	window.location="admin.jsp";
   				 	return;
   				 }
   			document.getElementById("timer").innerHTML=d;
   		},1000);
   </script>
</html>
