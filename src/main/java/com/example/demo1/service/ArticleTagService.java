package com.example.demo1.service;

import com.example.demo1.bean.ArticleTag;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleTagService {
    List<ArticleTag> getArticleTag(int id);
    boolean insertArticleTag(ArticleTag articleTag);
}
