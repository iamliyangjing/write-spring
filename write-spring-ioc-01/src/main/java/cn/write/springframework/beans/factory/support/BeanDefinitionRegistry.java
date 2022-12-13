package cn.write.springframework.beans.factory.support;

import cn.write.springframework.beans.factory.config.BeanDefinition;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 19:12
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
