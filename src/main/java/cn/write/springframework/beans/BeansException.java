package cn.write.springframework.beans;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-13 19:12
 **/
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
