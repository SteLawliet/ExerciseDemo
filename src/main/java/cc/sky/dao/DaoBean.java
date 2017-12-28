package cc.sky.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

import javax.sql.DataSource;

import cc.Annotation.TableName;

/**
 * Created by Stelawliet on 17/12/20.
 */
public class DaoBean<T> {

    private static DataSource ds;
    private String tableName;
    private Class beanClass;

    public DaoBean(T t) {
        if (null == ds) {
            ds = new ComboPooledDataSource();
        }

        System.out.println(this.getClass().getGenericSuperclass());


        tableName = t.getClass().getAnnotation(TableName.class).value();

        beanClass = t.getClass();

    }

    public T SelectByName(String name) {


        String sql = "select * from " + tableName + " where username =?";


        QueryRunner qR = new QueryRunner(ds);

        T t1 = null;
        try {
            t1 = qR.query(sql, new BeanHandler<T>(beanClass), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t1;
    }


}
