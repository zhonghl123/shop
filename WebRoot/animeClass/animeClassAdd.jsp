<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <script language="javascript">
        function check() {
            var name = document.getElementById("name");
            if (name.value == "") {
                alert("请输入分类名！");
                name.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form name="form1" method="post" action="${path}/display?method=addAnimeClass" onsubmit="return check()">
    <table align="center">
        <tr>
            <td><p >分类名：
                <p></td>
            <td><input name="name" type="text" id="name" size="20">
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