<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />

    <style type="text/css">
        /** 组件-表格样式**/
        .table-add {
            table-layout: fixed;
            width: 100%;
            margin-bottom: 6px;
            padding: 0 1px 1px 0;
            border-spacing: 0;
            border-collapse: separate;
            border-color: #ABB8CE;
            background: #EDEDED;
            border-top: 1px solid #ABB8CE;
            border-left: 1px solid #ABB8CE;
        }

        .table-add td {
            border-color: #F8F8F8 #ABB8CE #ABB8CE #F8F8F8;
            background: #E0E8F5;
            padding: 4px;
            text-align: right;
            vertical-align: top;
            border-width: 1px;
            border-style: solid;
            margin: 0;
        }

        .table-add .tabRight {
            padding: 5px 4px;
            font-weight: bold;
            text-align: left;
            text-shadow: 1px 1px 0 #E4EDFB;
            vertical-align: middle;
            background: #D0DBEE;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<form name="form1" method="post" action="${path}/display?method=addGood" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${domain.id}"/>
    <table align="center" class="table-add">
        <tr>
            <td><p >产品名：
                <p></td>
            <td class="tabRight">${domain.name}
            </td>
        </tr>
        <tr>
            <td><p >厂商：
                <p></td>

            <td  class="tabRight">
                <select name="firm" id="firm">
                    ${domain.firmName}
                </select>
            </td>
        </tr>
        <tr>
            <td><p >品牌：
                <p></td>

            <td  class="tabRight">
                <select name="brand" id="brand">
                    ${domain.brandName}
                </select>
            </td>
        </tr>
        <tr>
            <td><p >价格：
                <p></td>
            <td  class="tabRight">${domain.price}
            </td>
        </tr>
        <tr>
            <td><p >库存：
                <p></td>
            <td  class="tabRight">${domain.stock}
            </td>
        </tr>
        <tr>
            <td><p >描述：
                <p></td>
            <td  class="tabRight">${domain.des}
            </td>
        </tr>
        <tr>
            <td><p >图片：
                <p></td>
            <td  class="tabRight">
                <img width="220" height="220" data-img="1"
                     src="${path}/${domain.pic}"
                     class="err-product">
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>
                <input type="button" onclick="javascript:window.location.href='${path}/display?method=goHome'" class="btn_pink" size="20 " value="返回首页">
            </td>
        </tr>
    </table>
</form>
</body>
</html>