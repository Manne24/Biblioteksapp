package com.company;

public class Book {
    private String title;
    private String author;
    private String description;
    private Boolean available;

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.available = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getInfo(){
        return "Author: " + getAuthor() + " \n" + "Title: " +  getTitle();
    }
}
