package cc.sky.servlet;



import com.github.flyinghe.tools.CommonUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sky.Domain.User;
import cc.sky.dao.DaoStu;
import cc.sky.dao.DaoTest;

/**
 * Created by Stelawliet on 17/11/6.
 */
//@WebServlet(name = "BaseServlet",urlPatterns = "/BServlet")
public class BaseServlet extends HttpServlet {
    public static int count =0;
    public static int i = 0;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");

        Method method1 = null;

        try {

            Class c = Class.forName("cc.sky.servlet.BaseServlet");

            method1 = c.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);

        } catch (Exception e) {
            throw new RuntimeException("this method is null");
        }
        try {
            String result = (String) method1.invoke(this,req,resp);
            if( result==null || result.isEmpty() ){
                return;
            }
           String[] strings = result.split(":");
            System.out.println(count++);
            System.out.println(Arrays.toString(strings));
            if (strings[0].equals("f")){
                req.getRequestDispatcher(strings[1]).forward(req,resp);
            }else if (strings[0].equals("r")){
                resp.sendRedirect(strings[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public String FindAll(HttpServletRequest req, HttpServletResponse resp){

        DaoStu daoStu = new DaoStu();

        List<User> list = daoStu.FindAll();

        req.getSession().setAttribute("UserList",list);

        return "f:/index.jsp";
    }

    public String Add(HttpServletRequest req, HttpServletResponse resp){


        User user = CommonUtils.toBean(req.getParameterMap(),User.class);
        if (user.getUsername() ==null || user.getUsername().trim().isEmpty()
                ||user.getPassword()==null||user.getPassword().trim().isEmpty()){
            req.setAttribute("msg","username or password can not is Empty");
            return "f:/index.jsp";
        }
        DaoStu daoStu = new DaoStu();
        daoStu.Add(user);
        req.getSession().setAttribute("UserList",daoStu.FindAll());
        System.out.println(user);
        return "f:/index.jsp";
    }

    public String SelectByName(String name){

        return null;
    }

    public String Update(HttpServletRequest req, HttpServletResponse resp){
        DaoStu daoStu = new DaoStu();
        User user = CommonUtils.toBean(req.getParameterMap(),User.class);
        daoStu.Update(user);
        req.getSession().setAttribute("UserList",daoStu.FindAll());
        return "f:/index.jsp";
    }
    public String DeleteUser(HttpServletRequest req, HttpServletResponse resp){

        DaoStu daoStu = new DaoStu();
        String username = req.getParameter("username");
        daoStu.Delete(username);
        req.getSession().setAttribute("UserList",daoStu.FindAll());
        return "f:/index.jsp";
    }
    public String TestU(HttpServletRequest req, HttpServletResponse resp){
        Number number = (Number) DaoTest.TestD();
        ++count;
        i =number.intValue()+count;
        String co  = String.valueOf(i);
        req.getSession().setAttribute("num",co);
        return "f:/jsp/Test.jsp";
    }
}
