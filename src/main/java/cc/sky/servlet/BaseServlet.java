package cc.sky.servlet;



import com.github.flyinghe.tools.CommonUtils;

import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sky.Domain.PageBean;
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
            if (strings[0].equals("f")){
                req.getRequestDispatcher(strings[1]).forward(req,resp);
            }else if (strings[0].equals("r")){
                resp.sendRedirect(strings[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public String FindAll0(HttpServletRequest req, HttpServletResponse resp) {
        DaoStu daoStu = new DaoStu();
        List<User> list = daoStu.FindAll();
        String currentPage = req.getParameter("currentPage");
        int currentPage0 = currentPage == null || currentPage.equals("")
                ? 1 : Integer.parseInt(currentPage);
        PageBean pageBean =
                new PageBean(list, currentPage0, list.size(), 8);
        List<User> list0 = list.subList(pageBean.getStartPage(), pageBean.getLastPage());
        System.out.println("lastIndex =" + pageBean.getLastPage());
        System.out.println("MaxIndex =" + (list.size() - 1));
        req.setAttribute("UserList", list0);
        req.setAttribute("PageBean", pageBean);
        return "f:/index.jsp";
    }

    public String FindAll(HttpServletRequest req, HttpServletResponse resp) {
        DaoStu daoStu = new DaoStu();
        String currentPage = req.getParameter("currentPage");
        int currentPage0 = currentPage == null || currentPage.equals("")
                ? 1 : Integer.parseInt(currentPage);
        PageBean pageBean =
                new PageBean(currentPage0, daoStu.getCount(), 10);

        List<User> list = daoStu.FindAll((currentPage0 - 1) * pageBean.getPageSize(), pageBean.getPageSize());
//        List<User> list0 = list.subList(pageBean.getStartPage(), pageBean.getLastPage());

        req.setAttribute("UserList", list);
        req.setAttribute("PageBean", pageBean);
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

    public String SelectByName(HttpServletRequest req, HttpServletResponse resp) {
        DaoStu daoStu = new DaoStu();
        String name = req.getParameter("username");
        User u = daoStu.SelectByName(name);
        try {
            if (u == null) {
                resp.getWriter().print(" ✅ ");
            } else {
                resp.getWriter().print("the id already be sign up");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String Update(HttpServletRequest req, HttpServletResponse resp){
        DaoStu daoStu = new DaoStu();
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user =" + user);
        User user1 = new User();
        try {
            BeanUtils.populate(user1, req.getParameterMap());
            System.out.println("user1 =" + user1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        daoStu.Update(user);
        req.getSession().setAttribute("UserList",daoStu.FindAll());
        return "f:/index.jsp";
    }
    public String DeleteUser(HttpServletRequest req, HttpServletResponse resp){

        DaoStu daoStu = new DaoStu();
        String username = req.getParameter("username");
        daoStu.Delete(username);
        daoStu.UpdateIndex();
        req.getSession().setAttribute("UserList",daoStu.FindAll());
        return "f:/index.jsp";
    }
    public String TestU(HttpServletRequest req, HttpServletResponse resp){
        Number number = DaoTest.TestD();
        ++count;
        i =number.intValue()+count;
        String co  = String.valueOf(i);
        req.getSession().setAttribute("num",co);
        return "f:/jsp/Test.jsp";
    }
}
