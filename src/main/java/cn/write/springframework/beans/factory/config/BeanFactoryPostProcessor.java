package cn.write.springframework.beans.factory.config;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 14:10
 **/
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的BeanDefinition加载完成后，实例化Bean 对象之前，提供修改 BeanDefinition属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
