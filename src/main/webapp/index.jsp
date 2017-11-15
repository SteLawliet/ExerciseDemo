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
    <title>$Title$</title>
    <script type="text/javascript">
        var username = document.getElementById("username");
        username.onchange = function () {
            var request = new XMLHttpRequest();
            request.open("POST", "<c:url value='/BServlet'/>", true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            //"Content-Type", "application/x-www-form-urlencoded"
            request.send("method=SelectByName&" + username.value);
            alert(username.value);
            var text = request.responseText;
        }
    </script>
</head>
<body>
Sky.hello word every one
<p>
    <a href="<c:url value='/BServlet?method=FindAll'/>">AServlet</a>
</p>

<div align="center">
    <p id="msg" style="color: cadetblue">${msg}</p>
<form action="<c:url value='/BServlet'/>" method="get">
    <input type="hidden" name="method" value="Add" id="username">
    username:<label id="l">
    <input type="text" name="username">
</label><br>
    password:<label>
    <input type="text" name="password">
</label><br>
    <input type="submit" value="Add">
</form>
</div>
<jsp:include page="/jsp/FindAll.jsp"/>

<p><a href="<c:url value='jsp/Test.jsp'/>">Test.jsp</a></p>
<br>
<%--tsetgit--%>
<!--ss-->
</body>
</html>