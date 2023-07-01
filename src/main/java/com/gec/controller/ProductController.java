package com.gec.controller;

import com.gec.bean.Cart;
import com.gec.bean.CartItem;
import com.gec.bean.Category;
import com.gec.bean.Product;
import com.gec.mapper.ProductMapper;
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

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    HttpSession session;

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

        List<Category> categoryList = categoryService.getAll();
        modelAndView.addObject("categoryList",categoryList);

        modelAndView.setViewName("index");
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

    @RequestMapping("/getByCid")
    public ModelAndView getByCid(Category category){
        ModelAndView modelAndView = new ModelAndView();

        List<Product> productList = productService.getByCid(category.getCid());
        modelAndView.addObject("productList",productList);

        List<Category> categoryList = categoryService.getAll();
        modelAndView.addObject("categoryList",categoryList);

        modelAndView.setViewName("product_list");
        return modelAndView;
    }

    /**
     * 查询全部商品
     * @return
     */
    @RequestMapping("/getAll")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();

        List<Product> productList = productService.getAll();
        modelAndView.addObject("productList",productList);

        List<Category> categoryList = categoryService.getAll();
        modelAndView.addObject("categoryList",categoryList);

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
                product.setPimage("http://localhost:9090/upload/"+finalName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //进行商品的添加
        //设置一个产品编号
        product.setPid(UUID.randomUUID().toString().replace("-",""));
        product.setPdate(new Date());
        product.setPflag(1);
        //调用将商品写入数据库的方法
        productService.addProduct(product);
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

    /**
     * 模糊搜索
     * @param search
     * @param model
     * @return
     */
    @RequestMapping("/searchProduct")
    public String searchProduct(String search,Model model){
        List<Product> productList = productService.findProductLikeName(search);
        //查询出来的商品信息放到productList里面
        model.addAttribute("productList",productList);
        //去到展示商品的页面product_list.jsp
        return "product_list";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(Product product,Model model){
        productService.deleteProduct(product);

        List<Product> productList = productService.getAll();
        model.addAttribute(productList);


        return "admin/product/list";
    }

    @RequestMapping("/productListToAdmin")
    public ModelAndView productListToAdmin(Product product){
        ModelAndView modelAndView = new ModelAndView();

        List<Product> productList = productService.getAll();
        modelAndView.addObject("productList",productList);

        modelAndView.setViewName("admin/product/list");
        return modelAndView;
    }

    @RequestMapping("/addProductToAdmin")
    public String addProductToAdmin(Model model){
        //查询商品分类
        List<Category> categoryList = categoryService.getAll();
        //将这个数据加入到 添加商品页面
        model.addAttribute("category_list",categoryList);

        List<Product> productList = productService.getAll();
        model.addAttribute(productList);

        //将数据带到添加商品的页面
        return "admin/product/add";
    }

@RequestMapping("/toEditProduct")
public String toEditProduct(Product product,Model model){
        //查询商品分类
    List<Category> categoryList = categoryService.getAll();
    //将这个数据加入到 编辑商品页面
    model.addAttribute("category_list",categoryList);

    Product byId = productService.getById(product.getPid());
    model.addAttribute("product",byId);

    return "admin/product/edit";
}

    @RequestMapping("/editProduct")
    public String editProduct(Product product,Model model){
        session.setAttribute("product",product);
        productService.updateProduct(product);

        List<Product> productList = productService.getAll();
        model.addAttribute(productList);

        return "admin/product/list";
    }


}
