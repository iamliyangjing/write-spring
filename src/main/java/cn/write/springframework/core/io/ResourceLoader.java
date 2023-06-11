package cn.write.springframework.core.io;

/**
 * @program: write-spring
 * @description: 包装资源加载器 ，定义获取资源接口
 * @author: lyj
 * @create: 2022-12-13 23:59
 **/
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
