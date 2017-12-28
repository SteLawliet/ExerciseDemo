package cc.sky.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;

import cc.Annotation.TableName;
import cc.sky.Domain.User;

/**
 * Created by Stelawliet on 17/12/20.
 */
public class DaoBean<T> {

    private static DataSource ds;
    private String tableName;
    private Class beanClass;

    static {
        ds = new ComboPooledDataSource();
    }

    public DaoBean() {

        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType type1 = (ParameterizedType) type;
        beanClass = (Class) type1.getActualTypeArguments()[0];


//        tableName = t.getClass().getAnnotation(TableName.class).value();

    }

    public T SelectByName(String name) {


        String sql = "select * from " + tableName + " where username =?";


        QueryRunner qR = new QueryRunner(ds);

        T t1 = null;
        try {
            t1 = qR.query(sql, new MyBeanHandler<T>(beanClass), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t1;
    }

}

class DaoUser extends DaoBean<User> {

}
