<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <script language="JavaScript" type="text/JavaScript">
        function MM_reloadPage(init) { //reloads the window if Nav4 resized
            if (init == true)
                with (navigator) {
                    if ((appName == "Netscape") && (parseInt(appVersion) == 4)) {
                        document.MM_pgW = innerWidth;
                        document.MM_pgH = innerHeight;
                        onresize = MM_reloadPage;
                    }
                }
            else if (innerWidth != document.MM_pgW
                    || innerHeight != document.MM_pgH)
                location.reload();
        }
        MM_reloadPage(true);

        //----------
        top.main = document.getElementById("main");
        top.viewArea = document.getElementById("viewArea");
    </script>
</head>
<frameset rows="64,*" cols="*" framespacing="0" frameborder="no"	border="0" name="iman" id="IID_SecureWeb_Support">
    <frame src="${path}/head.jsp" name="headFrame"	id="headFrame" frameborder="no" scrolling="NO" noresize marginwidth="0" marginheight="0">
    <frameset name="main" id="main" rows="*" cols="196,*" framespacing="0" frameborder="NO" border="0">
        <frameset rows="*" cols="190,6" framespacing="0" frameborder="no" border="0" name="viewArea" id="viewArea">
            <frame src="${path}/menu.jsp" name="menuFrame"  id="menuFrame"  frameborder="no" marginwidth="0" marginheight="0" scrolling="no">
        </frameset>
        <c:if test="${!empty LOGIN_USER}">
            <c:if test="${LOGIN_USER.username=='admin'}">
                <frame src="${path}/display?method=userMain" name="mainFrame"	id="mainFrame" scrolling="NO" noresize>
            </c:if>
            <c:if test="${LOGIN_USER.username!='admin'}">
                <frame src="${path}/display?method=animeMain" name="mainFrame"	id="mainFrame" scrolling="NO" noresize>
            </c:if>
        </c:if>
    </frameset>
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>