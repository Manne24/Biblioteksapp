package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {

    // Lista på böcker i biblioteket
    private List<Book> books = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    BookList() {
        createBookList();
    }


    public void createBookList() {
        books.add(new Book("Fellowship of the Ring ", "J R R Tolkien", "Continuing the story begun in The Hobbit, this is the first part of Tolkien's epic masterpiece, The Lord of the Rings, featuring the definitive text and a detailed map of Middle-earth.Sauron, the Dark Lord, has gathered to him all the Rings of Power",true));

        books.add(new Book("A Game of Thrones", "George R R  Martin", "Winter is coming. Such is the stern motto of House Stark, the northernmost of the fiefdoms that owe allegiance to King Robert Baratheon in far-off King's Landing. There Eddard Stark of Winterfell rules in Robert's name.",true));

        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "After murdering Harry's parents, James and Lily Potter, evil Lord Voldemort puts a killing curse on Harry, then just a baby. The curse inexplicably reverses, defeating Voldemort and searing a lightning-bolt scar in the middle of the infant's forehead.",true));
    }

    public void showAllBooks() {
        /*
        for (Book book:books){
            System.out.println(book.getInfo());
        } */

        for (int i = 0; i < books.size(); i++) {
            System.out.println("[" + (i + 1) + "]. " + books.get(i).getInfo());
        }
    }

    private int userInput(){
        while (true){
            try{
                System.out.println("Please Choose: [Number] ");
                return Integer.parseInt(input.nextLine());
            }catch (Exception e) {
                System.out.println("Not a Valid Input");
            }
        }
    }

    public void showDescriptionOfBook(){
        for (int i = 0; i < books.size(); i++) {
            System.out.println("[" + (i + 1) + "]. " + books.get(i).getInfo());
        }
        int userInput = userInput();
        if (userInput < 1 || userInput > books.size()) {
            System.out.println("Please Choose a Valid number");
            return;
        }
        System.out.println(books.get(userInput - 1).getDescription());
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void searchByAuthor() {
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

    public void searchByTitle() {
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
