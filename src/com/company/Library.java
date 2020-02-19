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
            System.out.println("4. Exit and Save your user Login after registration");
            String option = input.nextLine();

            switch (option) {
                case "1":
                    bookList.showBooks();
                    break;
                case "2":
                    user.createAccount();
                    //user.register();
                    break;
                case "3":
                   // login(user.login());
                  user.logIn();
                    break;
                case "4":
                  //  FileUtility.saveObject("users.ser", user.getUsers());
                    FileUtility.saveObject("users.ser", user.getUsers());
                    FileUtility.saveObject("books.ser", bookList.books);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter numbers 1-4");
            }
            }
        }
    private void CustomerMenu(Customer userName) {

        boolean borrowing = true;

        while (borrowing) {

            System.out.println("--- Customer menu ---");
            System.out.println("1. Show all books");
            System.out.println("2. loan a book");
            System.out.println("3. Return a book");
            System.out.println("4. Show my loaned book");
            System.out.println("5. Show available books");
            System.out.println("6. Find an Author");
            System.out.println("7. Find a Book");
            System.out.println("8. Logout");


            String option = input.nextLine();

            switch (option) {
                case "1":
                    bookList.showBooks();
                    break;
                case "2":
                    loanABook(userName);
                    break;
                case "3":
                    returnABook(userName);
                    break;
                case "4":
                    user.showCustomerBooks(userName);
                    break;
                case "5":
                    bookList.showAvailableBooks();
                    break;
                case "6":
                   findAuthor();
                    break;
                case "7":
                    findBook();
                    break;
                case "8":
                    borrowing = false;
                    break;
                default:
                    System.out.println("Enter a number between 1-8");
                    break;
            }
        }

    }

    private void findAuthor() {
    }

    private void loanABook(Customer userName) {
        System.out.println("Book to be loaned: ");
        String bookName = input.nextLine();
        Book bookInBookList = bookList.getBook(bookName);

        if (bookInBookList != null) {
            Book book = bookList.isBookAvailable(bookName);
            if (book != null) {
                userName.loanBookFromLibrary(book);
                System.out.printf("Your Book: %s loaned.\n", book.getBookName());
            }
        }
    }

    private void returnABook( Customer userName) {
        if (userName != null) {
            System.out.println("Book to be return:");
            String itemToReturn = input.nextLine();
            userName.returnBookToLibrary(itemToReturn);
        } else {
            System.out.println("Incorrect Customer name.\n");
        }
    }
    }



