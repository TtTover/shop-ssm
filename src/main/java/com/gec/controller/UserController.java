package com.gec.controller;

import com.gec.bean.User;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    @RequestMapping("/login")
    public String login(Model model,String username, String password){
        //调用业务逻辑代码，判断账号密码是否正确
        User user = userService.doLogin(username, password);
        if (user == null){
            //错误没有返回用户信息
            model.addAttribute("error","账号密码错误");
            //在控制器中直接返回字符串的话，会找到对应的名称得到jsp模板 login.jsp
            return "login";
        }else {
            //正确返回用户信息
            //将用户信息记录到session中
            session.setAttribute("user",user);
            //登陆成功后重定向到首页
            return "redirect:home";
        }
    }

    @RequestMapping("/doRegister")
    public String doRegister(User user){
        //进行用户的添加
        //设置一个用户编号
        user.setUid(UUID.randomUUID().toString());
        user.setState(0);
        //调用将用户写入到数据库的方法
        userService.doRegister(user);
        //添加成功后去到登陆页面
        return "login";
    }
}
