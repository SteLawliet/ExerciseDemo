package cc.sky.dao;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import cc.sky.Domain.User;

/**
 * Created by Stelawliet on 17/11/6.
 */
public class DaoStu {
    private static DataSource ds =null;
    private Connection con = null;

    public DaoStu() {
        if (ds==null){
        ds = new ComboPooledDataSource();
        }
    }
    public List<User> FindAll(){
        String sql ="Select * from table_user";
        QueryRunner qR = new QueryRunner(ds);
        List<User> list;
        try {
            list = qR.query(sql,new BeanListHandler<User>(User.class));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }
    public void Add(User u){
        String sql="Insert table_user VALUES(null,?,?)";
        Object[] p = new Object[]{u.getUsername(),u.getPassword()};
        QueryRunner queryRunner = new QueryRunner(ds);
        try {
            queryRunner.update(sql,p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(String name){
        try {
            String sql = "Delete From table_user where username=?";
            QueryRunner queryRunner = new QueryRunner(ds);
            queryRunner.update(sql,name);
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
    }
    public void Update(User u){
        String sql = "UPDATE table_user " +
                "SET    username = ?,password =?  WHERE uid=?;";

        QueryRunner queryRunner = new QueryRunner(ds);
        try {
            queryRunner.update(sql,u.getUsername(),u.getPassword(),u.getUid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    @Ignore
    public void fun1(){

        List<User> list = FindAll();
        System.out.println(Arrays.toString(list.toArray()));
    }
    @Test
    @Ignore
    public void fun2(){

        User u = new User();
        u.setUsername("tttt");
        u.setPassword("123");
        Add(u);

    }
    @Test
    @Ignore
    public void fun3(){
        User u = new User("50","123","123");
        Update(u);

    }

}
