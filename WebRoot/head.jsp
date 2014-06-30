<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <style type="text/css">
        .logo {
            color: #6FF;
            font-size: 50px;
            font-family: 隶 书;
            background-color: #000000;
        }
    </style>
</head>
<body>
<div class="logo">
    购物网站
    <a href="javascript:top.window.location.href='${path}/display?method=goHome'">回到首页</a>
</div>
</body>
</html>