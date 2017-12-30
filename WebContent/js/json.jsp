<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="jquery-1.12.4 (1).js"></script>
</head>
<body>
	  表格：<br/> <div id="objectArrayDiv"> </div><br/>
      
               选项：<select id="url"> </select>
       <script type="text/javascript">
       /* 定义JSON格式的user对象数组，并使用<table>输出 */
	   var userArray = [ {
		"ID" : 1,
		"name" : "admin",
		"url" : "123",
		"pho" : "1839404430"
	    }, {
		"ID" : 2,
		"name" : "詹姆斯",
		"url" : "11111",
		"pho" : "1839393830"
	    }, {
		"ID" : 3,
		"name" : "梅西",
		"url" : "6666",
		"pho" : "1839903090"
	    }, {
		"ID" : 4,
		"name" : "梅西",
		"url" : "6666",
		"pho" : "1839288380"
	    }
	   ];
	   var arg=["中","美","俄"];
		var $table = $("<table border='1'></table>").append( "<tr><td>ID</td><td>姓名</td><td>住址</td><td>手机</td></tr>");
	    $(userArray).each(function() {
	    	$table.append("<tr><td>" + this.ID+ "</td><td>" + this.name + "</td><td>" + this.url + "</td><td>"+ this.pho + "</td></tr>");
	     });
	    $("#objectArrayDiv").append($table);
        $(arg).each(function(){
             var li="<option>"+this+"</option>";
             $("#url").append(li);
        });
        </script>
</body>
</html>