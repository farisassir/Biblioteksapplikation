package com.company;


import java.util.ArrayList;

public class Customer extends Person {

    ArrayList<Book> loans = new ArrayList<>();

    public Customer(String name, String userName, String password) {

        super(name, userName, password);
    }

    @Override
    public void getInfo() {

    }

    public void loanBookFromLibrary(Book book) {
        loans.add(book);
        book.setAvailable(false);
    }

    public void returnBookToLibrary(String itemToReturn) {
        Book bookReturned = getBorrowedBook(itemToReturn);
        int indexBookRemove = getIndexOfBook(itemToReturn);
        if (bookReturned != null) {
            loans.remove(indexBookRemove);
            System.out.println("Book returned.");
        } else {
            System.out.println("Incorrect Book name \n");
        }
    }

    private Book getBorrowedBook(String title) {
        for (Book book : loans) {
            if (book.getBookName().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private int getIndexOfBook(String title) {
        if (title != null)
            for (Book book : loans) {
                if (book.getBookName().equalsIgnoreCase(title)) {
                    return loans.indexOf(book);
                }
            }
        return 0;
    }

}
