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
            System.out.println("4. Exit and Save your work");
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
                   logIn(user.logInUser());
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

    private void logIn(Person userName) {

        if (userName instanceof Customer) {
            customerMenu((Customer) userName);
        } else if (userName instanceof Admin) {
            adminMenu((Admin) userName);
        }

    }

    private void customerMenu(Customer userName) {

        boolean borrowing = true;

        while (borrowing) {

            System.out.println("      Customer menu     ");
            System.out.println("1. Show all books");
            System.out.println("2. loan a book");
            System.out.println("3. Return a book");
            System.out.println("4. Show All loaned book");
            System.out.println("5. Show available books");
            System.out.println("6. Show my loaned book");
            System.out.println("7. Find an Author");
            System.out.println("8. Find a Book");
            System.out.println("9. Logout");


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
                    bookList.showLoanedBooks();
                    break;
                case "5":
                    bookList.showAvailableBooks();
                    break;
                case "6":
                    user.showCustomerBooks(userName);
                case "7":
                   findAuthor();
                    break;
                case "8":
                    findBook();
                    break;
                case "9":
                    borrowing = false;
                    break;
                default:
                    System.out.println("Enter a number between 1-8");
                    break;
            }
        }

    }

    private void findBook() {
        System.out.println("Book Name: ");
        try {
            String name = input.nextLine();
            Book book = bookList.findBookWithBookName(name);
            if (book != null) {
                book.getInfo();
            }
        } catch (Exception e) {
            System.out.println("Try again!\n");
        }
    }

    private void findAuthor() {
        System.out.println("Author Name: ");
        try {
            String author = input.nextLine();
            Book book = bookList.findBookWithAuthor(author);
            if (book != null) {
                book.getInfo();
            }
        } catch (Exception e) {
            System.out.println("Try again!\n");
        }

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
    private void adminMenu(Admin userName) {

        boolean administrating = true;

        while (administrating) {

            System.out.println("--- Administrator menu ---");
            System.out.println("1. Show all Books");
            System.out.println("2. Show all customers");
            System.out.println("3. Show all loaned book");
            System.out.println("4. Search Customer name");
            System.out.println("5. Show Customer books");
            System.out.println("6. Logout");

            String option = input.nextLine();

            switch (option) {
                case "1":
                    bookList.showBooks();
                    break;
                case "2":
                    user.showAllCustomers();
                    break;
                case "3":
                    bookList.showLoanedBooks();
                    break;
                case "4":
                    user.findCustomerByName();
                    break;
                case "5":
                    showCustomerBooks();
                    break;
                case "6":
                    administrating = false;
                    break;
                default:
                    System.out.println("Enter between 1-6");
            }
        }
    }

    private void showCustomerBooks() {
        System.out.println("Customer Name");
        String name = input.nextLine();
        Customer customer = (Customer) user.getUserName(name);
        user.showCustomerBooks(customer);
    }




}



