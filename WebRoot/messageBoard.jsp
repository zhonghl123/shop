<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" />
<title>column-rule-style_CSS参考手册_web前端开发参考手册系列</title>
<meta name="author" content="Joy Du(飘零雾雨), dooyoe@gmail.com" />
<meta name="copyright" content="www.doyoe.com" />
<style>
body{
font:14px/3 georgia,serif,sans-serif;
background:url(images/2997baaf6e876cc57a62c6019420c655.jpg)}
p{margin:0;padding:5px 10px;background:#eee;}
h1{margin:10px 0;font-size:16px;}
h2{font-size:30px;
	color:#2A00AA;
	font-family:隶书;}
div{
	width:60% ;
	height:80;
	border:2px solid #000;
	-moz-column-count:3;
	-moz-column-gap:20px;
	-moz-column-rule-width:3px;
	-webkit-column-count:3;
	-webkit-column-gap:50px;
	-webkit-column-rule-width:3px;
	column-count:3;
	column-gap:20px;
	column-rule-width:3px;
}
.test{
	-moz-column-rule-style:none;
	-webkit-column-rule-style:none;
	column-rule-style:none;
}.btn {
	text-align:right;
}
</style>
</head>
<body>
 <h2>留言板</h2>
<a href="message.jsp">→我要留言</a>
<a href="${path}/display?method=goHome">→返回主页</a>
<div class="test"><h1>1</h1>留言</div>

<h1>   </h1>
<div class="test"><h1>2</h1>留言</div>

<h1>   </h1>
<div class="test">
  <h1>3</h1>留言</div>

<h1>   </h1>
<div class="test">
  <h1>4</h1>留言</div>


<h1>   </h1>
<div class="test">
  <h1>5</h1>留言</div>

<h1>   </h1>
<div class="test">
  <h1>6</h1>留言</div>

<h1>   </h1>
<div class="test">
  <h1>7</h1>留言</div>

<a href="addReview.jsp">→→添加评论</a>
</body>
</html>
		