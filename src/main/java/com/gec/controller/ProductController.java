package com.gec.controller;

import com.gec.bean.Product;
import com.gec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/home")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();

        //查询获取热门商品的数据
        List<Product> hotProduct = productService.findHotProduct();
        //将数据存放到hotProductList中
        modelAndView.addObject("hotProductList",hotProduct);

        //查询获取最新商品的数据
        List<Product> newProduct = productService.findNewProduct();
        //将数据存放到newProductList中
        modelAndView.addObject("newProductList",newProduct);

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/header")
    public ModelAndView header(){
        ModelAndView modelAndView = new ModelAndView();

        //查询获取热门商品的数据
        List<Product> hotProduct = productService.findHotProduct();
        //将数据存放到hotProductList中
        modelAndView.addObject("hotProductList",hotProduct);

        //查询获取最新商品的数据
        List<Product> newProduct = productService.findNewProduct();
        //将数据存放到newProductList中
        modelAndView.addObject("newProductList",newProduct);

        modelAndView.setViewName("header");
        return modelAndView;
    }

    @RequestMapping("/getById")
    public ModelAndView getById(String pid){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.getById(pid);
        modelAndView.addObject("product",product);
        modelAndView.setViewName("product_info");
        return modelAndView;
    }
}
