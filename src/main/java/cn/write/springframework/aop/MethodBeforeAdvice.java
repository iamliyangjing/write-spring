package cn.write.springframework.aop;

import java.lang.reflect.Method;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 14:02
 **/
public interface MethodBeforeAdvice extends BeforeAdvice {
    /**
     * Callback before a given method is invoked.
     *
     * @param method method being invoked
     * @param args   arguments to the method
     * @param target target of the method invocation. May be <code>null</code>.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    void before(Method method, Object[] args, Object target) throws Throwable;

}
