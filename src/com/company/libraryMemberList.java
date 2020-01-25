package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class libraryMemberList implements Serializable {
    // Lista på Användare i biblioteket
    private List<LibraryMember> members  = new ArrayList<>();


    libraryMemberList(){
       // addMembers();
    }
    public void addMembers() {
     //   members.add(new LibraryMember("Emmanuel", "Emmanuel111", "em123"));
    }



    public void showMembers(){
        for (LibraryMember member : members){
            System.out.println(member);
        }
    }

    public List<LibraryMember> getMembers() {
        return members;
    }

    public void searchForMember() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The Name of the LibraryMember: ");
        ArrayList<String> result = new ArrayList<>();
        String userInput = input.nextLine();
        for (LibraryMember member : members) {
            if (member.getName().toLowerCase().contains(userInput.toLowerCase()) || member.getUserName().toLowerCase().contains(userInput.toLowerCase()) ){
                result.add(member.getName());
            }
        }

        if (result.isEmpty()){
            System.out.println("The Member was not found");
            input.nextLine();
        }else {
            System.out.println("Member was found: ");
            for (String member: result){
                System.out.println(member);
            }
        }
    }

    public void showBorrowedBooksForMember(){

    }
}
