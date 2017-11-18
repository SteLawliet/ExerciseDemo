<%--
  Created by IntelliJ IDEA.
  User: zhaoziqi
  Date: 17/10/19
  Time: 下午4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false"%>
<html>
<head>

    <title>Title</title>
    <link href="./jsp/github.css" rel="stylesheet"/>
    <style type="text/css">
        #div1 {
            width: 75%;
            height: auto;
            margin: 0 28%;
        }
    </style>
    <script type="text/javascript">
        window.onload = function () {
            var username = document.getElementById("username");
            username.onchange = function () {
                var request = new XMLHttpRequest();
                request.open("POST", "<c:url value='/BServlet'/>", true);
                request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                //"Content-Type", "application/x-www-form-urlencoded"
                request.send("method=SelectByName&username=" + username.value);
                request.onreadystatechange = function () {
                    var text = request.responseText;
                    var msg = document.getElementById("msg");
                    msg.innerHTML = text;
                }
            }
        }
    </script>
</head>
<body>
<%--<div align="center">--%>
<div id="div1">
    <%--<p id="msg" style="color: cadetblue">&nbsp;${msg}</p>--%>
<form action="<c:url value='/BServlet'/>" method="get">
    <input type="hidden" name="method" value="Add" align="left">
    username:<label id="l">
    <input type="text" name="username" id="username" size="20"> <a id="msg"
                                                                   style="color: cadetblue">&nbsp;${msg}</a>
</label><br>
    password:<label>
    <input type="text" name="password" size="20" align="left">
</label><br>
    <input type="submit" value="Add">
</form>
</div>
<jsp:include page="/jsp/FindAll.jsp"/>

<p><a href="<c:url value='/BServlet?method=FindAll'/>">AServlet</a>&nbsp;&nbsp;<a
        href="<c:url value='jsp/Test.jsp'/>">Test.jsp</a></p>
<br>
<%--tsetgit--%>
<!--ss-->
</body>
</html>