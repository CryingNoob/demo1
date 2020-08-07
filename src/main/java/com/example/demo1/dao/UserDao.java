package com.example.demo1.dao;

import com.example.demo1.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {


    @Select("select * from user where name=#{name} and password = #{password}")
    UserBean login(UserBean user);

    @Insert("insert into user(name, password) values(#{name}, #{password})")
    void insert(UserBean user);
}
