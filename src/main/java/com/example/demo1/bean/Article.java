package com.example.demo1.bean;

public class Article {

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleAuthorId=" + articleAuthorId +
                ", likeNumber=" + likeNumber +
                ", collectNumber=" + collectNumber +
                ", commentNumber=" + commentNumber +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate='" + articleDate + '\'' +
                '}';
    }

    int articleId,articleAuthorId,likeNumber,collectNumber,commentNumber;
    String articleTitle,articleContent,articleDate;
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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


}
