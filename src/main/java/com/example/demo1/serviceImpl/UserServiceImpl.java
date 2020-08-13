package com.example.demo1.serviceImpl;

import com.example.demo1.bean.User;
import com.example.demo1.dao.UserDao;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;

    @Override
    public User login(User user){

        return userdao.login(user);
    }

    public int register(User user) {
        return userdao.register(user);
    }
}
