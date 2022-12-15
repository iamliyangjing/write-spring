package cn.write.springframework.aop;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 10:53
 **/
public interface Pointcut {

    /**
     * Return the ClassFilter for this pointcut.
     * @return the ClassFilter (never <code>null</code>)
     */
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     * @return the MethodMatcher (never <code>null</code>)
     */
    MethodMatcher getMethodMatcher();
}
