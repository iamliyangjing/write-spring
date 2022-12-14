package cn.write.springframework.beans.factory;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.write.springframework.beans.factory.config.BeanDefinition;
import cn.write.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 23:58
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
