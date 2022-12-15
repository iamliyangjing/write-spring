package cn.write.springframework.aop.framework;

/**
 * @program: write-spring
 * @description: 定义一个标准接口，用于获取代理类
 * @author: lyj
 * @create: 2022-12-15 10:52
 **/
public interface AopProxy {

    Object getProxy();
}
