package com.example.demo1.bean;

public class LikeAndCollect {
    public int getUserI() {
        return userI;
    }

    public void setUserI(int userI) {
        this.userI = userI;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getLikeOrCollect() {
        return likeOrCollect;
    }

    public void setLikeOrCollect(int likeOrCollect) {
        this.likeOrCollect = likeOrCollect;
    }

    int userI, articleId,likeOrCollect;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

}
