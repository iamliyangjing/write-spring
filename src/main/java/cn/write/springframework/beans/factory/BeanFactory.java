package cn.write.springframework.beans.factory;

import cn.write.springframework.beans.BeansException;
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

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
