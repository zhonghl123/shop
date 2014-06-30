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
            font-size: 18px;
            font-family: 隶 书;
        }
    </style>
    <title>register.jsp</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

</head>

<body>
<form name="form2" action="${path}/display?method=register" method="post" onsubmit="return checkSubmit()">
    <table align="center">
        <tr class="title">
            <td colspan="2"><b><p id="first">注册
                <p></b></td>
        <tr>
            <td><a href="${path}/display?method=goHome">→回到主页</a></td>
        </tr>
        </tr>
        <tr>
            <td><p  name="name">用户名：

                <p></td>
            <td><input name="userName" type="text" id="userid" size="20">
            </td>
        </tr>
        <tr>
            <td><p  name="password">密码：

                <p></td>
            <td><input name="userpwd" type="password" id="userpwd" size="20">
            </td>
        </tr>
        <tr>
            <td><p >重复密码：

                <p></td>
            <td><input name="userpwdok" type="password" id="userpwdok" size="20">
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input type="submit" name="sm" value="确定注册" class="btn">
            </td>
        </tr>
    </table>
</form>
</body>
</html>