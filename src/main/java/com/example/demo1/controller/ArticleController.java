package com.example.demo1.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import java.util.Map;

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

    @PostMapping(value="/article/addArticle",consumes = "application/json")
    public boolean addArticle(@RequestBody Article article){

        try {
            System.out.println(article.toString2());
            System.out.println(article.getArticleAuthor());
            System.out.println(userService.getUserByName(article.getArticleAuthor()));
            System.out.println(userService.getUserByName(article.getArticleAuthor()).getuserid());
            article.setArticleAuthorId(userService.getUserByName(article.getArticleAuthor()).getuserid());
            articleService.addArticle(article);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error at /article/addArticle ");
            return false;
        }
        return true;
    }
//    @PostMapping(value="/article/addArticle",consumes = "application/json")
//    public boolean addArticle(@RequestBody Map<String,Object> article){
//
//        System.out.println(article);
//
//
//
//        return false;
//    }

//    @PostMapping(value="/article/addArticle")
//    public boolean addArticle(@RequestBody JSONObject article){
//        System.out.println(article.toString());
//    return true;
//    }

    @GetMapping("/article/getAllArticles")
    public List<Article> getAllArticle(){
        ArrayList<Article> articleList;

        User article_author=new User();
        List<User> like_users=new ArrayList<>(),collect_users=new ArrayList<>();
        List<Comment> comment_content=new ArrayList<>();
        try {
            articleList = new ArrayList<>(articleService.getAllArticle());

            if (articleList==null)
                return  null;
            else
            {

                for (Article a :articleList) {

                    List<Tag> article_tags=new ArrayList<>();
                    a.setArticleAuthor(userService.getUser(a.getArticleAuthorId()).getusername());
                    List<ArticleTag> articleTagList=articleTagService.getArticleTag(a.getArticleId());

                    for(ArticleTag articleTagI:articleTagList){
                        System.out.print( "arid"+a.getArticleId()+" tag"+articleTagI+"tmp1");
                        Tag tmp1=new Tag();
                        int tmp2=articleTagI.getTagId();
                               tmp1 =tagService.getTag(tmp2);
                        System.out.println(tmp1+"tmp2"+tmp2);

                        article_tags.add(tmp1);
                    }
                    System.out.println(article_tags);
                    a.setArticle_tag(article_tags);
                    System.out.println("\n\n");



                    List<Like> likeList=likeService.getLike(a.getArticleId());
                    for(Like like:likeList){

                        like_users.add(userService.getUser(like.getuserid()));
                    }
                    User testUser=new User();

                    a.setLike_users(like_users);

                    List<Collect> collectList = collectService.getCollect(a.getArticleId());
                    for(Collect collect:collectList){
                        User tmpU=new User();
                        tmpU=userService.getUser(collect.getuserid());
                        System.out.println(tmpU);
                        collect_users.add(tmpU);
                    }
                    a.setCollect_user(collect_users);

                    comment_content = commentService.getComment(a.getArticleId());

                    for(Comment comment:comment_content){

                        comment.setusername(userService.getUser(comment.getuserid()).getusername());
                    }

                    a.setComment_content(comment_content);

                }
                for(Article a: articleList)
                System.out.println(a.toString());
            }
        }catch ( Exception e){
            e.printStackTrace();
            return null;
        }
        return articleList;
    }


    @PostMapping("article/likeArticle")
    public boolean likeArticle(@RequestBody Map<String, Object> json){
        System.out.println(json);
        try{
            //User user= (User)json.get("user");
            User user = JSON.parseObject(JSON.toJSONString(json.get("user")),User.class);
            System.out.println(user.toString());
            int articleId = (int) json.get("article_id");
            boolean isLiked = (boolean) json.get("isliked");
            System.out.println(articleId);
            System.out.println(isLiked);

            if(isLiked){

                likeService.deleteLike(articleId,user.getuserid());
            }else{
                likeService.addLike(articleId,user.getuserid());
            }
        }catch ( Exception e){

            System.out.println("error at likeArticle");
            e.printStackTrace();

        }

        return true;
    }

    @PostMapping("article/collectArticle")
    public boolean collectArticle(@RequestBody Map<String, Object> json){
        System.out.println(json);
        try{
            //User user= (User)json.get("user");
            User user = JSON.parseObject(JSON.toJSONString(json.get("user")),User.class);
            System.out.println(user.toString());
            int articleId = (int) json.get("article_id");
            boolean isLiked = (boolean) json.get("iscollected");
            System.out.println(articleId);
            System.out.println(isLiked);

            if(isLiked){

                collectService.deleteCollect(articleId,user.getuserid());
            }else{
                collectService.addCollect(articleId,user.getuserid());
            }
        }catch ( Exception e){

            System.out.println("error at collectArticle");
            e.printStackTrace();

        }

        return true;
    }

//    @PostMapping("article/commentArticle")
//    public boolean commentArticle(@RequestBody Map<String, Object> json){
//        //post请求，五个参数（article_id,comment_id,comment_content,comment_date,
//        //user信息（一个对象）)
//        try{
//            User user;
//            int userid,articleId,commentId;
//            String commentContent,commentDate;
//
//            user=(User)json.get("user");
//            userid =user.getuserid();
//            commentId=(int) json.get("comment_id");
//            articleId = (int) json.get("article_id");
//            commentContent= (String) json.get("comment_content");
//            commentDate= (String) json.get("comment_date");
//
//
//        }catch ( Exception e){
//            e.printStackTrace();
//        }
//
//return true;
//    }

    @PostMapping("article/commentArticle")
    public boolean commentArticle(@RequestBody Comment comment){

        try{
            System.out.println(comment);
            comment.setuserid(comment.getUser().getuserid());
           boolean re= commentService.addComment(comment);

           return re;

        }catch ( Exception e){
            System.out.println("error at comment");
            e.printStackTrace();
            return false;
        }

    }
}
