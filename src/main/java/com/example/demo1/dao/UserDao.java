package com.example.demo1.dao;

import com.example.demo1.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {

//login
    @Select("select * from user  where user_name = #{userName} and user_password=#{userPassword}" )
//    @Results(value = {
//            @Result(property = "userName", column = "user_name"),
//            @Result(property = "userPassword", column = "user_password")})
    //where userName=#{userName} and userPassword=#{userPassword}
    User login(User user);
//register
    @Insert("insert into user (user_name, user_password) values(#{userName}, #{userPassword})")
    int  register(User user);


}
