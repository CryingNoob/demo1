package com.example.demo1.dao;

import com.example.demo1.bean.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleDao {
    @Select("select * from Article ")
        List<Article> getAllArticle();


    //"Article{" +
    //                "id=" + id +
    //                ",articleAuthor="+articleAuthor+
    //
    //                ", articleTitle='" + articleTitle + '\'' +
    //                ", articleContent='" + articleContent + '\'' +
    //                ", articleDate='" + articleDate + '\'' +
    //                ", article_tag=" + article_tag.toString() +
    //
    //
    //                '}';
    @Insert("insert into Article(id,article_author_id,article_title,article_content,article_date) " +
            "values(#{id},#{articleAuthorId},#{articleTitle},#{articleContent},#{articleDate})")
    boolean addArticle(Article article);


}
