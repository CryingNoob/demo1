package com.example.demo1.controller;

import com.example.demo1.bean.UserBean;
import com.example.demo1.service.UserService;
import com.example.demo1.serviceImpl.UserServiceImpl;
import org.apache.ibatis.type.NStringTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController {

    @Autowired
    UserService userService;


    @RequestMapping("/loginPost")
    public String loginPost(){

        return "login";
    }

    @RequestMapping("/loginc")
    public String login(@RequestParam("name") String name,@RequestParam("password") String password){
        UserBean user= new UserBean();
        user.setPassword(password);
        user.setName(name);
        System.out.println("login");
        UserBean flag=userService.login(user);
        System.out.println("user:     "+ user.toString());
        //System.out.println("user:     "+ flag.toString());
        if(flag!=null)
        {
            System.out.println(true);
            return  "user";
        }

        else {

          System.out.println(false);
            return "error";
    }
    }
    //TODO  ajax 直接返回页面冲突?



    @GetMapping("/add")

    public String add(String name,String password) {
        System.out.println("add");
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPassword(password);
        userBean.setId(1);
        userService.add(userBean);
        return "nice " + name + " "+ password;
    }

    @RequestMapping("/")
    public  String ind(){
        return "ind2ex";

    }
    @ResponseBody
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public UserBean json(@RequestBody UserBean data) {
        System.out.println("post");
        System.out.println("data, "+data.toString());
        return  data;
    }
}
