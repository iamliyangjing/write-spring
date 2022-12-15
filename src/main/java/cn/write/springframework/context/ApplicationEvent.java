package cn.write.springframework.context;

import java.util.EventObject;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 23:40
 **/
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
