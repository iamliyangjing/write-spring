package cn.write.springframework.context;

/**
 * @program: write-spring
 * @description: 整个一个事件的发布接口，所有的事件都需要从这个接口发布出去
 * @author: lyj
 * @create: 2022-12-14 23:40
 **/
public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);

}
