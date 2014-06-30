<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 100%;
            height:500px;
        }

        .box p {
            padding: 10px 0;
        }

        .box {
            width: 100px;
            height: 75px;
            float: left;
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
        <div id="logo"></div>
        <a href="${path}/display?method=goHome">回到主页</a>

        <div id="mainContent">
                <div class="box">
                    <img src="${path}/${anime.pic}" alt="" width="150" height="200"/><br/>
                    <p>
                            ${anime.note}
                    </p>
                    <div class="btn">
                        <a href="${path}/display?method=download&conPath=${anime.file}">下载</a>
                        <c:if test="${!empty LOGIN_USER}">
                            <a href="${path}/display?method=addUIComment&id=${anime.id}">添加评论</a>
                        </c:if>

                    </div>
                </div>
        </div>
        <div >
            <c:forEach var="comment" items="${commentList}">
                     <div>
                        ${comment.content}
                     </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
