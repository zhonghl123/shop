<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            no-repeat-x center -100px;
            font-family: 楷 体;
        }

        #first {
            font-size: 36px;
            font-family: 楷 体;

        }

        #second {
            font-size: 24px;
            font-family: 隶 书;
        }

    </style>
    <title>log.jsp</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>

<body>
<form name="form1" method="post" action="${path}/display?method=login" onsubmit="return check()">
    <table align="center">
        <tr class="title">
            <td colspan="2"><b><p id="first">登录
                <p></b></td>
        <tr>
            <td><a href="${path}/display?method=goHome">→回到主页</a></td>
        </tr>
        </tr>
        <tr>
            <td><p id="second">用户名：
                <p></td>
            <td><input name="user" type="text" id="user" size="20">
            </td>
        </tr>
        <tr>
            <td><p id="second">密码：
                <p></td>
            <td><input name="pwd" type="text" id="pwd" size="20%">
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input name="submit" type="submit" class="btn_pink" size="20 " value="确定">
            </td>
        </tr>
    </table>
</form>
</body>
</html>