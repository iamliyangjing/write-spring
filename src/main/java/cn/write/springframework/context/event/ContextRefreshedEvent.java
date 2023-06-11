package cn.write.springframework.context.event;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 23:40
 **/
public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
