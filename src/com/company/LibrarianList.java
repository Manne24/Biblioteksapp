package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LibrarianList implements Serializable {

    // Lista på Bibliotikare i biblioteket
    private List<Librarian> librarians  = new ArrayList<>();

    LibrarianList(){
        addLibrarian();
    }

    private void addLibrarian() {
        librarians.add(new Librarian("admin","admin","admin"));
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }
}

