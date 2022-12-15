package cn.write.springframework.context.event;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 23:40
 **/
public class ContextClosedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
