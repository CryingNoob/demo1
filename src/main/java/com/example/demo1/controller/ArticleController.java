package com.example.demo1.controller;


import com.example.demo1.bean.Article;
import com.example.demo1.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public  void setArticleService(ArticleService articleService){
            this.articleService=articleService;
    }


//    @GetMapping("/getAllArticle")
//    public String getAllArticle(){
//        List<Article> articleList = new ArrayList<>();
//        try {
//            articleList = articleService.getAllArticle();
//            if (articleList==null)
//                return  "null";
//            else
//            {
//                System.out.println(articleList.toString());
//                return articleList.toString();
//            }
//
//        }catch ( Exception e){
//            e.printStackTrace();
//
//            return "error";
//        }
//
//    }

/*
 int articleId,articleAuthorId,likeNumber,collectNumber,commentNumber;
    String articleTitle,articleContent,articleDate;

    List<Tag> article_tags;
    User article_author;
    List<User> like_users,collect_user;
    List<Comment> comment_content;
 */

    @GetMapping("/getAllArticle")
    public String getAllArticle(){
        List<Article> articleList ;
        try {
            articleList = articleService.getAllArticle();
            if (articleList==null)
                return  "null";
            else
            {
                System.out.println(articleList.toString());

            }

        }catch ( Exception e){
            e.printStackTrace();

            return "error";
        }
        return articleList.toString();
    }
}
