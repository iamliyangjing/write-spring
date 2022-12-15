package cn.write.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.write.springframework.beans.factory.config.BeanDefinition;
import cn.write.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: write-spring
 * @description: 处理对象扫描装配
 * @author: lyj
 * @create: 2022-12-15 16:39
 **/
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage){
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        //扫描一个包下拥有这个注解的所有类
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
