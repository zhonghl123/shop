<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
            color: #ffffff;
            background: url(images/2997baaf6e876cc57a62c6019420c655.jpg) repeat-x left top;
        }

        #logo {
            color: #334BD7;
            font-size: 50px;
            font-family: 隶 书;
            background-image: url(db4580c925ab3f82c1c13667034f3340.jpeg);
        }

        #container {
            width: 800px;
            margin: 0 auto;
        }

        #header {
        }

        #mainContent {

        }

        .box p {
            padding: 10px 0;
        }

        .box {
            width: 164px;
            float: left;
            color: #2A0055;
            font-size: 16px;
        }

        .box1 {
            padding-left: 30px;

        }

        .box2 {
            padding-left: 30px;
        }

        .box3 {
            padding-left: 25px;
        }

        .box4 {
            padding-left: 25px;
        }

        .box5 {
            padding-left: 30px;
        }

        .box6 {
            padding-left: 30px;
        }

        .box7 {
            padding-left: 25px;
        }

        .box8 {
            padding-left: 25px;
        }

        .box img {
            border: 0;
        }

        .btn {
            text-align: right;
        }
    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- TemplateBeginEditable name="doctitle" -->
    <title>主页</title>
    <link href="styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<!-- begin #container -->
<div id="container">
    <!-- begin #header -->
    <div id="header">
        <div id="logo">动漫新番</div>
        <a href="${path}/display?method=goHome">回到主页</a>

        <div id="mainContent">
            <c:forEach var="domain" items="${animeList}">
                <div class="box box1">
                    <img src="${path}/${domain.pic}" alt="" width="150" height="200"/><br/>
                    <p>
                            ${domain.note}
                    </p>
                    <div class="btn"><a href="${path}/display?method=goHome"><img src="images/btn.png" alt="" width="44" height="21"/></a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
