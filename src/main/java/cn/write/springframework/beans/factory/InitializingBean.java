package cn.write.springframework.beans.factory;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 16:43
 **/
public interface InitializingBean {


    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
