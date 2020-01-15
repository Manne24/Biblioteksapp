package com.company;

import java.util.Scanner;

public class LibraryMember extends Person {

    private BookList loanedBooks = new BookList();

    public LibraryMember(String name, String userName, String password) {
        super(name, userName, password);
    }
/// TO DOOOOO! 
    public void loanBook(Book book){
        Scanner input = new Scanner(System.in);
        System.out.println("Which Book do you want to borrow");

        loanedBooks.addBook(book);
    }


}
