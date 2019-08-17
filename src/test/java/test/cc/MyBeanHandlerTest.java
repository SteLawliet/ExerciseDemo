package test.cc;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import cc.sky.Domain.User;

import static org.junit.Assert.*;

/**
 * Created by Stelawliet on 17/12/22.
 */
public class MyBeanHandlerTest {
    @Test
    @Ignore
    public void fun1() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("id", "1");
        map.put("uid", "001");
        map.put("username", "zzz");
        map.put("password", "1233");
        User u = new User();
        try {
            BeanUtils.populate(u, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(u);
    }

}