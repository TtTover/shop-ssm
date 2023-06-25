package com.gec.service.impl;

import com.gec.bean.Category;
import com.gec.bean.Product;
import com.gec.mapper.CategoryMapper;
import com.gec.mapper.ProductMapper;
import com.gec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Product> findHotProduct() {
        return productMapper.findHotProduct();
    }

    @Override
    public List<Product> findNewProduct() {return productMapper.findNewProduct();}

    @Override
    public Product getById(String pid) {
        if (pid==null || pid.equals("")){
            return null;
        }
        Product product = productMapper.selectByPrimaryKey(pid);
        return product;
    }
}
