package cc.sky.Domain;

import cc.Annotation.Bean;
import cc.Annotation.ID;
import cc.Annotation.Name;
import cc.Annotation.Password;
import cc.Annotation.TableName;

/**
 * Created by Stelawliet on 17/12/20.
 */
@TableName("j_table")
public class JavaBean {
    @ID("id")
    private String id;
    @Name("name")
    private String name;
    @Password("password")
    private String val;

    public JavaBean(String id, String name, String val) {
        this.id = id;
        this.name = name;
        this.val = val;
    }

    public JavaBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}

