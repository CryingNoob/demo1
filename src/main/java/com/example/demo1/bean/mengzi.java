package com.example.demo1.bean;

public class mengzi {
    String chapter;

    public String getChapter() {
        return chapter;
    }

    @Override
    public String toString() {
        return "mengzi{" +
                "chapter='" + chapter + '\'' +
                ", paragraphs='" + paragraphs + '\'' +
                '}';
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(String paragraphs) {
        this.paragraphs = paragraphs;
    }

    String paragraphs;
}
