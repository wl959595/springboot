package com.caesar.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author CaesarWang
 * @ClassName SpringContextHolder
 * @Description 获取ApplicationContext
 * @Date 2020/12/22 23:14
 * @Version 1.0
 **/
@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    private static AbstractApplicationContext abstractApplicationContext = null;

    public static Object getBean(String beanName){
        return abstractApplicationContext.getBean(beanName);
    }

    @Override
    public void destroy() throws Exception {
        abstractApplicationContext = null;
    }

    public static AbstractApplicationContext getApplicationContext() {
        return abstractApplicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.abstractApplicationContext = (AbstractApplicationContext) applicationContext;
    }
}
