package cn.write.springframework.beans.factory.support;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.core.io.Resource;
import cn.write.springframework.core.io.ResourceLoader;

/**
 * @program: write-spring
 * @description: Bean定义读取接口
 * @author: lyj
 * @create: 2022-12-13 23:57
 **/
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();
    // 三个加载Bena定义的方法
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
