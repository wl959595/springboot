package com.caesar.utils;

import com.caesar.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author CaesarWang
 * @ClassName StudentMapper
 * @Description RowMapper通过ResultSet来自定义行的值，用于返回list
 * @Date 2020/12/23 21:36
 * @Version 1.0
 **/
public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
