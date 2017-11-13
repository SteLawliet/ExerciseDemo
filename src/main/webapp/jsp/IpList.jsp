<%--
  Created by IntelliJ IDEA.
  User: zhaoziqi
  Date: 17/11/10
  Time: 下午1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table width="60%" align="center" cellpadding="10px" cellspacing="0" border="1px">
    <tr>
    <c:forEach var="e" items="${applicationScope.map}">
            <th><c:out value="${e.key}"/></th>
    </c:forEach>
    </tr>
    <tr>
    <c:forEach var="e" items="${applicationScope.map}">
            <td><c:out value="${e.value}"/></td>
    </c:forEach>
    </tr>
</table>
</body>
</html>
