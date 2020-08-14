package com.example.demo1.serviceImpl;

import com.example.demo1.bean.Article;
import com.example.demo1.dao.ArticleDao;
import com.example.demo1.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao;
    @Autowired
    public void setArticleDao(ArticleDao articleDao){
        this.articleDao=articleDao;
    }
    @Override
    public List<Article> getAllArticle() {
        return articleDao.getAllArticle();
    }
}
