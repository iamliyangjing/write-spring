package cn.write.springframework.context;

import cn.write.springframework.beans.factory.ListableBeanFactory;

/**
 * @program: write-spring
 * @description: 上下文接口
 * 也就继承了关于 BeanFactory 方法，比如一些 getBean 的方法。另外 ApplicationContext 本身是 Central 接口，但目前还不需要添加一些获取ID和父类上下文，所以暂时没有接口方法的定义。
 * @author: lyj
 * @create: 2022-12-14 14:12
 **/
public interface ApplicationContext  extends ListableBeanFactory {
}
