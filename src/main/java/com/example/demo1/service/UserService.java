package com.example.demo1.service;

import com.example.demo1.bean.User;

import java.util.List;

public interface UserService {
   User login(User user);
    int register(User user);

}
