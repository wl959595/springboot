package com.caesar.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author CaesarWang
 * @ClassName Person
 * @Description 学生实体类
 * @Date 2020/12/22 21:12
 * @Version 1.0
 **/
@Component
public class Person {

    //@Resoure注解先ByName查找装配，如果失败再ByType查找装配，最后如果都失败就报异常
    private int id;
    @Value(value = "A")
    private String name;
    @Resource
    private Student student;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }

    //@Autowired通过ByType来匹配，并且尽量别直接使用在属性上，最好使用在构造函数和setter方法上
    //@Autowired(required = false)
    public void setStudent(Student student) {
        this.student = student;
    }

    public void printException() {
        System.out.println("printException");
        //必须throw new Exception才能触发@AfterThrowing的方法
        throw new RuntimeException();
    }
}
