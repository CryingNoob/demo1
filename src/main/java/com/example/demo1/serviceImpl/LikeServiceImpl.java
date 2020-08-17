package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Like;
import com.example.demo1.dao.LikeDao;
import com.example.demo1.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikeServiceImpl  implements LikeService {

    private LikeDao likeDao;
    @Resource
    public void setLikeDao(LikeDao likeDao){
        this.likeDao = likeDao;
    }
    public List<Like> getLike(int article){
        return  likeDao.getLike(article);
    }
    //boolean addLike(int articleId, int userId);
    //    boolean deleteLike(int articleId, int userId);
    public boolean addLike(int articleId, int userId){
        return likeDao.addLike(articleId, userId);
    }
    public boolean deleteLike(int articleId, int userId){

        return likeDao.deleteLike(articleId, userId);
    }
}
