package cc.sky.dao;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import cc.practise.MyExClass;
import cc.sky.Domain.Teacher;
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

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i + 1);
        }

        return list;

    }

    public List<User> FindAll(int currentPage, int pageSize) {
        String sql = "Select * from table_user limit ?,?";
        QueryRunner qR = new QueryRunner(ds);
        Integer[] params = new Integer[]{currentPage, pageSize};
        List<User> list;
        try {
            list = qR.query(sql, new BeanListHandler<User>(User.class), (Object[]) params);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i + 1);
        }

        return list;

    }

    public User SelectByName(String name) {

        String sql = "Select * from table_user where username = ?";

        QueryRunner qR = new QueryRunner(ds);
        User user = null;
        try {
            user = qR.query(sql, new BeanHandler<User>(User.class), name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
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

    public int getCount() {

        String sql = "Select Count(*) from table_user";

        QueryRunner qR = new QueryRunner(ds);
        Number number = null;
        try {
            number = (Number) qR.query(sql, new ScalarHandler());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return number != null ? number.intValue() : 0;
    }

    public void UpdateIndex() {
        String[] sql = new String[]{"ALTER TABLE table_user DROP uid",
                "ALTER TABLE table_user ADD uid INT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT",
                "CREATE UNIQUE INDEX table_user_uid_uindex ON table_user (uid)",
                "ALTER TABLE table_user MODIFY COLUMN uid INT(50) NOT NULL AUTO_INCREMENT FIRST"};

        for (int i = 0; i < sql.length; i++) {
            try {
                Connection c = ds.getConnection();
                c.prepareStatement(sql[i]).execute();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Teacher SelectByName0(String name) {

        String sql = "Select * from table_user where username =?";

        QueryRunner qR = new QueryRunner(ds);

        Teacher teacher = null;

        try {
            teacher = qR.query(sql, new MyBeanHandler<Teacher>(Teacher.class), name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacher;
    }

    public Teacher SelectByName1(String name) {

        String sql = "Select * from table_user where username = ?";

        QueryRunner qR = new QueryRunner(ds);

        Teacher teacher = null;

        try {
            teacher = qR.query(sql, new MyBeanHandler<Teacher>(Teacher.class), name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacher;
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

        int i = getCount();
        System.out.println(i);

    }
    @Test
    @Ignore
    public void fun3(){

        List list = FindAll(1, 8);
        System.out.println(list);

    }

    @Test
    @Ignore
    public void fun4() {

        Teacher teacher = SelectByName1("zzq");
        System.out.println(teacher);
    }


    @Test
    @Ignore
    public void fun5() {
        User u = SelectByName("zzq");
        System.out.println(u);
    }

}
