package cn.write.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Title: Value
 * @Author cooper.li
 * @Package cn.write.springframework.beans.factory.annotation
 * @Date 2025/2/19 23:13
 * @description:
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();

}