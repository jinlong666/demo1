<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ page import="entity.*"%>
<%@ page import="dao.NewsDao"%>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>
<html>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<%-- <jsp:inculde page="/adminURl" ></jsp:inculde> --%>

<title>新闻发布系统管理后台</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：${name}&#160;&#160;&#160;&#160; 登录  &#160;&#160;&#160;&#160; <a href="../util/do_logout.jsp"></a></div>
  <div id="channel"> </div>
</div>
</head>
<body>
<div id="main">
  <div id="opt_list">
  <ul>
   <li><a href="AddNewsURl?name=${name}">添加新闻</a></li>
    <li><a href="adminURl?name=${name}">编辑新闻</a></li>
    <li><a href="util/add_title.jsp?name=${name}">添加主题</a></li>
    <li><a href="SetTitleURl?name=${name}">编辑主题</a></li>
  </ul>
</div>

<div id="opt_area">    
</script>
    <ul class="classlist">       
     	<c:forEach items="${Page.datas}" var="i"> 
       		<li>${i.title}
       			<span> 作者：${i.author}
       			 	<a href='util/news_update.jsp?id=${i.id}'>修改</a> &#160;&#160;&#160;&#160;
       			  	<a href='util/newsDel.jsp?id=${i.id}' >删除</a>
       			 </span>
       		 </li>
       	</c:forEach>
	  <p align="right">当前页数:[${Page.pageNo }/${Page.pageNums }] 
	  
	   
       	   <c:if test="${Page.pageNo > 1}">
	       	  &nbsp;<a href="adminURl?name=${name}&pageNo=1">首页</a>
	       	  &nbsp;<a href="adminURl?name=${name}&pageNo=${Page.pageNo-1}">上一页</a> 
     	  </c:if>
       
       	  <c:if test="${Page.pageNo < Page.pageNums}">
	       	  &nbsp;<a href="adminURl?name=${name}&pageNo=${Page.pageNo+1}">下一页</a>
	       	  &nbsp;<a href="adminURl?name=${name}&pageNo=${Page.pageNums}">末页</a> 	 
       	  </c:if>
	 	
	
	   
    </ul>
  </div>
</div>
<div id="footer">
  <div id="site_link"> <a href="#">关于我们</a><span>|</span> <a href="#">Aboue Us</a><span>|</span> <a href="#">联系我们</a><span>|</span> <a href="#">广告服务</a><span>|</span> <a href="#">供稿服务</a><span>|</span> <a href="#">法律声明</a><span>|</span> <a href="#">招聘信息</a><span>|</span> <a href="#">网站地图</a><span>|</span> <a href="#">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;  新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888  &#160;&#160;&#160;&#160;  举报邮箱：<a href="#">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright &copy; 1999-2009 News China gov, All Right Reserver<br />
    新闻中国   版权所有</p>
</div>
</body>
</html>