package com.caesar.dao;

import com.caesar.entity.Student;

import java.util.List;

/**
 * @Author CaesarWang
 * @ClassName StudentDao
 * @Description 学生Dao接口
 * @Date 2020/12/24 10:59
 * @Version 1.0
 **/
public interface StudentDao {

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
     * @return int[] ： 数据影响行数的数组
     **/
    public int[] addStudent(List<Student> students);

}
