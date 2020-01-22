package com.company;


public class LibraryMember extends Person {

    //Lista på Böckerna man lånar
    private BookList loanedBooks = new BookList();


    public LibraryMember(String name, String userName, String password) {
        super(name, userName, password);
    }


    public void loanBook(Book book) {
        loanedBooks.addBook(book);
    }




}
