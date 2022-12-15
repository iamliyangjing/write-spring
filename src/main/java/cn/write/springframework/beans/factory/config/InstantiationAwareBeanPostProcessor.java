package cn.write.springframework.beans.factory.config;

import cn.write.springframework.beans.BeansException;

/**
 * @program: write-spring
 * @description: 它添加了一个实例化前回调，和在实例化后但显式属性设置,或之前的回调自动装配发生。
 * @author: lyj
 * @create: 2022-12-15 14:28
 **/
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     *
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
