package com.caesar.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author CaesarWang
 * @ClassName BeanPostProcessorUtil
 * @Description bean的后置处理器
 * @Date 2020/12/23 9:46
 * @Version 1.0
 **/
//@Component
public class BeanPostProcessorUtil implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("student")){
            System.out.println("postProcessBeforeInitialization--操作");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("student")){
            System.out.println("postProcessAfterInitialization--操作");
        }
        return bean;
    }
}
