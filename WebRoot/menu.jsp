<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>nav</title>
    <script language="javascript">
        // JavaScript Document

        startList = function () {
            if (document.all && document.getElementById) {
                navRoot = document.getElementById("nav");
                for (i = 0; i < navRoot.childNodes.length; i++) {
                    node = navRoot.childNodes[i];
                    if (node.nodeName == "LI") {
                        node.onmouseover = function () {
                            this.className += " over";
                        }
                        node.onmouseout = function () {
                            this.className = this.className.replace(" over", "");
                        }
                    }
                }
            }
        }
        window.onload = startList;
    </script>
    <style type="text/css">
        <!--
        body {
            font: normal 11px verdana;
        }

        ul {
            margin: 0;
            padding: 0;
            list-style: none;
            width: 190px; /* Width of Menu Items */
            border-bottom: 1px solid #ccc;
        }

        ul li {
            position: relative;
        }

        li ul {
            position: absolute;
            left: 149px; /* Set 1px less than menu width */
            top: 0;
            display: none;
        }

            /* Styles for Menu Items */
        ul li a {
            display: block;
            text-decoration: none;
            color: #777;
            background: #fff; /* IE6 Bug */
            padding: 5px;
            border: 1px solid #ccc; /* IE6 Bug */
            border-bottom: 0;
            font-size: 14px;
        }

            /* Holly Hack. IE Requirement \*/
        * html ul li {
            float: left;
            height: 1%;
        }

        * html ul li a {
            height: 1%;
        }

            /* End */

        li:hover ul, li.over ul {
            display: block;
        }

            /* The magic */
        -->
    </style>
</head>

<body>
<ul id="nav">
    <li><a href="${path}/display?method=firmMain" target="mainFrame">厂商管理</a>
    </li>
    <li><a href="${path}/display?method=brandMain" target="mainFrame">品牌管理</a>
    </li>
    <li><a href="${path}/display?method=goodMain" target="mainFrame">产品管理</a>
    </li>
</ul>
</body>
</html> 