package com.example.demo1.bean;

import com.alibaba.fastjson.parser.Feature;

import java.util.Random;

public class User {
    private int userid;//8
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getuserid() {
        return userid;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    //生成指定length的随机字符串（A-Z，a-z，0-9）


}
