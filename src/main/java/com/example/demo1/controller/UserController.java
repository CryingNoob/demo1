package com.example.demo1.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo1.bean.User;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class UserController {

//    @Autowired
//    UserService userService;
    private  UserService userService;
    @Autowired
    public  void setUserService(UserService userService){
        this.userService = userService;
    }

    //登录
    @RequestMapping("/login")
    public String loginPost(){
        return "login";
    }
    @ResponseBody
    @PostMapping("/loginC")
    public String login(@RequestBody User user){

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

    //登录
//@RespondBody
//    @GetMapping("user/signin")
//    public User loginGet(String name,String password){
//        System.out.println("singin");
//        User user=new User();
//        user.setusername(name);
//        user.setpassword(password);
//        User reUser = null;
//        try{
//
//           reUser= userService.login(user);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("登录 get error");
//        }
//     return reUser;
//    }
//    @ResponseBody
//    @GetMapping("user/signin1")
//    public User loginGet( Map<String,Object>json){
//        System.out.println("json"+json);
//        String name= JSON.parseObject(JSON.toJSONString(json.get("username")),String.class) ;
//        String password= JSON.parseObject(JSON.toJSONString(json.get("password")),String.class) ;
//
//        User user=new User();
//        user.setusername(name);
//        user.setpassword(password);
//        System.out.println(user);
//        User reUser = null;
//        try{
//
//            reUser= userService.login(user);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("登录 get error");
//        }
//        return reUser;
//    }

//    @ResponseBody
//    @GetMapping("user/signin1")
//    public User loginGet(User user){
//
//
//        System.out.println(user);
//        User reUser = null;
//        try{
//
//            reUser= userService.login(user);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("登录 get error");
//        }
//        return reUser;
//    }
    @ResponseBody
    @PostMapping("user/signin")
    public User loginPost(@RequestBody User user){


        System.out.println("post"+user);
        User reUser = null;
        try{

            reUser= userService.login(user);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("登录 get error");
        }
        return reUser;
    }

    //注册
    @ResponseBody
    @PostMapping("user/signupO")
    public User signupO(@RequestBody Map<String, Object> json){
        User res=new User();
        User res1=new User();
        try{
            res.setusername(JSON.parseObject(JSON.toJSONString(json.get("username")),String.class));
            res.setpassword(JSON.parseObject(JSON.toJSONString(json.get("password")),String.class));
            System.out.println(res);
            userService.register(res);
            res1=userService.getUserByName(res.getusername());
        }catch ( Exception e){
            e.printStackTrace();
        }

        return res1;
    }



    @ResponseBody
    @PostMapping("user/signup")
    public String add( @RequestBody User user) {
        System.out.println(user.toString());
        int insertFlag =0;
        try {
            insertFlag = userService.register(user);
            System.out.println(insertFlag);
            System.out.println("注册插入成功");
        } catch (Exception e){
            System.out.println("注册插入错误");
            e.printStackTrace();
        }
        return "注册" + user.toString() + "  " + insertFlag;
    }
    @RequestMapping("/register")
    public  String ind() {
        return "signup";
    }

    //Question
    @PostMapping("/question")
    public String question(){

        return "a";
    }
}
