package com.company;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

public class Program implements Serializable {

    private transient Scanner input = new Scanner(System.in);
    private BookList libraryBooks = new BookList();
    private libraryMemberList members = new libraryMemberList();
    private LibrarianList librarians = new LibrarianList();
    private LibraryMember currentUser;
    private Librarian currentAdmin;

    Program() {

        loadProgram();
        logInMenu();

    }

    private int userInput() {
        int userInt;
        while (true) {
            try {
                System.out.println("Please Choose: [Number] or Press [0] To go Back ");
                userInt = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Not a Valid Input");
            }
        }
        return userInt;
    }

    private void registerNewMember() {
        String name;
        String userName;
        String passWord;
        System.out.println("Please Enter the your Name: ");
        name = input.nextLine();
        System.out.println("Please Enter A UserName: ");
        userName = input.nextLine();
        System.out.println("Please Enter a Password ");
        passWord = input.nextLine();
        members.addMembers(new LibraryMember(name, userName, passWord));
        FileUtility.saveObject("members.ser", members);
        System.out.println("Welcome " + members.getMembers().get(members.getMembers().size() - 1).getName());
        System.out.println("Your Username: " + members.getMembers().get(members.getMembers().size() - 1).getUserName());
        System.out.println("Your Password: " + members.getMembers().get(members.getMembers().size() - 1).getPassword());
        System.out.println("Press Enter to Continue....");
        input.nextLine();
        logInMenu();
    }


