<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <script language="javascript">
        function check() {
            var username = document.getElementById("username");
            var password = document.getElementById("password");
            var idname = document.getElementById("idname");
            if (username.value == "") {
                alert("请输入用户名！");
                username.focus();
                return false;
            } else if (password.value == "") {
                alert("请输入密码！");
                password.focus();
                return false;
            } else if (idname.value == "") {
                alert("请输入身份证号！");
                idname.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form name="form1" method="post" action="${path}/display?method=addUser" onsubmit="return check()">
    <table align="center">
        <tr>
            <td><p >用户名：
                <p></td>
            <td><input name="username" type="text" id="username" size="20">
            </td>
        </tr>
        <tr>
            <td><p >密码：
                <p></td>
            <td><input name="password" type="text" id="password" size="20%">
            </td>
        </tr>
        <tr>
            <td><p >身份证号：
                <p></td>
            <td><input name="idname" type="text" id="idname" size="20%">
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
<c:if test="${!empty userexsit}">
<script type="text/javascript">
    alert("用户名已经存在，请更换其他用户名");
</script>
</c:if>
</body>
</html>