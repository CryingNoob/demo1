package com.example.demo1.dao;

import com.example.demo1.bean.Article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleDao {
    @Select("select * from Article ")
        List<Article> getAllArticle();



}
