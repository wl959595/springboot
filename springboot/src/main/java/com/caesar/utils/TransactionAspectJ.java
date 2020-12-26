package com.caesar.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Author CaesarWang
 * @ClassName Logging
 * @Description 事务的全局配置
 * @Date 2020/12/23 16:51
 * @Version 1.0
 **/
@Aspect
@Component
public class TransactionAspectJ {

     //创建打印日志的logger
     private static Logger logger = LoggerFactory.getLogger(TransactionAspectJ.class);

     private PlatformTransactionManager transactionManager;

     @Autowired
     public void setTransactionUtil(PlatformTransactionManager transactionManager) {
         this.transactionManager = transactionManager;
     }

    //第一个"*"：表示返回类型为所有类型；
     //"com.caesar.."：表示com.caesar当前包及所有子包的所有类的方法,".."表示当前包及其所有子包，必须这样才能找到所有的类，不用".."会无法找到下面的子包的类；
     //第二个"*"：表示类名，"*"表示所有类
     //第三个"*"：表示方法名，"*"表示所有方法
     //(..)：表示方法的参数，".."表示任何参数
     @Pointcut(value = "execution(* com.caesar.service..*.*(..))")
     public void loggingAll(){

     }

     //@Before(value="loggingAll()")
     public void beforeTask(){
         System.out.println("beforeTask");
     }

     //@After(value="loggingAll()")
     public void afterTask(){
         System.out.println("afterTask");
     }

    //@AfterReturning(pointcut = "loggingAll()",returning = "retVal")
    /***JoinPoint一定要出现在参数表的第一位*/
    public void afterReturnTask(JoinPoint point,Object retVal){
        System.out.println("afterReturnTask");
    }

     // 声明ex时指定的类型会限制目标方法必须抛出指定类型的异常，此处将ex的类型声明为Throwable，意味着对目标方法抛出的异常不加限制
     /***JoinPoint一定要出现在参数表的第一位*/
     //@AfterThrowing(pointcut = "loggingAll()",throwing = "ex")
     public void afterThrowingTask(JoinPoint point,Throwable ex){
         System.out.println("afterThrowingTask");
     }

    @Around(value="loggingAll()")
    public Object aroundTask(ProceedingJoinPoint point) throws Throwable {
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        Object object = null;
        try {
            System.out.println("aroundTask 1");
            //如果不调用ProceedingJoinPoint的proceed方法，就不会调用目标方法，也就不会执行其他注解的方法了
            object = point.proceed();
            //如果没有异常就提交事务
            transactionManager.commit(transactionStatus);
            System.out.println("aroundTask 2");
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            //发生异常就回滚事务
            transactionManager.rollback(transactionStatus);
            System.out.println("事务已回滚！");
            return "事务已回滚！";
        }
    }

}
