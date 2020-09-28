package com.example.todo.model;

import java.io.Serializable;

public class TodoItem implements Serializable {

    private static final long serialVersionUID = 7750532245828507798L;

    private long id;
    private String title;
    private boolean isCompleted;

    public TodoItem() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "TodoItem[id=" + this.id + ", title=" + this.title + ", isCompleted=" + this.isCompleted + "]";
    }

}
