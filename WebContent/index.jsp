<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />

</head>
<body >

<div id="header">
  <div id="top_login">
  	<h3>${msg}</h3> 
  	<c:remove var="msg"/>
    <form action="adminURl" method="post" >
     <c:if test="${ !empty name }">
     	欢迎你: ${name} &nbsp;&nbsp;&nbsp;&nbsp;
     	<a href="LoginCookie">管理页面</a>
     </c:if>  
     <c:if test="${empty name}">
	      <label> 登录名 </label>
	      <input type="text" name="name" id="name" value="${param.name}" class="login_input" />
	      <label> 密&#160;&#160;码 </label>
	      <input type="password" name="pwd" id="pwd" value="${param.pwd}" class="login_input" />
	      <input type="submit" class="login_sub" value="登录" /><b></b><!-- 这里的注册失败信息应该怎么实现 -->
	      <label id="error"> </label>
	      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
     </c:if>
    </form>
  </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
  </div>
</div>
<div id="container">
<div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>   
      	<!--国内标题-->
      	<c:forEach items="${list1}" var="i">
      		<li><b><a herf='contentURl?id=${i.cate_id}'>${i.title}</a><b><li>
      	 </c:forEach>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>    
      	<!--国际标题-->
      	<c:forEach items="${list2}" var="i">
      		<li><b><a herf='contentURl?id=${i.cate_id}'>${i.title}</a><b><li>
      	 </c:forEach>
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      		<!--娱乐标题-->
          	<c:forEach items="${list3}" var="i">
      		<li><b><a herf='contentURl?id=${i.cate_id}'>${i.title}</a><b><li>
      	 	</c:forEach>
      </ul>
    </div>
  	</div>
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
	      	<li id='class_month'>
	      	<!-- 首页中间所有标题分类 -->
				<c:forEach items="${listAll }" var="c">
					<b><a href="indexURl?nid=${c.id }">${c.catename }</a><b>   &nbsp;
				</c:forEach>
      		</li>	
      </ul>
      <ul class="classlist">
      
              <!--新闻分类的标题和发布时间-->
            <c:forEach items="${Page.datas}" var="i"> 
       			<li>
       				<a href='contentURl?id=${i.cate_id}'>${i.title}
     	   			</a><span>${i.pub_date }</span></li>
       		</c:forEach> 
        
       </ul>
       <p align="right"> 当前页数:[${Page.pageNo}/${Page.pageNums}]   <!--当前页号/总页号  -->
       	   <c:if test="${Page.pageNo > 1 }">
       	  &nbsp;<a href="indexURl?pageNo=1&nid=${nid}">首页</a>
       	  &nbsp;<a href="indexURl?pageNo=${Page.pageNo-1}&nid=${nid}">上一页</a> 
       	  </c:if>
       	  <c:if test="${Page.pageNo < Page.pageNums}">      	  
       	  &nbsp;<a href="indexURl?pageNo=${Page.pageNo+1}&nid=${nid}">下一页</a>
       	  &nbsp;<a href="indexURl?pageNo=${Page.pageNums}&nid=${nid}">末页</a>
       	 </c:if>
       	  </p>
       	 
    </div>  
<div class="picnews">
  <ul>
    <li> <a href="#"><img src="images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
    <li> <a href="#"><img src="images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
    <li> <a href="#"><img src="images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
    <li> <a href="#"><img src="images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
  </ul>
</div>
  </div>
</div>
  <div id="friend">
  <h1 class="friend_t"> <img src="images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">百度</a> </li>
      <li> <a href="#">谷歌</a> </li>
      <li> <a href="#">新浪</a> </li>
      <li> <a href="#">网易</a> </li>
      <li> <a href="#">搜狐</a> </li>
      <li> <a href="#">人人</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
    文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    新闻中国 版权所有 </p>
</div>
</body>
</html>
