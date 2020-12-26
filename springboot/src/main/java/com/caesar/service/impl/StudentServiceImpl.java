package com.caesar.service.impl;

import com.caesar.dao.impl.StudentDaoImpl;
import com.caesar.entity.Student;
import com.caesar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author CaesarWang
 * @ClassName StudentServiceImpl
 * @Description 学生Service接口实现类
 * @Date 2020/12/24 10:56
 * @Version 1.0
 **/
@Service
public class StudentServiceImpl implements StudentService {

    private StudentDaoImpl studentDaoImpl;

    @Autowired
    public void setStudentDaoImpl(StudentDaoImpl studentDaoImpl) {
        this.studentDaoImpl = studentDaoImpl;
    }

    /**
     * @Author CaesarWang
     * @Description 获取学生列表
     * @Date 2020/12/23 20:56
     * @Param []
     * @return java.util.List<com.caesar.pojo.Student>
     **/
    @Override
    public List<Student> getStudentList() {
        return studentDaoImpl.getStudentList();
    }

    /**
     * @Author CaesarWang
     * @Description 批量插入学生信息
     * @Date 2020/12/23 20:57
     * @Param [students] ：学生列表
     * @return int ： 学生列表是否插入成功
     **/
    @Override
    public int addStudent(List<Student> students) {
        int[] results = studentDaoImpl.addStudent(students);
        int i = 1;
        //如果存在0的未成功，则返回0，否则返回1
        for(int result : results){
            if(result == 0){
                i = 0;
            }
        }
        System.out.println("新增"+(i==1 ? "成功":"失败"));
        return i;
    }
}
