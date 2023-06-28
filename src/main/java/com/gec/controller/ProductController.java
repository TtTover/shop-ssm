package com.gec.controller;

import com.gec.bean.Category;
import com.gec.bean.Product;
import com.gec.service.CategoryService;
import com.gec.service.ProductService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

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

    @RequestMapping("/productList")
    public ModelAndView productList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.productList();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("product_list");
        return modelAndView;
    }

    @RequestMapping("/addProduct")
    public String addProduct(@PathVariable("file") MultipartFile file, Product product){
        //要添加到数据的产品数据
        System.out.println(product);
        //在添加商品的时候需要上传商品的图片
        try{
            if (file!=null){
                //文件对象不为空 说明有商品图片
                //获取要存放商品图片的文件夹的绝对路径
                String path = "C:\\Users\\17740\\Desktop\\大三下见习\\shop-ssm\\web\\upload";
                //获取要上传的文件的后缀名
                //获取文件的原来的名称
                String originalFilename = file.getOriginalFilename();
                //从原来的名称中获取他的图片后缀
                String extension = FilenameUtils.getExtension(originalFilename);

                //为了防止上传的商品图片重名的问题 对每个上传的图片进行重命名
                String newFileName = UUID.randomUUID().toString().replace("-","");
                //加上后缀
                newFileName = newFileName+"."+extension;

                //为了解决一个文件夹下有太多的图片 需要按照商品类型来对商品图片分文件夹来存放
                String filePath = product.getCid();

                //组装一下文件名 确认 文件最终的路径名称
                String finalName = filePath+"/"+newFileName;

                System.out.println(finalName);

                //创建文件对象
                File destFile = new File(path,finalName);

                //检查 按照分类来存放图片的文件夹是否有创建 没有创建就创建对应的文件夹
                if(!destFile.getParentFile().exists()){
                    //destFile上传的图片 他的父母文件夹 就是分类的文件夹 按照产品的分类的文件夹
                    //来用不同分类的文件夹来存放不同的图片
                    //如果这个分类的文件夹不存在就创建对应的文件夹
                    destFile.getParentFile().mkdir();
                }

                //利用io流的方法 去将网页提交过来的图片写入到目标的地址上面去
                file.transferTo(destFile);

                System.out.println("文件上传成功");
                //将图片的路径设置到 产品对象中
                product.setPimage(finalName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //添加成功以后去到商品列表页面 需要自己写控制器方法
        return "admin/product/list";
    }

    //写一个进入查询商品分类 然后带商品分类数据到添加商品的页面的控制器方法
    @RequestMapping("/toAddproduct")
    public String toAddproduct(Model model){
        //查询商品分类
        List<Category> categoryList = categoryService.getAll();
        //将这个数据加入到 添加商品页面
        model.addAttribute("category_list",categoryList);
        //将数据带到添加商品的页面
        return "admin/product/add";
    }
}
