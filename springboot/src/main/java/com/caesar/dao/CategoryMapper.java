package com.caesar.dao;

import com.caesar.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author CaesarWang
 * @Description 类别DAO
 * @Date 2020/12/25 10:48
 * @Param
 * @return
 **/
@Mapper//@Mapper用于Mybatis的Mapper接口上，通过@Mapper生成接口的动态代理类
public interface CategoryMapper {
    /**
     * 对于多个参数来说，每个参数之前都要加上@Param注解，
     * 要不然会找不到对应的参数进而报错
     */
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}