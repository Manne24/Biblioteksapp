package com.company;

import java.util.Scanner;

public class Menu {

    Menu() {
        logInMenu();
    }

    private BookList library = new BookList();
    private Scanner input = new Scanner(System.in);



    public void logInMenu() {
        boolean continueToRun = true;

        while (continueToRun) {
            System.out.println("Welcome To MannesLibrary");
            System.out.println("---------------------------");
            System.out.println("Please Choose a Option");
            System.out.println("Press [1] Login Library Member");
            System.out.println("Press [2] Login Library Libririan");
            System.out.println("Press [3] Register New Member");
            System.out.println("Press [0] to <EXIT>");


            String userChoice = input.nextLine();


            switch (userChoice) {

                case "1":
                    showMemberMenu();
                    break;
                case "2":
                    showAdminMenu();
                    break;
                case "3":
                    System.out.println("Please Enter The Name of the Author: ");
                    library.searchByAuthor();
                    break;
                case "0":
                    continueToRun = false;
                    break;
                default:
                    System.out.println("Please enter a Number Between 1-3 [Enter]");
                    input.nextLine();
                    break;
            }
        }
    }


    public void showMemberMenu() {

        boolean continueToRun = true;

        System.out.println("Hello, ---->Member<----");
        System.out.println("---------------------------");
        while (continueToRun) {
            System.out.println("Press [1] Return Loaned Book");
            System.out.println("Press [2] Show All Available Books");
            System.out.println("Press [3] Show All Books");
            System.out.println("Press [4] Search for Book");
            System.out.println("Press [5] Barrow Book");
            System.out.println("Press [6] My Loaned Books");
            System.out.println("Press [0] <-- Go Back");


            String userChoice = input.nextLine();


            switch (userChoice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    library.showAllBooks();
                    input.nextLine();
                    break;
                case "4":

                    break;
                case "5":
                    System.out.println("Which book do you want to borrow");
                    library.showAllBooks();
                    break;
                case "6":

                    break;
                case "0":
                    continueToRun = false;
                    break;
                default:
                    System.out.println("Please enter a Number Between 1-6");
                    input.nextLine();
                    break;
            }
        }
    }

    public void showAdminMenu() {

        boolean continueToRun = true;

        while (continueToRun) {
            System.out.println("Hello, ---->Admin<----");
            System.out.println("---------------------------");
            System.out.println("Press [1] Show Borrowed Books");
            System.out.println("Press [2] Add Book");
            System.out.println("Press [3] Remove Book");
            System.out.println("Press [4] Show Library Members");
            System.out.println("Press [5] Search For Member");
            System.out.println("Press [6] Show Members Borrowed Book");
            System.out.println("Press [0] <-- Go Back");


            String userChoice = input.nextLine();


            switch (userChoice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "0":
                    continueToRun = false;
                    break;
                default:
                    System.out.println("Please enter a Number Between 1-6");
                    input.nextLine();
                    break;
            }
        }
    }
}
