package com.example.demo1.serviceImpl;

import com.example.demo1.bean.User;
import com.example.demo1.dao.UserDao;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;

    }

    public User login(User user){

        return userDao.login(user);
    }

    public int register(User user) {
        return userDao.register(user);
    }
}
