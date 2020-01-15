package com.company;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    Library(){
        createBookList();
    }

    public void createBookList(){
        books.add(new Book("Fellowship of the Ring ","J R R Tolkien","Continuing the story begun in The Hobbit, this is the first part of Tolkien's epic masterpiece, The Lord of the Rings, featuring the definitive text and a detailed map of Middle-earth.Sauron, the Dark Lord, has gathered to him all the Rings of Power"));

        books.add(new Book("A Game of Thrones","George R.R. Martin","Winter is coming. Such is the stern motto of House Stark, the northernmost of the fiefdoms that owe allegiance to King Robert Baratheon in far-off King's Landing. There Eddard Stark of Winterfell rules in Robert's name."));

        books.add(new Book("Harry Potter and the Sorcerer's Stone","J.K. Rowling","After murdering Harry's parents, James and Lily Potter, evil Lord Voldemort puts a killing curse on Harry, then just a baby. The curse inexplicably reverses, defeating Voldemort and searing a lightning-bolt scar in the middle of the infant's forehead."));
    }

    public void showAllBooks(){
        for (Book book:books){
            System.out.println(book.getInfo());
        }
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }
}
