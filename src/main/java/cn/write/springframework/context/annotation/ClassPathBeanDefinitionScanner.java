package cn.write.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import cn.write.springframework.beans.factory.config.BeanDefinition;
import cn.write.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.write.springframework.stereotype.Component;

import java.util.Set;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 16:38
 **/
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider  {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry){
        this.registry=registry;
    }

    public void doScan(String... basePackages){
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                //解析Bean的作用域 singleton、prototype
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)){
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition),beanDefinition);
            }
        }
    }

    private String resolveBeanScope(BeanDefinition beanDefinition){
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) return scope.value();
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            //首字母小写
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }
}
