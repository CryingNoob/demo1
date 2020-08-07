package com.example.demo1.service;

import com.example.demo1.bean.UserBean;

public interface UserService {
    UserBean login(UserBean user);
    void add(UserBean user);
}
