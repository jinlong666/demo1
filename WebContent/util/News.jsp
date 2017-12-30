<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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
    <form action="indexURl" method="post" >
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="${param.uname}" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="${param.upwd}" class="login_input" />
      <input type="submit" class="login_sub" value="登录" /><b></b><!-- 这里的注册失败信息应该怎么实现 -->
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
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
<div style="text-align:right;font-size:15px;color:blue"><a href="indexURl">返回首页</a></div> 
  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="classlist"> 
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">${list.title}</td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">作者：${list.author}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             </a></td>
            <td align="left">发布时间：<fmt:formatDate value="${list.pub_date}" pattern="yyyy-MM-dd hh:mm"/></td>
          </tr>                 
          <tr>
            <td colspan="2">${list.content}</td>
          </tr>
          <tr>
            <td colspan="2" align="center"><img src="" width="20%"/></td>
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      
      <!-- 评论 -->
      <ul class="classlist">
        <table width="80%" align="center">
        	<c:if test="${comSize==0}">
        		<td colspan='6'>暂无评论!</td><tr><td colspan='6'><hr /></td></tr>
        	</c:if>
        	<c:forEach items="${comlist}" var="c">
        		<td colspan="6"> 留言人：${c.cauthor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		IP:${c.cip }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;留言时间：<fmt:formatDate value="${c.cdate}" pattern="yyyy-MM-dd hh:mm"/><br/>
        		内容：${c.ccontent }
        	</td>
        	
        	 <tr><td colspan="6"><hr /></td></tr>
        	
        	</c:forEach>        	   
	    </table>
      </ul>
      <ul class="classlist">
        <form action="AddCommentServlet?cnid=${nid}" method="post">
          <table width="80%" align="center">
            <tr>
              <td> 评 论 </td>
            </tr>
            <tr>
              <td> 用户名： </td>
              <td>      
	              <input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下"/> 
                IP：
                <input name="cip" id="cip" value="127.0.0.1" readonly="readonly" style="border:0px;"/>
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" id="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <td><input name="submit" value="发  表" type="submit"/>
              </td>
          </table>
        </form>
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

</html>
