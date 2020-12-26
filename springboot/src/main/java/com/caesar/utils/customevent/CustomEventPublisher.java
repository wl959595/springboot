package com.caesar.utils.customevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author CaesarWang
 * @ClassName CustomEventPublisher
 * @Description 自定义事件发布类
 * @Date 2020/12/23 15:56
 * @Version 1.0
 **/
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    //实现ApplicationEventPublisherAware接口，并重写setApplicationEventPublisher方法，然后创建publish方法来发布自定义事件
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    /**
      * @Author CaesarWang
      * @Description 发布自定义事件
      * @Date 2020/12/23 16:11
      * @Param []
      * @return void
      **/
    public void publish(){
        CustomEvent customEvent = new CustomEvent(this);
        publisher.publishEvent(customEvent);
    }

}
