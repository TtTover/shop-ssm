package com.gec.controller;

import com.gec.bean.Category;
import com.gec.bean.Product;
import com.gec.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

//    @RequestMapping("/header")
//    public ModelAndView header(){
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<Product> allProduct = categoryService.findAllProduct();
//        modelAndView.addObject("categoryList",allProduct);
//        modelAndView.setViewName("header");
//        return modelAndView;
//    }

}
