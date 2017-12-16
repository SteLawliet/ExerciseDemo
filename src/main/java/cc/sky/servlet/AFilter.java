package cc.sky.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Stelawliet on 17/11/9.
 */
public class AFilter implements Filter {
    private FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpServletRequest reqs=(HttpServletRequest)req;
        String ip = req.getRemoteAddr();
        Map<String,Integer> map0 = (Map<String, Integer>) reqs.getServletContext().getAttribute("map");
        if (map0==null){
            Map<String,Integer> map = new LinkedHashMap<String, Integer>();

           reqs.getServletContext().setAttribute("map",map);
        }else if (map0.containsKey(ip)){
            map0.put(ip,map0.get(ip)+1);
        }else {
            map0.put(ip,1);
        }
//        chain.doFilter(req, resp);
        reqs.getRequestDispatcher("/jsp/IpList.jsp").forward(reqs,resp);

    }

    public void init(FilterConfig config) {
        this.filterConfig = config;
    }

}