    private void logInMenu() {

        while (true) {
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
                    registerNewMember();
                    break;
                case "0":
                    System.exit(0);
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
                    System.out.println("Please Enter your Password: ");
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

    private void loanedBook() {
        for (int i = 0; i < libraryBooks.getBooks().size(); i++) {
            if (libraryBooks.getBooks().get(i).getAvailable()) {
                System.out.println("[" + (i + 1) + "]. " + libraryBooks.getBooks().get(i).getInfo());
            }
        }
        int userInput = userInput();
        if (userInput < 1 || userInput > libraryBooks.getBooks().size()) {
            System.out.println("Going Back.....[Enter]");
        } else {
            libraryBooks.getBooks().get(userInput - 1).setAvailable(false);
            currentUser.loanBook(libraryBooks.getBooks().get(userInput - 1));
            System.out.println("You have loaned " + libraryBooks.getBooks().get(userInput - 1).getInfo());
        }
    }

    private void returnBook() {
        if (currentUser.getLoanedBooks().getBooks().isEmpty()) {
            System.out.println("You have no books to return");
        } else {
            for (int i = 0; i < currentUser.getLoanedBooks().getBooks().size(); i++) {
                System.out.println("[" + (i + 1) + "]. " + currentUser.getLoanedBooks().getBooks().get(i).getInfo());
            }
            int userInput = userInput();
            if (userInput < 1 || userInput > currentUser.getLoanedBooks().getBooks().size()) {
                System.out.println("Going Back.....[Enter]");
            } else {
                //söker index av användarens lånade böcker
                int index = currentUser.getLoanedBooks().getBooks().indexOf(currentUser.getLoanedBooks().getBooks().get(userInput - 1));
                libraryBooks.getBooks().get(index).setAvailable(true);
                currentUser.returnBook(currentUser.getLoanedBooks().getBooks().get(userInput - 1));
                System.out.println("Returned " + libraryBooks.getBooks().get(index).getInfo());
            }
        }
    }

    private void showDescriptionOfBook() {
        for (int i = 0; i < libraryBooks.getBooks().size(); i++) {
            System.out.println("[" + (i + 1) + "]. " + libraryBooks.getBooks().get(i).getInfo());
        }
        int userInput = userInput();
        if (userInput < 1 || userInput > libraryBooks.getBooks().size()) {
            System.out.println("Going Back.....[Enter]");
        } else {
            libraryBooks.showDescriptionOfBook(libraryBooks.getBooks().get(userInput - 1));
        }
    }


    private void showMemberMenu() {


        System.out.println("Hello " + currentUser.getName() + "!");
        System.out.println("---------------------------");
        while (true) {
            System.out.println("Press [1] Return Loaned Book");
            System.out.println("Press [2] Show All Available Books");
            System.out.println("Press [3] Show All Books and Description");
            System.out.println("Press [4] Search for Book by Title or Author");
            System.out.println("Press [5] Barrow Book");
            System.out.println("Press [6] My Loaned Books");
            System.out.println("Press [0] Save and Exit");


            String userChoice = input.nextLine();


            switch (userChoice) {
                case "1":
                    returnBook();
                    input.nextLine();
                    break;
                case "2":
                    libraryBooks.showAvailableBooks();
                    input.nextLine();
                    break;
                case "3":
                    showDescriptionOfBook();
                    input.nextLine();
                    break;
                case "4":
                    libraryBooks.searchByBookOrAuthor();
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
                    exitAndSave();
                    System.exit(0);
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

    private void addBookToLibrary() {
        String title;
        String author;
        String description;
        System.out.println("Please Enter the title of the book: ");
        title = input.nextLine();
        System.out.println("Please Enter the author of the book: ");
        author = input.nextLine();
        System.out.println("Please Enter a description about the book: ");
        description = input.nextLine();
        libraryBooks.addBook(new Book(title, author, description, true));
        System.out.println("You have added " + libraryBooks.getBooks().get(libraryBooks.getBooks().size() - 1).getInfo());
        input.nextLine();
    }

    private void removeBookFromLibrary() {
        for (int i = 0; i < libraryBooks.getBooks().size(); i++) {
            System.out.println("[" + (i + 1) + "]. " + libraryBooks.getBooks().get(i).getInfo());
        }
        System.out.println("Which Book do you want to DELETE ?");
        int userInput = userInput();
        if (userInput < 1 || userInput > libraryBooks.getBooks().size()) {
            System.out.println("Going Back.....[Enter]");
            input.nextLine();
        } else {
            Book book = libraryBooks.getBooks().get(userInput - 1);
            libraryBooks.removeBook(book);
            System.out.println("You have deleted " + book.getInfo());
            input.nextLine();
        }
    }

    private void showAdminMenu() {


        while (true) {
            System.out.println("Hello, " + currentAdmin.getName());
            System.out.println("---------------------------");
            System.out.println("Press [1] Show Borrowed Books");
            System.out.println("Press [2] Add Book");
            System.out.println("Press [3] Remove Book");
            System.out.println("Press [4] Show Library Members");
            System.out.println("Press [5] Search For Member");
            System.out.println("Press [0] Save and Exit");


            String userChoice = input.nextLine();


            switch (userChoice) {
                case "1":
                    libraryBooks.showBorrowedBooks();
                    input.nextLine();
                    break;
                case "2":
                    addBookToLibrary();
                    break;
                case "3":
                    removeBookFromLibrary();
                    break;
                case "4":
                    members.showMembers();
                    input.nextLine();
                    break;
                case "5":
                    members.searchForMember();
                    input.nextLine();
                    break;
                case "0":
                    exitAndSave();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a Number Between 1-6");
                    input.nextLine();
                    break;
            }
        }
    }


    private void loadProgram() {
        if (new File("library_Books.ser").isFile()) {
            System.out.println("Load library");
            libraryBooks = (BookList) FileUtility.loadObject("library_Books.ser");
        } else {
            System.out.println("Adding Books To Library");
            createBooks();
        }
        if (new File("members.ser").isFile()) {
            System.out.println("Load Members");
            members = (libraryMemberList) FileUtility.loadObject("members.ser");
        } else {
            System.out.println("Creating users");
            createMembers();
        }
        if (new File("librarians.ser").isFile()) {
            System.out.println("Load librarians");
            librarians = (LibrarianList) FileUtility.loadObject("librarians.ser");
        }

    }

    private void createBooks() {
        libraryBooks.addBook(new Book("Fellowship of the Ring ", "J R R Tolkien", "Continuing the story begun in The Hobbit, this is the first part of Tolkien's epic masterpiece, The Lord of the Rings, featuring the definitive text and a detailed map of Middle-earth.Sauron, the Dark Lord, has gathered to him all the Rings of Power", true));
        libraryBooks.addBook(new Book("A Game of Thrones", "George R R  Martin", "Winter is coming. Such is the stern motto of House Stark, the northernmost of the fiefdoms that owe allegiance to King Robert Baratheon in far-off King's Landing. There Eddard Stark of Winterfell rules in Robert's name.", true));
        libraryBooks.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "After murdering Harry's parents, James and Lily Potter, evil Lord Voldemort puts a killing curse on Harry, then just a baby. The curse inexplicably reverses, defeating Voldemort and searing a lightning-bolt scar in the middle of the infant's forehead.", true));

        FileUtility.saveObject("library_Books.ser", libraryBooks);
    }

    private void createMembers() {
        members.addMembers(new LibraryMember("Kalle", "Kalle123", "Abc123"));
        members.addMembers(new LibraryMember("Emmanuel", "Emmanuel111", "em123"));


        FileUtility.saveObject("members.ser", members);
    }

    private void exitAndSave() {
        FileUtility.saveObject("library_Books.ser", libraryBooks);
        FileUtility.saveObject("members.ser", members);
        FileUtility.saveObject("librarians.ser", librarians);
    }
}
