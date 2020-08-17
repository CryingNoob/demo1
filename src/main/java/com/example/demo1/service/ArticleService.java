package com.example.demo1.service;

import com.example.demo1.bean.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
    boolean addArticle(Article article);
}
