package com.example.demo1.controller;

import com.example.demo1.bean.User;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class helloController {

    @Autowired
    UserService userService;

    //登录
    @RequestMapping("/login")
    public String loginPost(){
        return "login";
    }
    @ResponseBody
    @PostMapping("/loginC")
    public String login(@RequestBody User user){

        System.out.println("loginc");
        System.out.println(user);
    try {
        User flag = userService.login(user);
        if(flag !=null)
        {
            System.out.println("flag:     " + flag.toString());
            System.out.println("登陆成功");
        }
        else
        {
            System.out.println("登陆失败");
        }

    } catch (Exception e){
        System.out.println("数据库查询错误 at controller : login");
        e.printStackTrace();
    }

        return "登陆成功";
    }

    //注册
    @ResponseBody
    @PostMapping("/registerC")
    public String add( @RequestBody User user) {
        System.out.println(user.toString());
        int insertFlag =0;
        try {
            insertFlag = userService.register(user);

            System.out.println(insertFlag);
            System.out.println("插入成功");
        } catch (Exception e){
            System.out.println("插入错误");
            e.printStackTrace();

        }
        return "注册" + user.toString() + "  " + insertFlag;
    }
    @RequestMapping("/register")
    public  String ind() {
        return "register";
    }

    //Question
    @PostMapping("/question")
    public String question(){

        return "a";
    }
}
