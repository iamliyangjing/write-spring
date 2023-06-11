package cn.write.springframework.beans.factory;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 22:09
 **/
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);

}