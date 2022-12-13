package cn.write.springframework;

import cn.write.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: write-spring
 * @description: bean工厂 生产bean
 * @author: lyj
 * @create: 2022-12-13 17:37
 **/
public interface BeanFactory {

    //用一个map存储BeanDefinition

    public Object getBean(String name);
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);

}
