package cc.practise;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Stelawliet on 17/12/19.
 */
@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.METHOD})
public @interface Myan {
    int value();
}
