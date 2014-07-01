<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <style type="text/css">
        .site-nav .iconfont {
            font-family: global-iconfont;
            font-size: 12px;
            font-style: normal;
        }

        .site-nav {
            background: none repeat scroll 0 0 #F5F5F5;
            border-bottom: 1px solid #EEEEEE;
            width: 100%;
            z-index: 10000;
        }

        .site-nav:after {
            clear: both;
            content: "";
            display: table;
        }

        .site-nav .site-nav-bd {
            background: none repeat scroll 0 0 #F5F5F5;
            height: 35px;
            margin: 0 auto;
            width: 990px;
        }

        .site-nav .site-nav-bd:after {
            clear: both;
            content: "";
            display: table;
        }

        .menu-hd {
            height: 35px;
            line-height: 35px;
            overflow: hidden;
            padding: 0 6px;
            position: relative;
            z-index: 10002;
            float: right;
        }
        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
        }
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
<div class="site-nav" id="J_SiteNav">
    <div class="site-nav-bd" id="J_SiteNavBd">
        <div class="menu-hd">
            <c:if test="${empty LOGIN_USER}">
                <a href="login.jsp">登陆</a>
                <a href="register.jsp">注册</a>
            </c:if>
            <c:if test="${!empty LOGIN_USER}">
                当前登录用户：${LOGIN_USER.username}
                <a href="${path}/display?method=loginout">退出</a>
                <c:if test="${LOGIN_USER.username=='admin'}">
                    <a href="${path}/display?path=/main.jsp">管理</a>
                </c:if>
            </c:if>
        </div>
    </div>
</div>

<form name="form1" method="post"  action="${path}/display?method=addBuy">
    <input type="hidden" name="good_id" value="${domain.id}"/>
    <table class="table-add">
        <tr>
            <td><p >产品名
                <p></td>
            <td class="tabRight">${domain.name}
            </td>
        </tr>
        <tr>
            <td><p >库存：
                <p></td>
            <td class="tabRight">${domain.stock}
            </td>
        </tr>
        <tr>
            <td><p >购买数量：
                <p></td>
            <td class="tabRight">
                <input type="text" name="num" />
            </td>
        </tr>
        <tr>
            <td><p >地址：
                <p></td>
            <td class="tabRight">
                <input type="text" name="address" />
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td class="tabRight">
                <input name="submit" type="submit" class="btn_pink" size="20 " value="确认购买">
            </td>
        </tr>
    </table>
</form>
</body>
</html>