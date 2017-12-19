package cc.sky.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.Request;

/**
 * Created by Stelawliet on 17/12/15.
 */
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter printWriter = response.getWriter();

        printWriter.print(new StringBuilder().append("<!DOCTYPE html>\n").append("<html lang=\"en\">\n").append("<head>\n").append("    <meta charset=\"UTF-8\">\n").append("    <title>Title</title>\n").append("    <style>\n").append("        .div0{\n").append("            height: 400px;\n").append("            width: 400px;\n").append("            background-color: #ee3871;\n").append("            margin: 0 auto;\n").append("        }\n").append("    </style>\n").append("    <script src=\"/Demo/jsp/js/jquery-3.2.js\"></script>\n").append("    <script>\n").append("        // window.onload = function () {\n").append("        //     var username = document.getElementById(\"username\");\n").append("        //     username.onchange = function () {\n").append("        //         var request = new XMLHttpRequest();\n").append("        //         request.open(\"POST\", \"<c:url value='/BServlet'/>\", true);\n").append("        //         request.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");\n").append("        //         //\"Content-Type\", \"application/x-www-form-urlencoded\"\n").append("        //         request.send(\"method=SelectByName&username=\" + username.value);\n").append("        //         request.onreadystatechange = function () {\n").append("        //             var text = request.responseText;\n").append("        //             var msg = document.getElementById(\"msg\");\n").append("        //             msg.textContent= text;\n").append("        //         }\n").append("        //     }\n").append("        // }\n").append("        jQuery(function () {\n").append("            jQuery('input[value=js_post]').click(function () {\n").append("                var xhr = new XMLHttpRequest();\n").append("                xhr.open('post','http://localhost:8080/Demo/BServlet',true);\n").append("                xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');\n").append("                xhr.send(\"method=JqueryAjax&ajax=js-post\");\n").append("                    // method:JqueryAjax\",\n").append("                    // ajax:\"js-get\"\n").append("                xhr.onreadystatechange=function () {\n").append("                    if (xhr.readyState=== 4 && xhr.status=== 200){\n").append("                        var text = xhr.responseText;\n").append("                        jQuery('.post').text(text);\n").append("                    }\n").append("                }\n").append("\n").append("            });\n").append("            jQuery('input[value=js_get]').click(function () {\n").append("                var xhr = new XMLHttpRequest();\n").append("                xhr.open('get','http://localhost:8080/Demo/BServlet?method=JqueryAjax&ajax=js-get',true);\n").append("                // xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');\n").append("                xhr.send();\n").append("                xhr.onreadystatechange=function () {\n").append("                    if (xhr.readyState=== 4 && xhr.status=== 200){\n").append("                        var text = xhr.responseText;\n").append("                        jQuery('.post').text(text);\n").append("                    }\n").append("                }\n").append("\n").append("            });\n").append("\n").append("            jQuery('input[value=ajax]').on('click',function () {\n").append("                jQuery.ajax('/Demo/BServlet?method=JqueryAjax&ajax=jquery:ajax',\n").append("                    {\n").append("                        success:function(data,stu) {\n").append("                            jQuery('.get').text(data);\n").append("                            console.log(data);}\n").append("                    });\n").append("            });\n").append("\n").append("            jQuery('input[value=get]').on('click',function () {\n").append("                jQuery.get('/Demo/BServlet?method=JqueryAjax&ajax=jquery:get',\n").append("                    function (data,stu) {\n").append("                        jQuery('.get').text(data);\n").append("                        console.log(data);\n").append("\n").append("                    });\n").append("            });\n").append("            jQuery('input[value=post]').on('click',function () {\n").append("                jQuery.post('/Demo/BServlet',\n").append("                    {\n").append("                        \"method\":\"JqueryAjax\",\n").append("                        \"ajax\":\"jquery:post\"\n").append("                    },\n").append("                    function (data,stu) {\n").append("                        jQuery('.get').text(data);\n").append("                        console.log(data);\n").append("                    },\"text\");\n").append("\n").append("            });\n").append("        });\n").append("    </script>\n").append("</head>\n").append("<body>\n").append("<input type=\"button\" value=\"get\">\n").append("<input type=\"button\" value=\"post\">\n").append("<input type=\"button\" value=\"ajax\">\n").append("<input type=\"button\" value=\"js_get\">\n").append("<input type=\"button\" value=\"js_post\">\n").append("<div class=\"div0\">\n").append("    <p class=\"get\"></p>\n").append("    <p class=\"post\"></p>\n").append("    <p class=\"ajax\"></p>\n").append("</div>\n").append("</body>\n").append("</html>").toString());

    }
}