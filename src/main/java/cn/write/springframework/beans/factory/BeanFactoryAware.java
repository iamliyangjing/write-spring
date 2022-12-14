package cn.write.springframework.beans.factory;

import cn.write.springframework.beans.BeansException;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 22:09
 **/
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
