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
    <title>log.jsp</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>

<body>
<form name="form1" method="post" action="${path}/display?method=login" onsubmit="return check()">
    <fieldset class="fieldset">
        <legend class="legend">登录</legend>
        <table >
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
    </fieldset>
</form>
</body>
</html>