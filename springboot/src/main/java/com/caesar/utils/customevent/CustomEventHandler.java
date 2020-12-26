package com.caesar.utils.customevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author CaesarWang
 * @ClassName CustomEventHandler
 * @Description 自定义事件调用类
 * @Date 2020/12/23 15:59
 * @Version 1.0
 **/
@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    //实现ApplicationListener<CustomEvent>，并重写onApplicationEvent方法实现事件处理
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(customEvent.toString());
    }

}
