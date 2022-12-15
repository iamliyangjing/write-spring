package cn.write.springframework.aop;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 14:02
 **/
public interface PointcutAdvisor extends Advisor{
    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
