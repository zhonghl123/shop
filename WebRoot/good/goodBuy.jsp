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
    <input type="hidden" name="good_id" value="${domain.id}"/>
    <table align="center">
        <tr>
            <td><p >产品名：
                <p></td>
            <td>${domain.name}
            </td>
        </tr>
        <tr>
            <td><p >库存：
                <p></td>
            <td>${domain.stock}
            </td>
        </tr>
        <tr>
            <td><p >购买数量：
                <p></td>
            <td>
                <input type="text" name="num" />
            </td>
        </tr>
        <tr>
            <td><p >地址：
                <p></td>
            <td>
                <input type="text" name="address" />
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input name="submit" type="submit" class="btn_pink" size="20 " value="确认购买">
            </td>
        </tr>
    </table>
</form>
</body>
</html>