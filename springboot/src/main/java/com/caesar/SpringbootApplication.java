package com.caesar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.caesar.dao.CategoryMapper")//扫描的mapper
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    //@SpringBootApplication相当于@ComponentScan+@EnableAutoConfiguration+@SpringBootConfiguration
    //@ComponentScan(默认情况下:它扫描所有类型，并且扫描范围是@ComponentScan注解所在配置类包及子包的类)
    //@EnableAutoConfiguration(这个注解的作用与@Configuration作用相同，都是用来声明当前类是一个配置类,可以通过＠Bean注解生成IOC容器管理的bean)
    //@SpringBootConfiguration(通过这个注解把spring应用所需的bean注入容器中)
    //@Import(允许从另一个使用了@Configuration的配置类中加载 @Bean 定义，当实例化ApplicationContext就可以只指定带有@Import当前类即可)
    //@Configuration(带有 @Configuration 的注解类表示这个类可以使用 Spring IoC 容器作为 bean 定义的来源。@Bean 注解告诉 Spring，一个带有 @Bean 的注解方法将返回一个对象，该对象应该被注册为在 Spring 应用程序上下文中的 bean)

    //开启事务注解
    //@EnableTransactionManagement

    //@Bean(initMethod = "init", destroyMethod = "destroy" )
    //使用initMethod和destroyMethod指定当前bean的初始化和销毁的回调方法
    //@Scope("singleton")//@Scope默认是singleton单例模式（全局有且仅有一个实例）
    //@Scope("prototype")//prototype原型模式（每次获取Bean的时候会有一个新的实例）
    //@Bean
    //public SpringContextHolder springContextHolder(){
    //   return new SpringContextHolder();
    //}


}
