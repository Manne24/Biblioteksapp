package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList implements Serializable {

    // Lista på böcker i biblioteket
    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return books;
    }


    public void showAllBooks() {
        for (Book book:books){
            System.out.println(book.getInfo());
        }if (books.isEmpty()){
            System.out.println("You have no books ");
        }
    }


    public void showDescriptionOfBook(Book book){
        book.getDescription();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void searchByBookOrAuthor(){
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while(run){
            System.out.println("[1] To Search for BookTitle");
            System.out.println("[2] To Search for Author");
            System.out.println("[0] To Go Back ");

            String userChoice = input.nextLine();

            switch (userChoice) {
                case "1":
                    searchByTitle();
                    break;
                case "2":
                    searchByAuthor();
                    break;
                case "0":
                    run = false;
                default:
                    System.out.println("Please Enter a valid number ");
            }

        }

    }

    private void searchByAuthor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The Name of the Author: ");
        String userInput = input.nextLine();
        ArrayList<String> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(userInput.toLowerCase()) && book.getAvailable()){
                result.add(book.getAuthor());
            }
        }
        if (result.isEmpty()){
            System.out.println("The Author was not found");
        }else {
            System.out.println("The Author was found: ");
            for (String author: result){
                System.out.println(author);
            }
            input.nextLine();
        }
    }

    private void searchByTitle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The Name of the Book: ");
        String userInput = input.nextLine();
        ArrayList<String> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(userInput.toLowerCase()) && book.getAvailable()){
                result.add(book.getTitle());
            }
        }
        if (result.isEmpty()){
            System.out.println("The Book was not found");
        }else {
            System.out.println("The Book was found: ");
            for (String book: result){
                System.out.println(book);
            }
            input.nextLine();
        }
    }

    public void showAvailableBooks(){
        for (Book book: books) {
            if (book.getAvailable()) {
                System.out.println(book.getInfo());
            }
        }
    }

    public void showBorrowedBooks(){
        for (Book book: books) {
            if (!book.getAvailable()) {
                System.out.println(book.getInfo());
            }
        }
    }
}
