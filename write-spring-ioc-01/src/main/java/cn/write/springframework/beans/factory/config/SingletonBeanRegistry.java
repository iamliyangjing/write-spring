package cn.write.springframework.beans.factory.config;

/**
 * @program: write-spring
 * @description: 定义一个获取简单单例对象的接口
 * @author: lyj
 * @create: 2022-12-13 19:11
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
