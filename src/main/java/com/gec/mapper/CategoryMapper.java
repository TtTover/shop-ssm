package com.gec.mapper;

import com.gec.bean.Category;
import com.gec.bean.Product;

import java.util.List;

/**
* @author 17740
* @description 针对表【category】的数据库操作Mapper
* @createDate 2023-06-21 10:33:31
* @Entity com.gec.bean.Category
*/
public interface CategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> getAll();
}
