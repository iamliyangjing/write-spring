package cn.write.springframework.context;

import java.util.EventListener;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 23:41
 **/
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
