package com.example.demo1;

import com.example.demo1.bean.UserBean;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
    @Autowired
    UserService userService;


   /* public void contextLoads() {
        UserBean userBean = userService.login("ss","dd");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getId());
    }*/

}


