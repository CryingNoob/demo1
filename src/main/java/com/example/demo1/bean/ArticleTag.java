package com.example.demo1.bean;

public class ArticleTag {
    int id;
    int articleId;
    int tagId;

    @Override
    public String toString() {
        return "ArticleTag{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", tagId=" + tagId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }





}
