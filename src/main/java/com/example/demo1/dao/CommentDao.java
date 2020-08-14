package com.example.demo1.dao;

import com.example.demo1.bean.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentDao {
    @Select("select * from comment where Article_id = #{articleId}")
    List<Comment> getComment(int articleId) ;
}
