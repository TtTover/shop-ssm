package com.gec.service;

import com.gec.bean.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有商品分类的方法
     * @return
     */
    List<Category> getAll();

    Category getByCid(String cid);
}
