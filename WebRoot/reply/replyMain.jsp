<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>鼠标划过表格行变色－简洁实现</title>
    <style type="text/css">
        table{
            width:100%;
            font-size:14px;
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
</head>
<body>
<table id="tb">
    <tr>
        <th>录入人</th>
        <th>创建时间</th>
        <th>内容</th>
    </tr>
    <c:forEach var="domain" items="${domainList}">
        <tr>
            <td>${domain.inputer}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${domain.createTime}"></fmt:formatDate></td>
            <td>${domain.content}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>