package cn.write.springframework.beans.factory.support;

import cn.write.springframework.core.io.DefaultResourceLoader;
import cn.write.springframework.core.io.ResourceLoader;

/**
 * @program: write-spring
 * @description: bean定义抽象实现类
 * @author: lyj
 * @create: 2022-12-13 23:57
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
