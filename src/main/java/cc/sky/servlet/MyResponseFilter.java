package cc.sky.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Stelawliet on 17/12/14.
 */
public class MyResponseFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        MyResponse myResponse = new MyResponse((HttpServletResponse) resp);

        chain.doFilter(req, myResponse);

        String file = httpServletRequest.getServletContext().getRealPath("/1.html");

//       resp.getWriter().print(myResponse.getByteArray());
        System.out.println("MyResponse writer success");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(myResponse.getByteArray());
        bufferedWriter.flush();
        bufferedWriter.close();
        httpServletResponse.sendRedirect("/Demo/1.html");

    }

    public void init(FilterConfig config) {

    }

}
