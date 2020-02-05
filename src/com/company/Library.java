package com.company;

import java.io.Serializable;
import java.util.Scanner;

public class Library implements Serializable {

    BookList bookList = new BookList();
    User user = new User();
    transient Scanner input = new Scanner(System.in);

    public void start() {
        menu();
    }

    private void menu(){
        while (true) {
            System.out.println("       Welcome to our Library        ");
            System.out.println("          Make your Choice             ");
            System.out.println("1. Show books");
            System.out.println("2. Register");
            System.out.println("3. Login");
            System.out.println("4. Save your user Login after registration");
            System.out.println("5. Exit");
            String option = input.nextLine();

            switch (option) {
                case "1":
                    bookList.showBooks();
                    break;
                case "2":
                    //user.register();
                    break;
                case "3":
                   // login(user.login());
                    break;
                case "4":
                  //  FileUtility.saveObject("users.ser", user.getUsers());
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter numbers between 1-5");
            }
            }
        }
    }



