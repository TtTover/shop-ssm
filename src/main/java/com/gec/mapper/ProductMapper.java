package com.gec.mapper;

import com.gec.bean.Product;

import java.util.List;

/**
* @author 17740
* @description 针对表【product】的数据库操作Mapper
* @createDate 2023-06-21 10:33:31
* @Entity com.gec.bean.Product
*/
public interface ProductMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 查询所有的热门商品的方法
     * @return
     */
    List<Product> findHotProduct();

    /**
     * 查询最新商品的方法
     * @return
     */
    List<Product> findNewProduct();
}
