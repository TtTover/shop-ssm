package com.gec.service.impl;

import com.gec.bean.Category;
import com.gec.bean.Product;
import com.gec.mapper.CategoryMapper;
import com.gec.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }

    @Override
    public Category getByCid(String cid) {
        if (cid==null || cid.equals("")){
            return null;
        }
        Category category = categoryMapper.selectByPrimaryKey(cid);
        return category;
    }
}
