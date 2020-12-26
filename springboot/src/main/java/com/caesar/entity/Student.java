package com.caesar.entity;

import org.springframework.stereotype.Component;

/**
 * @Author CaesarWang
 * @ClassName Student
 * @Description 学生实体类
 * @Date 2020/12/22 21:12
 * @Version 1.0
 **/
@Component
public class Student {

    //@Value(value = "1")
    private int id;
    //@Value(value="Caesar")
    private String name;
    //@Value(value="22")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@PostConstruct
    public void init() {
        System.out.println("init--bean");
    }

    //@PreDestroy
    public void destroy(){
        System.out.println("destroy--bean");
    }

}
