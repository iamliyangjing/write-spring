package cn.write.springframework;

/**
 * @program: write-spring
 * @description: beanDefinition
 * @author: lyj
 * @create: 2022-12-13 17:37
 **/
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
