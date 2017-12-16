package cc.sky.servlet;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Stelawliet on 17/12/15.
 */
public class GZIPFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        MyResponse myResponse = new MyResponse(httpServletResponse);
        chain.doFilter(req, myResponse);

        char[] chars = myResponse.getByteArray();
        System.out.println("preGzip:l= " + chars.length);
        String s = String.valueOf(chars);
        byte[] bytes = s.getBytes("UTF-8");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(out);
        gzipOutputStream.write(bytes);
        gzipOutputStream.finish();
        System.out.println("aftGzip:l= " + out.toByteArray().length);
        httpServletResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpServletResponse.setHeader("Content-Encoding", "gzip");
        httpServletResponse.getOutputStream().write(out.toByteArray());
        out.close();
        gzipOutputStream.close();

    }

    public void init(FilterConfig config) {

    }

}
