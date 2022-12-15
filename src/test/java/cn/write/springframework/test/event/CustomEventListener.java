package cn.write.springframework.test.event;

import cn.write.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @program: write-spring
 * @description:
 * @author: lyj
 * @create: 2022-12-15 00:42
 **/
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }

}
