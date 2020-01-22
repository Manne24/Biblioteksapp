package com.company;

import java.util.Scanner;

public class Program {
    private Menu menu = new Menu();
    private Scanner input = new Scanner(System.in);
    private BookList library = new BookList();
    private MemberList members = new MemberList();
    private LibrarianList librarianList = new LibrarianList();
    private Person currentUser;


    Program() {
      showMenu();
    }


    public void showMenu() {
       menu.logInMenu();
    }




}
