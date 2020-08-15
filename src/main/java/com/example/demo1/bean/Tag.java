package com.example.demo1.bean;

public class Tag {
    int id;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                '}';
    }

    String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
