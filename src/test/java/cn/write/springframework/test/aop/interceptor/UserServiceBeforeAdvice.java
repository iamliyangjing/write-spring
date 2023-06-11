package cn.write.springframework.test.aop.interceptor;

import cn.write.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 14:54
 **/
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
