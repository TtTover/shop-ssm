package com.gec.service;

import com.gec.bean.Category;
import com.gec.bean.Orderitem;
import com.gec.bean.Product;
import com.gec.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService{
    List<Product> findHotProduct();

    List<Product> findNewProduct();

    /**
     * 通过产品编号查询产品信息
     * @param pid
     * @return
     */
    Product getById(String pid);

    List<Product> getByCid(String cid);

    List<Product> getAll();

    /**
     * 添加商品
     * @param product
     * @return
     */
    boolean addProduct(Product product);

    /**
     * 删除商品
     * @param product
     * @return
     */
    boolean deleteProduct(Product product);

    /**
     * 模糊搜索、关键字查询
     * @param search
     * @return
     */
    List<Product> findProductLikeName(String search);

    /**
     * 更新用户信息
     * @return
     */
    boolean updateByPrimaryKey(Product product);
}
