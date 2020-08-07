package com.example.demo1.serviceImpl;

import com.example.demo1.bean.UserBean;
import com.example.demo1.dao.UserDao;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userdao;

    public UserBean login(UserBean user){
        return userdao.login(user);
    }

    public void add(UserBean userBean) {
        userdao.insert(userBean);
    }
}
