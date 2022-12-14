package cn.write.springframework.context.support;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.write.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.write.springframework.beans.factory.config.BeanPostProcessor;
import cn.write.springframework.context.ConfigurableApplicationContext;
import cn.write.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 14:12
 **/
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        //1.创建beanFactory，并加载 BeanDefinition
        refreshBeanFactory();;

        //2.获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));


        //4.在实例化之前，执行BeanFactoryPostProcessor（Invoke factory processors registered）
        invokeBeanFactoryPostProcessors(beanFactory);

        //5. BeanPostPorcessor 需要提前于其他 Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //6.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }
    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
