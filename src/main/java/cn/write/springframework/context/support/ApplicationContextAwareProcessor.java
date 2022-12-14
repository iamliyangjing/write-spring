package cn.write.springframework.context.support;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.Aware;
import cn.write.springframework.beans.factory.config.BeanPostProcessor;
import cn.write.springframework.context.ApplicationContext;
import cn.write.springframework.context.ApplicationContextAware;

/**
 * @program: write-spring
 * @description:  由于applicationcontext的获取并不能直接在创建Bean时候就可以拿到，所以需要在refresh操作时
 * @author: lyj
 * @create: 2022-12-14 22:10
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
