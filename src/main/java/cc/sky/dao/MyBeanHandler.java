package cc.sky.dao;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.ResultSetHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import cc.Annotation.Column;

/**
 * Created by Stelawliet on 17/12/21.
 */
public class MyBeanHandler<T> implements ResultSetHandler<T> {

    private Class TClass;

    private boolean flag;


    private Map<String, String> beanMap;

    public MyBeanHandler(Class t) {
        this.TClass = t;
        this.beanMap = getAnnotations();
        this.flag = false;
    }

    @Override
    public T handle(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        int cols = metaData.getColumnCount();

        T t = null;

        try {
            t = (T) TClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            flag = true;
            for (int i = 1; i < cols + 1; i++) {

                for (Map.Entry<String, String> e : beanMap.entrySet()) {
                    if (e.getValue().equals(metaData.getColumnName(i))) {
                        beanMap.put(e.getKey(), rs.getString(i));
                        break;
                    }
                }
            }
        }

        if (flag) {
            try {
                BeanUtils.populate(t, beanMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {

            return null;

        }


        return t;
    }

    private Map<String, String> getAnnotations() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        Field[] fields = TClass.getDeclaredFields();
        for (Field f : fields) {

            if (f.getAnnotation(Column.class) == null) {
                continue;
            }
            map.put(f.getName(), f.getAnnotation(Column.class).value());
        }
        return map;
    }

}
