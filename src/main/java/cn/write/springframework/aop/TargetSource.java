package cn.write.springframework.aop;

/**
 * @program: write-spring
 * @description: 用来获取当前的目标aop
 * @author: lyj
 * @create: 2022-12-15 10:53
 **/
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }
    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }
    public Object getTarget(){
        return this.target;
    }

}
