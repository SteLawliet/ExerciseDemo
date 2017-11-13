<%--
  Created by IntelliJ IDEA.
  User: zhaoziqi
  Date: 17/11/6
  Time: 下午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${pageContext.request.session.getAttribute("num")}
<br>
<a href="<c:url value='/BServlet?method=TestU'/>">Test</a>
</body>
</html>
