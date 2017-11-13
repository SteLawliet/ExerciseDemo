import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Created by Stelawliet on 17/11/6.
 */
public class HelloTest {
    public void fun4(){
        System.out.println("fun4");
    }
    @Test
    @Ignore
    public void fun1(){
        DataSource ds= new ComboPooledDataSource();
        try {
            Connection conn =ds.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    @Ignore
    public void fun2(){
        try {
            Class c =this.getClass();
            Method method = c.getMethod("fun4");
            String s = (String) method.invoke(this);
            System.out.println(s);
        }catch (Exception e){
            System.out.println("cuowu");
            throw new RuntimeException(e);
        }
    }

}
