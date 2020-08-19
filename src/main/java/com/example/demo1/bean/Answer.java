package com.example.demo1.bean;

public class Answer {
    int answerId,userid,questionId;
    String answerContent,answerDate,username;

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", userid=" + userid +
                ", questionId=" + questionId +
                ", answerContent='" + answerContent + '\'' +
                ", answerDate='" + answerDate + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getuserid() {
        return userid;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }
}
