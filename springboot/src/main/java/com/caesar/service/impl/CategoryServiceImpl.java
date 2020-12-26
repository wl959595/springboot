package com.caesar.service.impl;

import com.caesar.dao.CategoryMapper;
import com.caesar.entity.Category;
import com.caesar.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author CaesarWang
 * @ClassName CategoryServiceImpl
 * @Description 类别接口实现类
 * @Date 2020/12/25 10:37
 * @Version 1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.selectAll();
    }

}
