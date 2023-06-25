package com.gec.service;


import com.gec.bean.CartItem;
import com.gec.bean.Category;
import com.gec.bean.Product;

import java.util.List;

public interface CategoryService {
    List<Product> findAllProduct();

    Category getByCid(String cid);
}
