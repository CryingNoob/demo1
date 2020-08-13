package com.example.demo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo1.dao")
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
        System.out.println("\n\ndemo1 is run at http://localhost:8080 \n");
        System.out.println("login is run at http://localhost:8080/login \n");
        System.out.println("register is run at http://localhost:8080/register \n\n");

    }

}
