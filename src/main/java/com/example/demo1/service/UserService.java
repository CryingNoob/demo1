package com.example.demo1.service;

import com.example.demo1.bean.User;



public interface UserService {
   User login(User user);
    User getUser(int id);
    int register(User user);
    User getUserByName(String username);

}
