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
    @Select("select * from user  where username = #{username} and password=#{password}" )
//    @Results(value = {
//            @Result(property = "username", column = "user_name"),
//            @Result(property = "password", column = "user_password")})
    //where username=#{username} and password=#{password}
    User login(User user);
    @Select("select * from user where userid = #{id}")
    User getUser(int id);
    @Select("select * from user where username = #{username}")
    User getUserByName(String username);
//register
    @Insert("insert into user (username, password) values(#{username}, #{password})")
    int  register(User user);


}
