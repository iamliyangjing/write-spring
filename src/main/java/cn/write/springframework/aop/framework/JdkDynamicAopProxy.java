package cn.write.springframework.aop.framework;

import cn.write.springframework.aop.AdvisedSupport;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 10:52
 **/
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }


    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),advised.getTargetSource().getTargetClass(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //匹配 是否是拦截到的方法
        if (advised.getMethodMatcher().matches(method,advised.getTargetSource().getTarget().getClass())){
            //获取拦截器
            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
            //执行拦截方法
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
        }
        return method.invoke(advised.getTargetSource().getTarget(),args);
    }
}
