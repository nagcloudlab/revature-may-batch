package com.example.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // when to detect annotation
@Target(value={ElementType.TYPE}) // where to apply annotation
public @interface WebServlet {
    String[] urlPatterns();
}
