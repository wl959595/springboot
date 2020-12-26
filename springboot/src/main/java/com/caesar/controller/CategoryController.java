package com.caesar.controller;

import com.caesar.entity.Category;
import com.caesar.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author CaesarWang
 * @ClassName CategoryController
 * @Description 类别控制层
 * @Date 2020/12/25 12:01
 * @Version 1.0
 **/
@Controller
public class CategoryController {

     private CategoryServiceImpl categoryServiceImpl;

     @Autowired
    public void setCategoryServiceImpl(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @RequestMapping(value = "/getCategoryList",method = RequestMethod.GET)
    public String getCategoryList(ModelMap modelMap){
        List<Category> categoryList = categoryServiceImpl.getCategoryList();
        modelMap.addAttribute("categoryList",categoryList);
        return "categoryList";
    }

}
