<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>鼠标划过表格行变色－简洁实现</title>
    <style type="text/css">
        table {
            width: 100%;
            font-size: 14px;
        }

        #tb {
            width: 666px;
            border-collapse: collapse;
            border: 1px solid #EEE;
            font-size: 14px;
        }

        #tb th {
            background: #EEE;
            border-bottom: 1px solid #CCC;
            padding: 4px;
        }

        #tb td {
            border: 1px solid #EEE;
            padding: 4px;
        }
    </style>
    <script type="text/javascript">
        function del(id) {
            if (confirm("确认删除么？"))
                window.location.href = "${path}/display?method=delUser&id=" + id;
        }
    </script>
</head>
<body>
<form id="searchForm" action="${path}/display?method=userMain" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${username}"/></td>
            <td>身份证号：</td>
            <td><input type="text" name="idname" value="${idname}"/></td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center;"><input type="submit" value="查询"/></td>
        </tr>
    </table>
</form>
<table id="tb">
    <caption style="text-align: left;">
        <input type="button" value="添加"
               onclick="javascript:window.location.href='${path}/display?path=user/userAdd.jsp'">
    </caption>
    <tr>
        <th>用户名</th>
        <th>身份证号</th>
        <th>操作</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.username}</td>
            <td>${user.idname}</td>
            <td>
                <a href="javascript:del('${user.username}')">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tfoot>
    <tr align="center">
        <td colspan="5">
            <jsp:include page="/common/paging.jsp"></jsp:include>
        </td>
    </tr>
    </tfoot>

</table>
</body>
</html>