package cn.write.springframework.test.common;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.PropertyValue;
import cn.write.springframework.beans.PropertyValues;
import cn.write.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.write.springframework.beans.factory.config.BeanDefinition;
import cn.write.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.write.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 15:39
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
