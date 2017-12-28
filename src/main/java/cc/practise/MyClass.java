package cc.practise;

import cc.sky.Domain.Stu;

/**
 * Created by Stelawliet on 17/12/20.
 */
public class MyClass<T> {
    public MyClass() {
        String TeName = this.getClass().getGenericSuperclass().toString();
        String Name = TeName.substring(TeName.indexOf("<") + 1, TeName.indexOf(">"));
        System.out.println(Name);
    }
}
