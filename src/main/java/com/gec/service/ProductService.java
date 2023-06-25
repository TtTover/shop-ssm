package com.gec.service;

import com.gec.bean.Category;
import com.gec.bean.Product;
import com.gec.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService{
    List<Product> findHotProduct();

    List<Product> findNewProduct();

    Product getById(String pid);
}
