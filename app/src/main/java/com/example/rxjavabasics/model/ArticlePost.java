package com.example.rxjavabasics.model;


public class ArticlePost {
    private long userID;
    private long id;
    private String title;
    private String body;

    public ArticlePost(long userID, long id, String title, String body) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long value) {
        this.userID = value;
    }

    public long getID() {
        return id;
    }

    public void setID(long value) {
        this.id = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }
}
