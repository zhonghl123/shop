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
        .img-size{
            width: 100px;
            height: 75px;
        }
    </style>
    <script type="text/javascript">
        function del(id){
            if(confirm("确认删除么？")) {
                window.location.href="${path}/display?method=delAnime&id="+id;
            }
        }
        function detail(id){
            window.location.href="${path}/display?method=detailAnime&id="+id;
        }
    </script>
</head>
<body>
<table id="tb">
    <caption style="text-align: left;">
        <input type="button" value="添加" onclick="javascript:window.location.href='${path}/display?method=addUIAnime'">
    </caption>
    <tr>
        <th>图片</th>
        <th>名称</th>
        <th>分类</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    <c:forEach var="domain" items="${domainList}">
        <tr>
            <td>
                <div class="thumbwrapper img-size">
                    <img class="img-size" src="${path}/${domain.pic}">
                </div>
            </td>
            <td>${domain.name}</td>
            <td>${domain.animeClassName}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${domain.createTime}"></fmt:formatDate></td>
            <td>
                <a href="javascript:del('${domain.id}')">删除</a>
             <%--   <a href="javascript:detail('${domain.id}')">详情</a>--%>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>