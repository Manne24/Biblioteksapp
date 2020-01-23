package com.company;

import java.util.Scanner;

public class Program {

    private Scanner input = new Scanner(System.in);
    private BookList library = new BookList();
    private MemberList members = new MemberList();
    private LibrarianList librarians = new LibrarianList();
    private LibraryMember currentUser;
    private Librarian currentAdmin;

    Program() {
       library.addBook(new Book("Fellowship of the Ring ", "J R R Tolkien", "Continuing the story begun in The Hobbit, this is the first part of Tolkien's epic masterpiece, The Lord of the Rings, featuring the definitive text and a detailed map of Middle-earth.Sauron, the Dark Lord, has gathered to him all the Rings of Power",true));

        library.addBook(new Book("A Game of Thrones", "George R R  Martin", "Winter is coming. Such is the stern motto of House Stark, the northernmost of the fiefdoms that owe allegiance to King Robert Baratheon in far-off King's Landing. There Eddard Stark of Winterfell rules in Robert's name.",true));

        library.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "After murdering Harry's parents, James and Lily Potter, evil Lord Voldemort puts a killing curse on Harry, then just a baby. The curse inexplicably reverses, defeating Voldemort and searing a lightning-bolt scar in the middle of the infant's forehead.",true));
        logInMenu();
    }

    private int userInput(){
        int userInt;
        while (true){
            try{
                System.out.println("Please Choose: [Number] ");
                userInt = Integer.parseInt(input.nextLine());
                break;
            }catch (Exception e) {
                System.out.println("Not a Valid Input");
            }
        }return userInt;
    }


    private void logInMenu() {
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
                    memberLogIn();
                    break;
                case "2":
                    adminLogIn();
                    break;
                case "3":
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

    private void memberLogIn() {
        while (true) {
            System.out.println("Please Enter your Username: ");
            String username = input.nextLine();
            for (LibraryMember member : members.getMembers()) {
                if (username.equals(member.getUserName())) {
                    System.out.println("PLease Enter your Password");
                    String password = input.nextLine();
                    if (password.equals(member.getPassword())) {
                        currentUser = member;
                        showMemberMenu();
                        break;
                    }
                }
            }
        }
    }

    private void loanedBook(){
        for (int i = 0; i < library.getBooks().size(); i++) {
            System.out.println("[" + (i + 1) + "]. " + library.getBooks().get(i).getInfo());
        }
        int userInput = userInput();
        if (userInput < 1 || userInput > library.getBooks().size()) {
            System.out.println("Please Choose a Valid number");
        }else {
            library.getBooks().get(userInput - 1).setAvailable(false);
            currentUser.loanBook(library.getBooks().get(userInput - 1));
            System.out.println("You have loaned " + library.getBooks().get(userInput - 1).getInfo() );

        }
    }

    private void returnBook(){
        for (int i = 0; i < currentUser.getLoanedBooks().getBooks().size(); i++) {
            System.out.println("[" + (i + 1) + "]. " + currentUser.getLoanedBooks().getBooks().get(i).getInfo());
        }
        int userInput = userInput();
        if (userInput < 1 || userInput > currentUser.getLoanedBooks().getBooks().size()) {
            System.out.println("Please Choose a Valid number");
        }else {
            // Vi använder userinput som index för att sedan hämta boken och för att jämföra den.
            // vi får en ny index som stämmer överens med Library
            int index = library.getBooks().indexOf(currentUser.getLoanedBooks().getBooks().get(userInput - 1));
            library.getBooks().get(index).setAvailable(true);
            currentUser.returnBook(currentUser.getLoanedBooks().getBooks().get(userInput - 1));
            System.out.println("Returned " + library.getBooks().get(index).getInfo() );
        }
    }

    private void showDescriptionOfBook(){
        for (int i = 0; i <library.getBooks().size(); i++) {
            System.out.println("[" + (i + 1) + "]. " + library.getBooks().get(i).getInfo());
        }
        int userInput = userInput();
        if (userInput < 1 || userInput > library.getBooks().size()) {
            System.out.println("Please Choose a Valid number");
        }else{
                library.showDescriptionOfBook(library.getBooks().get(userInput - 1));
        }
    }


    private void showMemberMenu() {

        boolean continueToRun = true;

        System.out.println("Hello " + currentUser.getName() + "!");
        System.out.println("---------------------------");
        while (continueToRun) {
            System.out.println("Press [1] Return Loaned Book");
            System.out.println("Press [2] Show All Available Books");
            System.out.println("Press [3] Show All Books and Description");
            System.out.println("Press [4] Search for Book");
            System.out.println("Press [5] Barrow Book");
            System.out.println("Press [6] My Loaned Books");
            System.out.println("Press [0] <-- Go Back");


            String userChoice = input.nextLine();


            switch (userChoice) {
                case "1":
                    returnBook();
                    input.nextLine();
                    break;
                case "2":
                    library.showAvailableBooks();
                    input.nextLine();
                    break;
                case "3":
                    showDescriptionOfBook();
                    input.nextLine();
                    break;
                case "4":
                    library.searchByTitle();
                    break;
                case "5":
                    loanedBook();
                    input.nextLine();
                    break;
                case "6":
                    currentUser.showBorrowedBook();
                    input.nextLine();
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

    private void adminLogIn() {
        while (true) {
            System.out.println("Please Enter your Username: ");
            String username = input.nextLine();
            for (Librarian librarian : librarians.getLibrarians()) {
                if (username.equals(librarian.getUserName())) {
                    System.out.println("Please Enter your Password: ");
                    String password = input.nextLine();
                    if (password.equals(librarian.getPassword())) {
                        currentAdmin = librarian;
                        showAdminMenu();
                        break;
                    }
                }
            }
        }
    }

    private void addBookToLibrary(){
        String title;
        String author;
        String description;
        System.out.println("Please Enter the title of the book: ");
        title = input.nextLine();
        System.out.println("Please Enter the author of the book: ");
        author = input.nextLine();
        System.out.println("Please Enter a description about the book: ");
        description = input.nextLine();
        library.addBook(new Book(title,author,description,true));
        System.out.println("You have added " + library.getBooks().get(library.getBooks().size() - 1).getInfo());

    }

    private void showAdminMenu() {

        boolean continueToRun = true;

        while (continueToRun) {
            System.out.println("Hello, " + currentAdmin.getName());
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
                    library.showBorrowedBooks();
                    input.nextLine();
                    break;
                case "2":
                    addBookToLibrary();
                    break;
                case "3":
                    library.removeBook();
                    break;
                case "4":
                    members.showMembers();
                    input.nextLine();
                    break;
                case "5":
                    members.searchForMember();
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
