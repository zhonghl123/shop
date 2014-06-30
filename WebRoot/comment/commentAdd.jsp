<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>register.jsp</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="./styles.css">
    <script language="javascript">

        function checkSubmit() {
            if (document.getElementById("content").value == "") {
                document.getElementById("content").focus();
                alert("内容不能为空！");
                return false;
            }
        }
    </script>
</head>

<body>
<form name="form2" action="${path}/display?method=addComment" method="post" onsubmit="return checkSubmit()">
    <table align="center">
        <tr class="title"><br></br><br></br><br></br><br></br>
            <td colspan="2"><b><p id="first">添加评论页面
                <p></b></td>
        <tr>
            <td><a href="${path}/display?method=goHome">回到主页</a></td>
        </tr>
        </tr>
        <tr>
            <td><p id="second">内容：
                <p></td>
            <td><textarea name="content" id="content" rows="10" cols="60"></textarea>
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input name="Button" type="submit" class="btn_pink" size="20 " value="提交">
            </td>
        </tr>
        <input type="hidden" name="id" value="${id}"/>
    </table>
</form>
</body>
</html>
