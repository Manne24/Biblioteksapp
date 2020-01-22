package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberList {

    // Lista på Användare i biblioteket
    private List<LibraryMember> members  = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    MemberList(){
        addMembers();
    }

    public void addMembers() {
        members.add(new LibraryMember("Kalle", "Kalle123", "Abc123"));
        members.add(new LibraryMember("Emmanuel", "Emmanuel111", "em123"));
    }

    public void showMembers(){
        for (LibraryMember member : members){
            System.out.println(member);
        }
    }
}
