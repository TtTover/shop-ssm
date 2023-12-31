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

    @Override
    public List<Product> getByCid(String cid) {return productMapper.getByCid(cid);}

    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @Override
    public boolean addProduct(Product product) {
        int insert = productMapper.insert(product);
        if (insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        int update = productMapper.updateByPrimaryKeySelective(product);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Product product) {
        int update = productMapper.updateByPrimaryKey(product);
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        int delete = productMapper.deleteByPrimaryKey(product.getPid());
        if (delete>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findProductLikeName(String search) {
        return productMapper.findProductLikeName(search);
    }
}
