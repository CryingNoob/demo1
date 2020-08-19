package com.example.demo1.bean;

import java.util.List;

public class Article {




    int articleId,articleAuthorId,likeNumber,collectNumber,commentNumber;
    String articleTitle;
    String articleContent;
    String articleDate;
    String articleAuthor;
    String username;

    List<Tag> article_tag;

    List<User> like_users,collect_user;
    List<Comment> comment_content;

    public int getArticleId() {
        return articleId;
    }

    public void setSrticleId(int id) {
        this.articleId=articleId;
    }

    public int getArticleAuthorId() {
        return articleAuthorId;
    }

    public void setArticleAuthorId(int articleAuthorId) {
        this.articleAuthorId = articleAuthorId;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(int collectNumber) {
        this.collectNumber = collectNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public List<Tag> getArticle_tag() {
        return article_tag;
    }

    public void setArticle_tag(List<Tag> article_tag) {
        this.article_tag = article_tag;
    }


    public List<User> getLike_users() {
        return like_users;
    }

    public void setLike_users(List<User> like_users) {
        this.like_users = like_users;
    }

    public List<User> getCollect_user() {
        return collect_user;
    }

    public void setCollect_user(List<User> collect_user) {
        this.collect_user = collect_user;
    }

    public List<Comment> getComment_content() {
        return comment_content;
    }

    public void setComment_content(List<Comment> comment_content) {
        this.comment_content = comment_content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +

                ",articleAuthor="+articleAuthor+
                ", likeNumber=" + likeNumber +
                ", collectNumber=" + collectNumber +
                ", commentNumber=" + commentNumber +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate='" + articleDate + '\'' +
                ", article_tag=" + article_tag.toString() +

                ", like_users=" + like_users.toString() +
                ", collect_user=" + collect_user.toString() +
                ", comment_content=" + comment_content.toString() +
                '}';
    }

    public String toString2() {
        return "Article{" +
                "articleId=" + articleId +
                ",articleAuthor="+articleAuthor+

                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate='" + articleDate + '\'' +
                ", article_tag=" + article_tag.toString() +


                '}';
    }


}
