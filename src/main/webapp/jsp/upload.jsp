<%--
  Created by IntelliJ IDEA.
  User: zhaoziqi
  Date: 17/12/17
  Time: 上午12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>uploadFile</title>
    <style>
        table, tr, td {
            border: 1px solid #000;
            border-collapse: collapse;

        }

        td {
            padding: 10px;
        }

        table {
            margin: 10% auto;
            width: 75%;
        }

        tr {
            background-color: rgba(187, 232, 246, 0.33);
        }

        tr:nth-child(1) {
            background-color: #6d8691;
        }


    </style>
    <script src="js/jquery-3.2.js"></script>
    <script>
        jQuery(function () {
            jQuery('input[type=submit]').click(function () {
                return confirm("upload the files?")
            });
        });
    </script>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>filename</td>
        <td>size</td>
        <td>type</td>
        <td>update</td>
        <td>path</td>
    </tr>
    <c:forEach items="${filelist}" var="varFile" varStatus="varSta">
        <tr>
            <td>${varSta.count }</td>
            <td>${varFile.name }</td>
            <td>${varFile.size}</td>
            <td>${varFile.type }</td>
            <td>${varFile.update }</td>
            <td><a href="/Demo/MServlet?method=Download&filename=${varFile.name}">download</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
