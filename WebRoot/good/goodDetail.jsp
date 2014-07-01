<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
</head>
<body>
<form name="form1" method="post" action="${path}/display?method=addGood" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${domain.id}"/>
    <table align="center">
        <tr>
            <td><p >产品名：
                <p></td>
            <td>${domain.name}
            </td>
        </tr>
        <tr>
            <td><p >厂商：
                <p></td>

            <td>
                <select name="firm" id="firm">
                    ${domain.firmName}
                </select>
            </td>
        </tr>
        <tr>
            <td><p >品牌：
                <p></td>

            <td>
                <select name="brand" id="brand">
                    ${domain.brandName}
                </select>
            </td>
        </tr>
        <tr>
            <td><p >价格：
                <p></td>
            <td>${domain.price}
            </td>
        </tr>
        <tr>
            <td><p >库存：
                <p></td>
            <td>${domain.stock}
            </td>
        </tr>
        <tr>
            <td><p >描述：
                <p></td>
            <td>${domain.des}
            </td>
        </tr>
        <tr>
            <td><p >图片：
                <p></td>
            <td>
                <img width="220" height="220" data-img="1"
                     src="${path}/${domain.pic}"
                     class="err-product">
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