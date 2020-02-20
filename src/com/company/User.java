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

     void registerAccount(String userPrivilege){
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
                        } else if (userPrivilege.equals("2")) {
                            users.add(new Admin(name, userName, password));
                            System.out.println("Registration Succeeded!");
                            validateUserName = false;
                            validatePassword = false;
                        }

                    } else {
                        System.out.println("Password is only 4 digits & Chart!\n");
                    }
                }
            }   else   {
                        System.out.println("Username already registered\n");
            }
        }
    }

    public Person logInUser(){
        System.out.println("Enter your username: ");
        String userLogin = input.nextLine();
        Person user = getUserName(userLogin);
        if (user != null) {
            while (true){
                System.out.println("Enter Password: ");
                String password = input.nextLine();
                if (password != null){
                    if(user.getPassword().equals(password)){
                        System.out.println("You Logged in\n");
                        return user;
                    }
                }
                System.out.println("Wrong Password");
            }
        }
        System.out.println("Wrong Username");
        return null;
    }



    private boolean validatePassword(String password) {
        String regex ="^(?=.*\\d).{4,8}$";
        return Pattern.matches(regex, password);
    }


public void  findCustomerByName() {
    System.out.println("Enter Name: ");
    String name = input.nextLine();
    Person person = getCustomer(name);
    if (person != null) {
        person.getInfo();
    } else {
        System.out.println("This name is not a customer with us");
    }
}
    public Person getUserName(String userName) {
        for (Person user : users) {
            if (userName.equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

    private Person getCustomer(String name) {
        for (Person customer : users) {
            if ( customer instanceof Customer)
                if (name.equalsIgnoreCase(customer.getName())) {
                    return customer;
                }
        }
        return null;
    }

    void showCustomerBooks(Customer userName) {
        if (userName != null) {
            userName.showLoanedBooks(userName.getName());
        } else {
            System.out.println("Try another name");
        }
}

    void showAllCustomers() {
        System.out.println("Customer: \n");
        for (Person borrower : users) {
            if (borrower instanceof Customer) {
                borrower.getInfo();
            }
        }

}

    public ArrayList<Person> getUsers() {
        return users;
    }
}

