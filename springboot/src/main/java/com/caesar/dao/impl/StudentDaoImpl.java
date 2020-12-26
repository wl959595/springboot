package com.caesar.dao.impl;

import com.caesar.dao.StudentDao;
import com.caesar.entity.Student;
import com.caesar.utils.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
  * @Author CaesarWang
  * @Description 学生Dao层
  * @Date 2020/12/22 21:05
  * @Param
  * @return
  **/
@Repository
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
        String sql = "select id,name,age from student";
        List<Student> studentList = jdbcTemplate.query(sql,new StudentMapper());
        return studentList;
    }

    /**
     * @Author CaesarWang
     * @Description 批量插入学生信息
     * @Date 2020/12/23 20:57
     * @Param [students] ：学生列表
     * @return int ： 学生列表是否插入成功
     **/
    @Override
    public int[] addStudent(List<Student> students) {
        if(students.size() < 0 || students.isEmpty()) {
            int[] results = {0};
            return results;
        }else{
            String sql = "insert into student(id,name,age) values(?,?,?)";
            //返回值为每次新增操作影响的行数，如果为1，则成功新增，否则为0是失败
            int[] results = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                // spring jdbc 帮我们生成了批量插入的 sql 语句, 我们也可以直接使用批量的插入 sql 语句进行批量数据插入
                // return jdbcTemplate.batchUpdate(new String[]{sql});
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    Student student = students.get(i);
                    preparedStatement.setInt(1,student.getId());
                    preparedStatement.setString(2,student.getName());
                    preparedStatement.setInt(3,student.getAge());
                }

                @Override
                public int getBatchSize() {
                    return students.size();
                }
            });
            return results;
        }
    }

}
