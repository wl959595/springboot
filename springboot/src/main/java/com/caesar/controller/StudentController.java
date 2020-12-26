package com.caesar.controller;

import com.caesar.entity.Student;
import com.caesar.service.StudentService;
import com.caesar.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CaesarWang
 * @ClassName StudentController
 * @Description 学生控制层类
 * @Date 2020/12/22 21:41
 * @Version 1.0
 **/
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用，当使用@RestController时无法返回到视图解析器的页面
//@RestController
@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
    public ModelAndView getStudentList(){
        List<Student> studentList = studentService.getStudentList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentList");
        modelAndView.addObject("studentList",studentList);

        //设置返回的数据类型为json类型，也可以不设置就返回对象
        //modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }

    @RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    public ModelAndView student(){
        //创建Student对象并访问addStudent.jsp页面，必须指定modelName为command
        return new ModelAndView("addStudent","command",new Student());
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addStudent(@ModelAttribute Student student) {
        List<Student> students = new ArrayList<Student>();
        if(student.getName().length() < 2){
            throw new CustomException("学生姓名长度过短！");
        }else if(student.getAge() < 18){
            throw new CustomException("学生年龄过小！");
        }else if(!student.getName().equals("") && student.getAge() > 0){
            students.add(student);
        }
        int i = studentService.addStudent(students);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:getStudentList");
        if(i == 1){
            modelAndView.addObject("rs","Success");
        }else{
            modelAndView.addObject("rs","Fail");
        }
        return modelAndView;
    }

}
