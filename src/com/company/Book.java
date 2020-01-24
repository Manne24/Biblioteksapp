package com.company;

import java.io.Serializable;

public class Book  implements Serializable {
    private String title;
    private String author;
    private String description;
    private Boolean available;

    public Book(String title, String author, String description,boolean available) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void getDescription() {
        System.out.println(description);
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

    public String getInfo() {
        return "Book Author: " + getAuthor() + " \n" + "Book Title: " + getTitle();
    }
}
