package com.company;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


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
        System.out.println("1- Customer");
        System.out.println("2- Admin");
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
                System.out.println("Enter 1 for Customer  or 2 for Admin");
                break;
        }
    }

    private void registerAccount(String userPrivilege){
        System.out.println("Your Name");
        String name = input.nextLine();
        userVerification(name, userPrivilege);
    }

    private void userVerification(String name, String userPrivilege ) {

        boolean validateUserName = true;
        boolean validatePassword = true;

        while (validateUserName) {
            System.out.println("Choose a username: ");
            String userName = input.nextLine();
            Person checkUserName = getUserName(userName);
            if (checkUserName == null) {
                while (validatePassword) {
                    System.out.println("Choose 4 digits code: ");
                    String password = input.nextLine();
                    if(validatePassword(password)) {
                        if (userPrivilege.equals("1")) {
                            users.add(new Customer(name, userName, password));
                            System.out.println("Registration Succeeded!");
                            validateUserName = false;
                            validatePassword = false;
                        } else if (userPrivilege.equals(("2")){
                            users.add(new Admin(name, userName, password));
                            System.out.println("Registration Succeeded!");
                            validateUserName = false;
                            validatePassword = false;
                        }

                    } else {
                        System.out.println("Password is only 4 digits!\n");
                    }
                }
            }   else   {
                        System.out.println("Username already registered\n");
            }
        }
    }

    public Person logIn(){
        System.out.println("Enter your username: ");
        String userLogin = input.nextLine();
        Person user = getUserName(userLogin);
        if (user != null) {
            while (true){
                System.out.println("Enter Password: ");
                String password = input.nextLine();
                if (password != null){
                    if(user.getPassword().equals(password)){
                        System.out.println(" You Logged in\n");
                        return user;
                    }
                } else
                System.out.println("Wrong Password");
            }
        } else
        System.out.println("Wrong Username");
        return null;
    }

    public Person getUserName(String userName) {
        for (Person user : users) {
            if (userName.equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

    private boolean validatePassword(String password) {
        String regex ="^(?=.*\\d).{4}$";
        return Pattern.matches(regex, password);
    }

    }

