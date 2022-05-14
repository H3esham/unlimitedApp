package com.example.unlimitedApp.models;

public class Todo {

    private String id;
    private String title;
    private boolean status;

    public Todo(String title, boolean status) {
        // generate id for the item
        this.id = String.valueOf(System.currentTimeMillis());
        this.title = title;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
