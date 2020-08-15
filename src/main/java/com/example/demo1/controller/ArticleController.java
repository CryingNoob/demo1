package com.example.demo1.controller;


import com.example.demo1.bean.*;
import com.example.demo1.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {

    private CommentService commentService;
    @Resource
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    private LikeService likeService;
    @Resource
    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }
    private CollectService collectService;
    @Resource
    public void setCollectService(CollectService collectService) {
        this.collectService = collectService;
    }
    private TagService tagService;
    @Resource
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }
    private ArticleTagService articleTagService;
    @Autowired
    public void setArticle_tags(ArticleTagService articleTagService) {
        this.articleTagService = articleTagService;
    }
    private UserService userService;
    @Autowired
    public  void setUserService(UserService userService){
        this.userService = userService;
    }
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

//（文章id，article_title,article_author,article_content,
//article_date(YYYY-MM-DD格式),article_tag(对象数组))
    @PostMapping("/article/addArticle")
    public boolean addArticle(@RequestBody Article article){
        System.out.println(article.toString());



        return false;
    }


    @GetMapping("/article/getAllArticles")
    public String getAllArticle(){
        ArrayList<Article> articleList;
        List<Tag> article_tags=new ArrayList<>();
        User article_author=new User();
        List<User> like_users=new ArrayList<>(),collect_users=new ArrayList<>();
        List<Comment> comment_content=new ArrayList<>();
        try {
            articleList = new ArrayList<>(articleService.getAllArticle());

            if (articleList==null)
                return  "null";
            else
            {

                for (Article a :articleList) {

                    a.setArticle_author(userService.getUser(a.getArticleId()));
                    List<ArticleTag> articleTagList=articleTagService.getArticleTag(a.getArticleId());

                    for(ArticleTag articleTagI:articleTagList){
                        article_tags.add(tagService.getTag(articleTagI.getTagId()));
                    }
                    a.setArticle_tags(article_tags);

                    List<Like> likeList=likeService.getLike(a.getArticleId());
                    for(Like like:likeList){
                        like_users.add(userService.getUser(like.getUserId()));
                    }
                    a.setLike_users(like_users);

                    List<Collect> collectList = collectService.getCollect(a.getArticleId());
                    for(Collect collect:collectList){
                        collect_users.add(userService.getUser(collect.getUserId()));
                    }
                    a.setCollect_user(collect_users);

                    comment_content = commentService.getComment(a.getArticleId());
                    a.setComment_content(comment_content);

                }
                for(Article a: articleList)
                System.out.println(a.toString());
            }
        }catch ( Exception e){
            e.printStackTrace();
            return "error";
        }
        return articleList.toString();
    }
}
