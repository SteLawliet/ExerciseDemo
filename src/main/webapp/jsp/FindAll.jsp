<%--
  Created by IntelliJ IDEA.
  User: zhaoziqi
  Date: 17/11/6
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%--<link href="github.css" rel="stylesheet"/>--%>
    <title>Title</title>
    <style type="text/css">
        table, th, td {
            margin: 0;
            padding: 0;
        }

        td input {
            border: none;
            width: 100%;
        }

        tr {
            line-height: 2.5em
        }

        table {
            margin: 0 auto;
        }

        tr input {
            height: 2.5em;
            font-size: 125%;
            background-color: transparent;
            /*outline: none;*/
            margin: 0;
            padding: 0;

        }

        a {
            text-decoration: none;
        }
    </style>
    <script src="<c:url value='/jsp/js/jquery-3.2.js'/>"></script>
    <script>
        jQuery(function () {
            var lis = jQuery('tr');

            for (var i = 0; i < lis.length; i++) {
                if (i % 2 === 0) {
                    lis[i].style.background = '#abc';
                    // jQuery(lis[i]).find('input').css('background','#abc');
                }
            }
            jQuery('input[value=ajax]').on('click', function () {
                jQuery.get("/Demo/BServlet?method=" +
                    "JqueryAjax&ajax=jquery", function (data, stus) {
                        jQuery('.ajax').text(data + 'stu' + stus);
                    }
                );
            });

            jQuery('.del').on('click', function () {
                return confirm('del?');
            });
            jQuery('input[type=submit]').on('click', function () {
                return confirm('submit');
            });
        });
    </script>

</head>
<body>
<table width="60%" align="center" cellpadding="10px" cellspacing="0" border="1px">
    <tr bgcolor="#5f9ea0">
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>operation</th>
        <th>editor</th>
    </tr>

    <c:forEach items="${UserList}" var="user">
        <form action="<c:url value='/BServlet'/>" method="post">
            <input type="hidden" name="method" value="Update">
            <input type="hidden" name="uid" value="${user.uid}">
            <tr>

                <td>
                    <input type="text" name="id" value="${user.uid}" readonly="readonly">
                </td>
                <td>
                    <input type="text" name="username" value="${user.username}">
                </td>
                <td>
                    <input type="text" name="password" value="${user.password}">
                </td>
                <td>
                    <a class="del"
                       href="<c:url value='/BServlet?method=DeleteUser&username=${user.username}'/>">del</a>
                </td>
                <td>
                    <input type="submit" value="editor">
                </td>
            </tr>
        </form>
    </c:forEach>

    <tr>
        <td colspan="5">
            <a href=" <c:url value='/BServlet?method=FindAll&currentPage=${PageBean.firstPage}'/>">firstPage:${PageBean.firstPage}</a>&nbsp;&nbsp;&nbsp;
            <a href=" <c:url value='/BServlet?method=FindAll&currentPage=${PageBean.prePage}'/>">prePage:${PageBean.prePage}</a>&nbsp;&nbsp;&nbsp;
            <a href=" <c:url value='/BServlet?method=FindAll&currentPage=${PageBean.nextPage}'/>">nextPage:${PageBean.nextPage}</a>&nbsp;&nbsp;&nbsp;
            <a href=" <c:url value='/BServlet?method=FindAll&currentPage=${PageBean.currentPage}'/>">currentPage:${PageBean.currentPage}</a>&nbsp;
            /<a href=" <c:url value='/BServlet?method=FindAll&currentPage=${PageBean.totalPage}'/>">totalPage:${PageBean.totalPage}</a>&nbsp;&nbsp;&nbsp;
        </td>
    </tr>
</table>
<span class="ajax"></span>
<input type="button" value="ajax">
</body>
</html>
