package cn.write.springframework.test;

import cn.write.springframework.beans.factory.config.BeanDefinition;
import cn.write.springframework.BeanFactory;
import cn.write.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

/**
 * @program: write-spring
 * @description: 测试
 * @author: lyj
 * @create: 2022-12-13 17:38
 **/
public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
