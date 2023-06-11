package cn.write.springframework.aop;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 10:53
 **/
public interface ClassFilter {
    /**
     * 定义类匹配类，用于切点找到给定的接口和目标类。
     * @param clazz
     * @return
     */
    boolean matches(Class<?> clazz);
}
