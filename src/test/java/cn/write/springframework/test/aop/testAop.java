package cn.write.springframework.test.aop;

import cn.write.springframework.aop.AdvisedSupport;
import cn.write.springframework.aop.TargetSource;
import cn.write.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.write.springframework.aop.framework.Cglib2AopProxy;
import cn.write.springframework.aop.framework.JdkDynamicAopProxy;
import cn.write.springframework.context.support.ClassPathXmlApplicationContext;
import cn.write.springframework.test.aop.beans.IUserService;
import cn.write.springframework.test.aop.beans.UserService;
import cn.write.springframework.test.aop.interceptor.UserServiceInterceptor;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 11:18
 **/
public class testAop {

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.write.springframework.test.bean.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));

        // true、true
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.write.springframework.test.aop.beans.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }


    @Test
    public void test_aop1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
