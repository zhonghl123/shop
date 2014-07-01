<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <style>
        table{
            margin-left:20px;
        }
        /** 重设-fieldset**/
        .fieldset {
            padding: 0;
            margin: 0;
            border: 0;
        }

        .legend {
            display: block;
            width: 100%;
            padding: 0;
            margin-bottom: 27px;
            font-size: 19.5px;
            font-weight: bold;
            line-height: 36px;
            color: #333333;
            border: 0;
            border-bottom: 1px solid #A3C0E8;
        }

    </style>
    <title>register.jsp</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

</head>

<body>
<form name="form2" action="${path}/display?method=register" method="post" onsubmit="return checkSubmit()">
    <fieldset class="fieldset">
        <legend class="legend">注册</legend>
        <table align="center">
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
    </fieldset>
</form>
</body>
</html>