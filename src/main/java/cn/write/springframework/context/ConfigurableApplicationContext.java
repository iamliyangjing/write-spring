package cn.write.springframework.context;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;

/**
 * @program: write-spring
 * @description: 提供了 refresh 这个核心方法
 * @author: lyj
 * @create: 2022-12-14 14:12
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
