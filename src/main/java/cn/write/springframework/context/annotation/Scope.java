package cn.write.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @program: write-spring
 * @description: 用于配置作用域的自定义注解
 * @author: lyj
 * @create: 2022-12-15 16:39
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}
