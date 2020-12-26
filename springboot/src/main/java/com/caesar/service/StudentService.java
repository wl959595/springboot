package com.caesar.service;

import com.caesar.entity.Student;

import java.util.List;

/**
 * 学生Service层
 */
public interface StudentService {

    /**
      * @Author CaesarWang
      * @Description 获取学生列表
      * @Date 2020/12/23 20:56
      * @Param []
      * @return java.util.List<com.caesar.pojo.Student>
      **/
    public List<Student> getStudentList();

    /**
      * @Author CaesarWang
      * @Description 批量插入学生信息
      * @Date 2020/12/23 20:57
      * @Param [students] ：学生列表
      * @return int ： 学生列表是否插入成功
      **/
    public int addStudent(List<Student> students);

}
