<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <style>

        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
        }

        a {
            color: #666666;
            font-size: 13px;
            text-decoration: none;
        }

        a:hover {
            font-size: 13px;
            color: red;
            text-decoration: underline;
        }

        .logo {
            font-size: 50px;
            font-family: 隶 书;
            text-align: center;
        }

        .menu {
            text-align: right;
            padding: 10px 0 0 0;
            font-family: 隶 书;
        }

        .menu ul {
        }

        .menu li {
            list-style: none;
            display: inline;
            margin: 0 10px;
        }

        .menu li a {
            padding: 0 10px;
            font-size: 18px;
            color: #7d6d59;
            text-decoration: none;
        }

        .menu li a:hover {
            padding: 0 10px;
            font-size: 18px;
            color: #7d6d59;
            text-decoration: none;
            background: url(images/menuBackground.jpg) repeat-x left top;
        }

        .menu #active a {
            padding: 0 10px;
            font-size: 18px;
            font-family: 宋 体;
            color: #0FA;
            text-decoration: none;
            background: url(images/menuBackground.jpg) repeat-x left top;
        }

        .headerPic {
        }

        #container {
            width: 1024px;
            margin: 0 auto;
        }

        #mainContent {
            clear: both;
        }

        .pBottom {
            background: url(images/pBottom.png) no-repeat left top;
            height: 25px;
            padding: 0 0 20px 0;
        }

        .pBodyTop {
            background: url(images/pBodyTop.jpg) no-repeat left top;
            min-height: 253px;
        }

        .box p {
            padding: 10px 0;
        }

        .box {
            width: 164px;
            float: left;
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

        .box img {
            border: 0;
        }

        .btn {
            text-align: right;
        }

        .clearer {
            clear: both;
            color: #0FA;
            font-family: 隶 书;
        }

        #pw1 {
            font-family: 隶 书;
            font-size: 18px;
        }

        #bottom {
            background-color: #1A1A1A;
            color: #C1C1C1;
            font-family: 'Droid Serif', Arial, sans-serif;
            font-size: 0.925em;
            padding: 20px 0 15px;
            margin-top: 20px;
        }

        .container {
            margin: 0 auto;
            padding: 0;
            position: relative;
            width: 960px;
        }

        #bottom .copyright {
            line-height: 24px;
            text-align: center;
        }

        .lh-wrap {
            width: 260px;
            border: 1px solid #dcdcdc;
            float: left;
            margin-bottom: 20px;
            margin-right: 10px;
            padding: 10px;
        }

        .lh-wrap .p-price strong {
            color: #E4393C;
            float: left;
            font-family: verdana;
            font-size: 14px;
            margin-right: 5px;
        }
        .btns a{
            border: 1px solid #DDDDDD;
            border-radius: 2px;
            color: #333333;
            text-decoration: none;
            padding: 5px;
            cursor: pointer;
        }
        .btns a:hover{
            border: 1px solid #DDDDDD;
            border-radius: 2px;
            color: #333333;
            text-decoration: none;
            padding: 5px;
            cursor: pointer;
        }
    </style>
    <title>主页</title>
</head>
<body>
<div id="container">
    <div id="header">
        <div class="logo">购物网站</div>
        <div style="margin-top: 20px;margin-bottom: 20px;">
            <c:if test="${empty LOGIN_USER}">
                <a href="login.jsp">登陆</a>
                <a href="register.jsp">注册</a>
            </c:if>
            <c:if test="${!empty LOGIN_USER}">
                当前登录用户：${LOGIN_USER.username}
                <a href="${path}/display?method=loginout">退出</a>
                <c:if test="${LOGIN_USER.username=='admin'}">
                    <a href="${path}/display?path=/main.jsp">管理</a>
                </c:if>
            </c:if>
        </div>
    </div>

    <div id="mainContent">
        <div class="pTop"></div>
        <div class="pBody">
           <c:forEach items="${domainList}" var="domain">
               <div class="lh-wrap">
                   <div class="p-img">
                       <a href="href="${path}/display?method=detailGood&id=${domain.id}"" target="_blank"
                          title="${domain.des}">
                           <img width="220" height="220" data-img="1"
                                src="${path}${domain.pic}"
                                class="err-product">
                       </a>

                       <div shop_id="0" class="picon pi2"><b></b></div>
                   </div>
                   <div class="p-name">
                       <a onclick="searchlog(1,1043963,0,1)" target="_blank"
                          title="${domain.des}">${domain.des}
                       </a>
                   </div>
                   <div class="p-price">
                       <em></em><strong class="J_1043963" done="1">￥${domain.price}</strong> <span id="p1043963"></span>
                   </div>
                   <div class="btns">
                       <a href="${path}/display?method=buy&id=${domain.id}">购买</a>
                   </div>
                   <div class="p-phone"></div>
               </div>
           </c:forEach>
        </div>
    </div>
</div>
</div>
<%--<div id="bottom">
    <footer class="container">
        <div class="copyright">Copyright &copy; 2014 by <a href="http://www.lairen.com">来人网</a>. All rights
            reserved.
        </div>
        <!-- Copyright -->
    </footer>
    <!-- End Container -->
</div>--%>
</body>
</html>

