<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
  <style>
body {
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	color: #ffffff;
	background:url(images/2997baaf6e876cc57a62c6019420c655.jpg);
}#logo {
	color:#000080;
	font-size:50px;
	font-family:隶书;
	
}
#container {
	width:1000px;
	margin: 0 auto;
}
#header {
}
#mainContent {

}
.box p {
	padding:10px 0;
}
.box {
	width:450px;
	float:left;
	color:#2A00AA;
	font-size:14px;
}.box1 {
	padding-left:30px;
	
}.box2 {
	padding-left:30px;
}
.box3 {
	padding-left:25px;
}
.box4 {
	padding-left:25px;
}
.box img {
	border:0;
}
.btn {
	text-align:right;
	}
 </style>
    <title>主页</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- begin #container -->
<div id="container">
	<!-- begin #header -->
    <div id="header">
    	<div id="logo">经典完结</div>
        <a href="${path}/display?method=goHome">回到主页</a></div>

   
        		<div class="box box1">
           	    	<img src="images/wanjie.jpg" alt="" width="400" height="200" /><br />
                    <p>
                    	<b>top1</b><br /><br />
                        介绍1 
                    </p>
                    <div class="btn"><a href="${path}/display?method=goHome"><img src="images/未命名_副本.jpg" alt="" width="44" height="21" /></a></div>
                </div>
                <div class="box box2">
           	    	<img src="images/wanjie.jpg" alt="" width="400" height="200"  /><br />
                    <p>
                    	<b>top2</b><br /><br />
                       介绍2 
                    </p>
                    <div class="btn"><a href="${path}/display?method=goHome"><img src="images/未命名_副本.jpg" alt="" width="44" height="21" /></a></div>
                </div>
                <div class="box box3">
           	    	<img src="images/wanjie.jpg" alt="" width="400" height="200" " /><br />
                    <p>
                    	<b>top3</b><br /><br />
                        介绍3
                    </p>
                    <div class="btn"><a href="${path}/display?method=goHome"><img src="images/未命名_副本.jpg" alt="" width="44" height="21" /></a></div>
                </div>
                <div class="box box4">
           	    	<img src="images/wanjie.jpg" alt="" width="400" height="200" /><br />
                    <p>
                    	<b>top4</b><br /><br />
                        介绍4
                    </p>
                    <div class="btn"><a href="${path}/display?method=goHome"><img src="images/未命名_副本.jpg" alt="" width="44" height="21" /></a></div>
                </div>
 
                
            </div>
            </div>
        </div>
        
        
</body>
</html>