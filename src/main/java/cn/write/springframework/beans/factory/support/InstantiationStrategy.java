package cn.write.springframework.beans.factory.support;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 21:12
 **/
public interface InstantiationStrategy {

    /**
     * 实例化接口
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
