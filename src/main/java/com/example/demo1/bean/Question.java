package com.example.demo1.bean;

import java.util.List;

public class Question {
    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionAuthor='" + questionAuthor + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", questionDate='" + questionDate + '\'' +
                ", answerNumber=" + answerNumber +
                ", questionTag=" + questionTag.toString() +
                ", answerContent=" + answerContent.toString() +
                '}';
    }

    int questionId;
    String questionAuthor;
    String questionContent;
    String questionDate;
    int answerNumber;
    List<Tag> questionTag;
    List<Answer> answerContent;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionAuthor() {
        return questionAuthor;
    }

    public void setQuestionAuthor(String questionAuthor) {
        this.questionAuthor = questionAuthor;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(String questionDate) {
        this.questionDate = questionDate;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public List<Tag> getQuestionTag() {
        return questionTag;
    }

    public void setQuestionTag(List<Tag> questionTag) {
        this.questionTag = questionTag;
    }

    public List<Answer> getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(List<Answer> answerContent) {
        this.answerContent = answerContent;
    }
}
