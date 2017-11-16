package test.cc.sky.Domain;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cc.sky.Domain.PageBean;
import cc.sky.Domain.User;

/**
 * Created by Stelawliet on 17/11/16.
 */
public class PageBeanTest {
    @Test
    @Ignore
    public void fun1() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 22; i++) {
            list.add(new User(i, "xx" + i, "p" + i));
        }


        PageBean p = new PageBean(list, 1, list.size(), 5);

        List<User> list0 = list.subList(p.getStartPage(), p.getLastPage());
        System.out.println("list" + list0 + "size = " + list0.size());

        System.out.println("-------------------");

        PageBean p0 = new PageBean(list, 2, list.size(), 5);


        List<User> list1 = list.subList(p0.getStartPage(), p0.getLastPage());
        System.out.println("list " + list1 + "size = " + list1.size());

    }
}
