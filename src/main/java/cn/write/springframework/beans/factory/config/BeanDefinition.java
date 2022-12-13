package cn.write.springframework.beans.factory.config;

import cn.write.springframework.beans.PropertyValues;

/**
 * @program: write-spring
 * @description: beanDefinition
 * @author: lyj
 * @create: 2022-12-13 17:37
 **/
public class BeanDefinition {

    private Class beanClass;

    /**
     * 注入属性和依赖对象
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues !=null? propertyValues:new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
