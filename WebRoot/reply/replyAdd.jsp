<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <script language="javascript">
        function check() {
            var name = document.getElementById("content");
            if (name.value == "") {
                alert("请输入内容！");
                name.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form name="form1" method="post" action="${path}/display?method=addReply" onsubmit="return check()">
    <table align="center">
        <tr>
            <td><p >内容：
                <p></td>
            <td><input name="content"   id="content" type="text"  size="20">
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input name="submit" type="submit" class="btn_pink" size="20 " value="确定">
            </td>
        </tr>
    </table>
    <input type="hidden" name="animeId" value="${animeId}"/>
    <input type="hidden" name="commentId" value="${commentId}"/>
</form>
</body>
</html>