package cn.write.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 14:01
 **/
public interface Advisor {
    /**
     * 返回此方面的建议部分。一个建议可能是一个
     * 拦截器，a前建议，a抛出建议，等等。
     * @return
     */
    Advice getAdvice();
}
