package cn.write.springframework.context.event;

import cn.write.springframework.beans.factory.BeanFactory;
import cn.write.springframework.context.ApplicationEvent;
import cn.write.springframework.context.ApplicationListener;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-14 23:40
 **/
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}
