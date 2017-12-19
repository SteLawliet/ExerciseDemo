import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss-S");
        String s = sdf.format(new Date());
        System.out.println(s);
    }

    @Test
    @Ignore
    public void fun3() {
        String s = "0123456789";
        s = s.substring(0, 10);
        System.out.println(s);//0123456789
        s = "0123452789";
//        System.out.println(s.substring(1));//123456789
//        System.out.println(s.split("2",3)[2]);
        System.out.println(s.indexOf("23"));
        System.out.println(s.substring(s.indexOf("27")));
        System.out.println(s.lastIndexOf("2"));
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        System.out.println(uuid);
        System.out.println(uuid.length());
    }

}
