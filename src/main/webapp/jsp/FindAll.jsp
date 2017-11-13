<%--
  Created by IntelliJ IDEA.
  User: zhaoziqi
  Date: 17/11/6
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table,th,td{
            border: 1px;

        }
        td input{
            border: none;
            width: 100%;
        }
        input{
            height: auto;
            font-size: 125%;
        }
    </style>
</head>
<body>
<table width="60%"  align="center" cellpadding="10px" cellspacing="0" border="1">
    <tr bgcolor="#5f9ea0">
        <th>uid</th>
        <th>username</th>
        <th>password</th>
        <th>operation</th>
        <th>editor</th>
    </tr>
    <c:forEach items="${pageContext.session.getAttribute('UserList')}" var="user" >
        <form action="<c:url value='/BServlet'/>" method="post">
        <input type="hidden" name="method" value="Update">
        <tr>
            <td> <input  type="text" name="uid" value="${user.uid}" readonly="readonly"></td>
            <td>
                <input type="text" name="username" value="${user.username}">
                    <%--<c:out value="${user.username}"/>--%>

            </td>
            <td>
                <input type="text" name="password" value="${user.password}">
                    <%--<c:out value="${user.password}"/>--%>
            </td>
            <td>
                <a href="<c:url value='/BServlet?method=DeleteUser&username=${user.username}'/>">
                    del
                </a>
            </td>
            <td>
                <%--<a href="<c:url value='/BServlet?method=Update'/>">--%>
                    <%--&username=${user.username}&username=${user.password}--%>

                <%--</a>--%>
                <input type="submit" value="editor">
            </td>
        </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
