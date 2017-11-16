package test.cc.sky.Domain;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stelawliet on 17/11/16.
 */
public class listTest {
    @Test
    @Ignore
    public void fun1() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("list =" + list);

        List<Integer> list0 = list.subList(0, list.size());
        System.out.println("list0 =" + list0);

    }
}
