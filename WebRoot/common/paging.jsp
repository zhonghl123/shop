<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
    function gotoSelectedPage(pageNumberValue)
    {
        var x = document.getElementById("searchForm");
        var myinput=createElement("input","pageNumber");
        myinput.type="hidden";
        myinput.id="pageNumber";
        myinput.value=pageNumberValue;
        x.appendChild(myinput);
        x.submit();
    }
    function createElement(type, name) {
        var element = null;
        try {
// First try the IE way; if this fails then use the standard way
            element = document.createElement('<'+type+' name="'+name+'">');
        } catch (e) {
// Probably failed because we're not running on IE
        }
        if (!element) {
            element = document.createElement(type);
            element.name = name;
        }
        return element;
    }


</script>
    <a href="javascript:gotoSelectedPage('1');">首页</a>
    <c:if test="${pageNumber>1}">
        <a href="javascript:gotoSelectedPage('${pageNumber-1}');">上一页</a>
    </c:if>
 <%--   跳转到第 <select name="pageNumber" onchange="gotoSelectedPage();">
    <c:forEach begin="1" end="${totalPages}" step="1" var="pageIndex">
        <c:choose>
            <c:when test="${pageIndex eq pageNumber}">
                <option value="${pageIndex}" selected="selected">${pageIndex}</option>
            </c:when>
            <c:otherwise>
                <option value="${pageIndex}">${pageIndex}</option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>页--%>
    <c:if test="${pageNumber<totalPages}">
        <a href="javascript:gotoSelectedPage('${pageNumber+1}');">下一页</a>
    </c:if>
    <a href="javascript:gotoSelectedPage('${totalPages}');">末页</a>
