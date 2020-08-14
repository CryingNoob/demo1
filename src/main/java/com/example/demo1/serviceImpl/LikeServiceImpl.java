package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Like;
import com.example.demo1.dao.LikeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikeServiceImpl {

    private LikeDao likeDao;
    @Resource
    public void setLikeDao(LikeDao likeDao){
        this.likeDao = likeDao;
    }
    public List<Like> getLike(int article){
        return  likeDao.getLike(article);
    }
}
