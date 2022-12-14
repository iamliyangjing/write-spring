package cn.write.springframework.beans.factory;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 22:53
 **/
public interface FactoryBean<T> {
    /**
     * 获取对象
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 对象类型
     * @return
     */
    Class<?> getObjectType();

    /**
     * 以及是否是单例对象
     * @return
     */
    boolean isSingleton();
}
