package com.caesar.utils.customevent;

import org.springframework.context.ApplicationEvent;

/**
 * @Author CaesarWang
 * @ClassName CustomEvent
 * @Description 自定义事件类
 * @Date 2020/12/23 15:53
 * @Version 1.0
 **/
public class CustomEvent extends ApplicationEvent {

    //继承ApplicationEvent并创建构造方法指向父类的引用
    public CustomEvent(Object source){
        super(source);
    }

    @Override
    public String toString() {
        return "Custom Event";
    }
}
