package cn.write.springframework.test;

import cn.write.springframework.beans.factory.config.BeanDefinition;
import cn.write.springframework.BeanFactory;
import cn.write.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.write.springframework.test.bean.UserService;
import org.junit.Test;


/**
 * @program: write-spring
 * @description: 测试
 * @author: lyj
 * @create: 2022-12-13 17:38
 **/
public class ApiTest {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();
    }


    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }
}
