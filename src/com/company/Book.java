package com.company;

public class Book {
    private String title;
    private String author;
    private String description;
    private Boolean availble;

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.availble = false;
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

    public Boolean getAvailble() {
        return availble;
    }

    public void setAvailble(Boolean availble) {
        this.availble = availble;
    }

    public String getInfo(){
        return "Author: " + getAuthor() + " \n" + "Title: " +  getTitle();
    }
}
