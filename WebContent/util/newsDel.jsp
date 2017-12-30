
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dao.NewsDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newsDel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	long id=Long.parseLong(request.getParameter("id"));
    	int r=NewsDao.dao.del(id);
    	if(r>0)
    	{
    		out.print("<h2>删除成功</h2>");
    		
    	}
    %> 
   <span id="timer">10</span>秒返回，<a href="admin.jsp">返回</a>
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
