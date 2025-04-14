package cn.write.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Title: Qualifier
 * @Author cooper.li
 * @Package cn.write.springframework.beans.factory.annotation
 * @Date 2025/2/19 23:13
 * @description:
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}