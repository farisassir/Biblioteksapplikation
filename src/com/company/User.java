package com.company;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
    transient Scanner input = new Scanner(System.in);
    private ArrayList<Person> users = new ArrayList<>();

    public User() {

        if (Files.exists(Paths.get("users.ser"))) {
            users = (ArrayList<Person>) FileUtility.loadObject("users.ser");
        } else {
            FileUtility.saveObject("users.ser", users);
        }

    }

    public void createAccount(){
        System.out.println("1- Admin");
        System.out.println("2- Customer");
        String userPrivilege = input.nextLine();
        choosePrivilege(userPrivilege);

    }

    private void choosePrivilege(String userPrivilege) {
        switch (userPrivilege){
            case    "1":
                registerAccount("1");
                break;
            case "2":
                registerAccount("2");
                break;
            default:
                System.out.println("Enter 1 for admin  or 2 for customer");
                break;
        }
    }

    private void registerAccount(String userPrivilege){
        System.out.println("Your Name");
        String name = input.nextLine();
    }

}
