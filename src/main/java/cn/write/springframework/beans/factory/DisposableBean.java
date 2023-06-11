package cn.write.springframework.beans.factory;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 16:43
 **/
public interface DisposableBean {
    void destroy() throws Exception;

}
