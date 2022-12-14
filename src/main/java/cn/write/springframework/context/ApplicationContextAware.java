package cn.write.springframework.context;

import cn.write.springframework.beans.BeansException;
import cn.write.springframework.beans.factory.Aware;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 22:10
 **/
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
