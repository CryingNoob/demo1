package com.example.demo1.bean;

public class Comment {
    int commentId,articleId,userid;

    String commentContent;


    String commentDate;
    String username;

    User user;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", articleId=" + articleId +
                ", userid=" + userid +
                ", commentContent='" + commentContent + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", username='" + username + '\'' +
                ", user=" + user +
                '}';
    }

    public int getuserid() {
        return userid;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }



    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//post请求，五个参数（article_id,comment_id,comment_content,comment_date,
    //user信息（一个对象）)

}
