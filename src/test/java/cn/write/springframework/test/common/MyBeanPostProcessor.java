package cn.write.springframework.test.common;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.config.BeanPostProcessor;
import cn.write.springframework.test.bean.UserService;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 15:43
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
