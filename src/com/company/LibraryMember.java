package com.company;

import java.util.Scanner;

public class LibraryMember extends Person {

    //Lista på Böckerna man lånar
    private BookList loanedBooks = new BookList();

    public LibraryMember(String name, String userName, String password) {
        super(name, userName, password);
    }

    /// TO DOOOOO!
    public void loanBook(Book book) {
        loanedBooks.addBook(book);
    }


}
