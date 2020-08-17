package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Comment;
import com.example.demo1.dao.CommentDao;
import com.example.demo1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService {
    private CommentDao commentDao;
   @Autowired
    public void setCommentDao(CommentDao commentDao) {

        this.commentDao= commentDao;
    }

    public List<Comment> getComment(int articleId){
        return  commentDao.getComment(articleId);
    }

    public boolean addComment(Comment comment){
       return commentDao.addComment(comment);
    }
}
