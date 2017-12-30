<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.TopicDao,java.util.*,entity.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>新闻发布系统管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：${name} 登录  &#160;&#160;&#160;&#160; <a href="util/do_logout.jsp"></a></div>
  <div id="channel"> </div>
</div>
<!-- 原生ajax方式 -->
 <!-- <script type="text/javascript">
	//创建XMLHttpRequest对象
	function creatXML() {
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}	
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
	function checkTitle(t){
		//alert(t.value);
		if(t.value=="")  {
			alert("不能为空");
			return;
		}
		var xhr=creatXML();
		 //回调函数
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				var date = xhr.responseText;
				if(date=="true"){
					alert("分类重复了！");	
				}else{
					alert("分类可以使用！");
				}
			}
		}
		//初始化对象
		var url="../AddTitleAjax?name="+t.value;
		//alert(t.value);
		xhr.open("GET",url,true);
		//发送请求
		xhr.send(null); 
	}	
</script>  --> 
  <script type="text/javascript" src="../js/jquery-1.12.4 (1).js"></script>
 <script type="text/javascript"> 
 /*jquery方式2  */
 $(function(){
	 $("#cname").blur(function(){
		 if(this.value=="")
			 {
			    alert("不能为空！");
			 	return;
			 }
		 $.post("../AddTitleAjax",{name:$(this).val()},function(d){
			 if(d=="true") {	
				 alert("重复了！");
				 $(":submit").prop("disabled",true);
			 }else{
				 alert("可以用！");
				 $(":submit").prop("disabled",false);
			 }
		 },"json").error(function(f){alert('查询重复出现错误！');});
	 });
}); 

</script>
</head>
<body> 

<div id="main">
  <div id="opt_list">
  <ul>
    <li><a href="AddNewsURl?name=${name}">添加新闻</a></li>
    <li><a href="adminURl?name=${name}">编辑新闻</a></li>
    <li><a href="add_title.jsp?name=${name}">添加主题</a></li>
    <li><a href="SetTitleURl?name=${name}">编辑主题</a></li>
  </ul>
</div>
	
  <div id="opt_area">
  <form action="../ajax/AddTitleAjax" method="post">
    <ul class="classlist">
       	 
       	   <li>名称：<input type="text" name="name"  id="cname"  /></li>
     
     	
    	 <li>是否置顶:<input type="radio" name="showontop" value="true"   />是
    	       <input type="radio" name="showontop" value="false" />否</li>
    	  <li><input type="submit" value="保存"/> </li>
       	 
	      
	      <li class='space'></li>
	      
    </ul>
    </form>
  </div>
</div>


<!--原生ajax方式  -->
<%--    <div id="opt_area">
    <h1 id="opt_type"> 添加主题： </h1>
    <form action="../ajax/AddTitleAjax?name=${name}"  method="post">
      <input type="text" name="title" value="" onblur="checkTitle(this)"/> 
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>  --%> 


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