package cn.write.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: write-spring
 * @description: bean工厂 生产bean
 * @author: lyj
 * @create: 2022-12-13 17:37
 **/
public class BeanFactory {

    //用一个map存储BeanDefinition
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
