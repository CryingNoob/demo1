package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Comment;
import com.example.demo1.dao.CommentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl {
    private CommentDao commentDao;
    @Resource
    public void setCommentDao(CommentDao commentDao)
    {
        this.commentDao= commentDao;
    }

    List<Comment> getComment(int articleId){
        return  commentDao.getComment(articleId);
    }
}
