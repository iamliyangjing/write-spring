package cn.write.springframework.aop;

import java.lang.reflect.Method;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 10:53
 **/
public interface MethodMatcher {
    /**
     * 方法匹配，找到表达式范围内匹配下的目标类和方法。
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method,Class<?> targetClass);
}
