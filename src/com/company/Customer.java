package com.company;


import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Person implements Serializable {

    ArrayList<Book> loans = new ArrayList<>();

    public Customer(String name, String userName, String password) {

        super(name, userName, password);
    }


    public void loanBookFromLibrary(Book book) {
        loans.add(book);
        book.setAvailable(false);

    }

    public void returnBookToLibrary(String bookName) {
        Book book = getLoanedBook(bookName);
      int removeBook = getBookIndex(bookName);
        if (book.isAvailable() == false || book != null) {
            loans.remove(removeBook);
            book.setAvailable(true);
            System.out.println("Book returned.");
        } else {
            System.out.println("Incorrect Book name \n");
        }
    }

    private Book getLoanedBook(String bookName) {
        for (Book book : loans) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    private int getBookIndex(String bookName) {
        if (bookName != null)
            for (Book book : loans) {
                if (book.getBookName().equalsIgnoreCase(bookName)) {
                    return loans.indexOf(book);
                }
            }
        return 0;
    }



    public void getLoanedBooks() {
        if (loans.size() > 0) {
            for (Book loan : loans) {
                System.out.println("Book Name: " + loan.getBookName());
            }
        }
        System.out.println(" ");
    }
    public void showLoanedBooks(String name) {
        System.out.println("Loaned books by " + name + ": ");
        getLoanedBooks();
    }

    @Override
    public void getInfo() {
        System.out.printf("\nName: %s\nUsername: %s\n\n", getName(), getUserName());

    }
}
