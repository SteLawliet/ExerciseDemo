package cc.practise;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Stelawliet on 17/12/19.
 */
public enum AS {
    A("1"), B("2"), C("3"), D("4");

    private String id;


    AS() {

    }

    AS(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Ignore
    @Test
    public void fun1() {
        System.out.println(AS.B.getId());
    }
}
