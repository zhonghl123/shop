<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-image: url(images/2997baaf6e876cc57a62c6019420c655.jpg);
            no-repeat-x center -100px;
            background-color: #CCFF66;
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
    <title>forget.jsp</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="./styles.css">
    <script language="javascript">
        function check1() {
            if (document.getElementById('userid').value == "") {
                document.getElementById('userid').focus();
                alert("用户名不能为空！");
                return false;
            }
            if (document.getElementById('number').value == "") {
                document.getElementById('number').focus();
                alert("身份证号 不能为空！");
                return false;
            }
            if (document.getElementById('userpwd').value == "") {
                document.getElementById('userpwd').focus();
                alert("新密码不能为空！");
                return false;
            }
            if (document.getElementById('userpwdok').value != document.getElementById('userpwd').value) {
                document.getElementById('userpwdok').focus();
                alert("两次密码不一致！");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<form name="form2" action="${path}/display?method=resetPassword" method="post" onsubmit="return check1()">
    <table align="center">
        <tr class="title"><br></br><br></br><br></br><br></br>
            <td colspan="2"><b><p id="first">动漫资源网忘记密码页面

                <p></b></td>
        <tr>
            <td><a href="${path}/display?method=goHome">→回到主页</a></td>
        </tr>
        </tr>
        <tr>
            <td><p id="second">用户名：

                <p></td>
            <td><input name="userName" type="text" id="userid" size="20">
            </td>
        </tr>
        <tr>
            <td><p id="second">身份证号：

                <p></td>
            <td><input name="number" type="text" id="number" size="20">
            </td>
        </tr>
        <tr>
            <td><p id="second">请输入新密码：

                <p></td>
            <td><input name="userpwd" type="password" id="userpwd" size="20">


        </tr>
        <tr>
        <tr>
            <td><p id="second">请重新输入新密码：

                <p></td>
            <td><input name="userpwdok" type="password" id="userpwdok" size="20">

        </tr>
        <tr>

            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input name="sm" type="submit" value="修改密码">
            </td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    var error = '${error}';
    if (error) {
        alert("用户输入错误");
    }
</script>
</html>
