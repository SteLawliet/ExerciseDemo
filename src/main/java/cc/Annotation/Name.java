package cc.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Stelawliet on 17/12/20.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {
    String value();
}
