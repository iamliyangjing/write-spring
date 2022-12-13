package cn.write.springframework.beans.factory.config;

/**
 * @program: write-spring
 * @description: beanDefinition
 * @author: lyj
 * @create: 2022-12-13 17:37
 **/
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
