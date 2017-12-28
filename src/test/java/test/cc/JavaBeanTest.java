package test.cc;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import cc.Annotation.Bean;
import cc.sky.Domain.JavaBean;
import cc.sky.Domain.User;
import cc.sky.dao.DaoBean;
import cc.sky.dao.DaoJ;

import static org.junit.Assert.*;

/**
 * Created by Stelawliet on 17/12/20.
 */
public class JavaBeanTest {
    @Test
    @Ignore
    public void fun1() {
        Class c = JavaBean.class;
        Bean annotation = (Bean) c.getAnnotation(Bean.class);
        System.out.println(annotation.table_name());
    }

    @Test
    @Ignore
    public void fun2() {
        User user = new User();
        DaoJ daoJ = new DaoJ(user);
        System.out.println(daoJ.SelectByName("zzq"));
    }

    @Test
    @Ignore
    public void fun3() {

    }


}