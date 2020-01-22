package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarianList {

    // Lista på Användare i biblioteket
    private List<Librarian> librarians  = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    LibrarianList(){
        addLibrarian();
    }

    private void addLibrarian() {
        librarians.add(new Librarian("admin","admin","admin"));
    }

    public void showLibrarian(){
        for (Librarian librarian : librarians){
            System.out.println(librarian);
        }
    }
}
