package com.example.demo1.service;

import com.example.demo1.bean.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<Comment> getComment(int articleId) ;
    boolean addComment(Comment comment);
}
