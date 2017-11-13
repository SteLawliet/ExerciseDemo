package cc.sky.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import jdk.nashorn.internal.ir.ThrowNode;

/**
 * Created by Stelawliet on 17/11/6.
 */
public class DaoTest {
    private static  DataSource dataSource = new ComboPooledDataSource();
    public static int TestD() {
        Connection conn = null;
        Number number = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        int i =0;
        try {
            String sql="Select Count(*) from table_user";
//           QueryRunner queryRunner = new QueryRunner(dataSource);
//           number = queryRunner.query(sql,new ScalarHandler<Number>());
            conn = dataSource.getConnection();
            pst= conn.prepareStatement(sql);
            resultSet = pst.executeQuery();
            if (resultSet.next()){

                i=resultSet.getInt("Count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                pst.close();
                conn.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }

        }
        return i;
    }
    @Test
    @Ignore
    public void fun1(){
        int count = 0;
        int i = 0;
        Number number = DaoTest.TestD();

        i =number.intValue();
        String co  = String.valueOf(i);
        System.out.println(co);
    }
}
