package test.cc.sky.Domain;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cc.sky.Domain.Stu;
import cc.sky.Domain.User;

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

    @Test
    @Ignore
    public void fun2() {

        int i = 0;
        String s = "10";
        i = Integer.parseInt(s, 10);
        System.out.println(i);
        String s1 = String.valueOf(0xf);
        System.out.println(s1);
        int[] arr = new int[5];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = j;
        }
        int ss = Arrays.binarySearch(arr, 5);

    }

    @Test
    @Ignore
    public void fun3() {
        User u0 = new User();
        u0.setId(001);
        fun4(u0);
        System.out.println(u0);

    }

    public void fun4(User user) {
        user = new User();
        user.setId(002);
        System.out.println(user);
    }



}
