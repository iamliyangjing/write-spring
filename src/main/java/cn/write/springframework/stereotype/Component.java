package cn.write.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @program: write-spring
 * @description: 用于配置到 Class 类上的
 * @author: lyj
 * @create: 2022-12-15 16:40
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}