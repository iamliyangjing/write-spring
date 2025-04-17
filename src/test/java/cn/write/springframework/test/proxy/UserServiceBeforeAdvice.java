package cn.write.springframework.test.proxy;

import cn.write.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Title: UserServiceBeforeAdvice
 * @Author cooper.li
 * @Package cn.write.springframework.test.proxy
 * @Date 2025/4/17 20:57
 * @description:
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}

