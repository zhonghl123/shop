<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <script language="javascript">
        function check() {
            var pic = document.getElementById("pic");
            var name = document.getElementById("name");
            var note = document.getElementById("note");
            var type = document.getElementById("type");
            var file = document.getElementById("file");
            if (pic.value == "") {
                alert("请输入图片！");
                pic.focus();
                return false;
            } else if (name.value == "") {
                alert("请输入名称！");
                name.focus();
                return false;
            } else if (note.value == "") {
                alert("请输入备注！");
                note.focus();
                return false;
            } else if (type.value == "") {
                alert("请输入类型！");
                type.focus();
                return false;
            } else if (file.value == "") {
                alert("请输入附件！");
                file.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form name="form1" method="post" action="${path}/display?method=addAnime" onsubmit="return check()" enctype="multipart/form-data">
    <table align="center">
        <tr>
            <td><p>图片：

                <p></td>
            <td><input name="pic" type="file" id="pic" size="20">
            </td>
        </tr>
        <tr>
            <td><p>名称：

                <p></td>
            <td><input name="name" type="text" id="name" size="20%">
            </td>
        </tr>
        <tr>
            <td><p>类型：

                <p></td>
            <td>
                 <select name="type" id="type">
                    <c:forEach var="animeClass" items="${animeClassList}">
                          <option value="${animeClass.id}">${animeClass.name}</option>
                    </c:forEach>
                 </select>
            </td>
        </tr>
        <tr>
            <td><p>介绍：

                <p></td>
            <td><input name="note" type="text" id="note" size="20%">
            </td>
        </tr>
        <tr>
            <td><p>附件：

                <p></td>
            <td><input name="file" type="file" id="file" size="20%">
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