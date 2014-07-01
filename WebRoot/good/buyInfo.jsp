<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
</head>
<body>
<form name="form1" method="post" action="${path}/display?method=addBuy">
    <input type="hidden" name="id" value="${domain.id}"/>
    <table align="center">
        <tr>
            <td><p >总价：
                <p></td>
            <td>${totalPrice}
            </td>
        </tr>
        <tr>
            <td><p >付款方式：
                <p></td>
            <td>货到付款
            </td>
        </tr>
        <tr>
            <td colspan="3"><p >
                 <input type="button" value="继续购买" onclick="javascript:window.location.href='${path}/display?method=goHome'"/>
                <p></td>

        </tr>
    </table>
</form>
</body>
</html>