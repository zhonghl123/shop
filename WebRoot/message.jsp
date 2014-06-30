<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
  <head>
  <style>
 body{
  background-image:url(images/2997baaf6e876cc57a62c6019420c655.jpg);
  no-repeat-x center -100px;
  background-color: #CCFF66;
  font-family:楷体;
  }#first{
  	font-size:36px;
  	font-family:楷体;
  }#second{
  font-size:18px;
  font-family:隶书;
 }
  </style>
<title>register.jsp</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
   <link rel="stylesheet" type="text/css" href="./styles.css">
   <script language="javascript">
 
function checkSubmit()
{
if(document.form2.userid.value=="")
{
 document.form2.userid.focus();
 alert("用户名不能为空！");
 return false;
}
if(document.form2.biaoti.value=="")
{
 document.form2.biaoti.focus();
 alert("标题不能为空！");
 return false;

}
if(document.form2.intro.value=="")
{
 document.form2.intro.focus();
 alert("请输入 留言内容！");
 return false;
}

}

</script>
</head>

<body>
	<form name="form2" action="" method="post" >
    <table align="center">
				<tr class="title"><br></br><br></br><br></br><br></br>
				<td colspan="2"><b>
				    <p id="first">留言页面<p></b></td>
               <tr>  <td><a href="${path}/display?method=goHome">回到主页</a></td></tr>
                 
			</tr>
              <tr>
				<td ><p id="second">用户名：<p></td>
				<td ><input name ="userName" type="text" id="userid"  size="20">
				</td>
				</tr>
				<tr>
				<td ><p id="second">标题：<p></td>
				<td ><input name ="biaoti" type="text" id="biaoti"  size="40">
				</td>
				</tr>
				<tr>
				<td ><p id="second">内容：<p></td>
				<td ><textarea name="intro" rows="10" cols="60"></textarea>
				</td>
				</tr>
                
				
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
    	<input name="Button" type="button"  class="btn_pink" size="20 "value="提交" onclick="checkSubmit()">
    	</td>
				
</form>
	</body>
</html>