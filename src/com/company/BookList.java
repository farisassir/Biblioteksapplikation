package com.company;

import java.io.Serializable;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class BookList implements Serializable {


    public ArrayList<Book> books = new ArrayList<>();

    public BookList() {

        if (Files.exists(Paths.get("books.ser"))) {
            books = (ArrayList<Book>) FileUtility.loadObject("books.ser");
        } else {
            createBoolList();
        }
    }

    public void createBoolList() {
        books.add(new Book("The Poets Laureate Anthology", "Elizabeth Hun Schmidt", "As a record of poetry, The Poets Laureate Anthology is groundbreaking, charting the course of American poetry over the last seventy-five years, while being, at the same time, a pleasure to read, full of some of the world's best-known poems and many new surprises. Elizabeth Hun Schmidt has gathered and introduced poems by each of the forty-three poets who have been named our nation's poets laureate since the post (originally called Consultant in Poetry to the Library of Congress) was established in 1937. Poets range from Robert Pinsky, William Carlos Williams, and Elizabeth Bishop to Charles Simic, Billy Collins, and Rita Dove. Schmidt's spirited introductions place the poets and their poems in historical and literary context and shine light on the interesting and often uneasy relationship between politics and art. This is an inviting, monumental collection for everyone's library, containing much of the best poetry written in America over the last century.", true));
        books.add(new Book("999", "Al Sarrantonio", "New Stories of Horror and Suspense is a collection of short stories and novellas published in 1999 and edited by Al Sarrantonio. The title is a contraction of the year as well as 666 upside-down. All twenty-nine stories had never been published before", true));
        books.add(new Book("To Kill a Mockingbird", " Harper Lee", "To Kill a Mockingbird is a novel by Harper Lee published in 1960. Instantly successful, widely read in high schools and middle schools in the United States, it has become a classic of modern American literature, winning the Pulitzer Prize", true));
        books.add(new Book("Nineteen Eighty-Four", "George Orwell", "Nineteen Eighty-Four: A Novel, often published as 1984, is a dystopian novel by English novelist George Orwell. It was published in June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime.", true));
        books.add(new Book("Hamlet", "William Shakespeare", "The Tragedy of Hamlet, Prince of Denmark, often shortened to Hamlet, is a tragedy written by William Shakespeare sometime between 1599 and 1602", true));
        books.add(new Book("The Kite Runner", "Khaled Hosseini", "The Kite Runner is the first novel by Afghan-American author Khaled Hosseini. Published in 2003 by Riverhead Books, it tells the story of Amir, a young boy from the Wazir Akbar Khan district of Kabul, whose closest friend is Hassan", true));
        books.add(new Book("A Brief History of Time", "Stephen Hawking", "A Brief History of Time: From the Big Bang to Black Holes is a popular-science book on cosmology by British physicist Stephen Hawking. It was first published in 1988. Hawking wrote the book for readers who have no prior knowledge of the universe and people who are just interested in learning something new", true));
        books.add(new Book("Silent Spring", " Rachel Carson", "Silent Spring is an environmental science book by Rachel Carson. The book was published on September 27, 1962, documenting the adverse environmental effects caused by the indiscriminate use of pesticides.", true));
        books.add(new Book("In Cold Blood", "Truman Capote", "In Cold Blood is a non-fiction novel by American author Truman Capote, first published in 1966; it details the 1959 murders of four members of the Herbert Clutter family in the small farming community of Holcomb, Kansas.", true));
        books.add(new Book("The Top 100 Crime Novels of All Time", " Crime Writers' Association", "DescriptionThe Top 100 Crime Novels of All Time is a list published in book form in 1990 by the British-based Crime Writers' Association. Five years later, the Mystery Writers of America published a similar list entitled The Top 100 Mystery Novels of All Time. Many titles can be found in both lists", true));
        FileUtility.saveObject("books.ser", books);
    }



    public void showBooks() {
        for (Book book : books) {
            book.getInfo();
        }
    }





    public Book getBook(String bookName) {
        for (Book book : books) {
            if (bookName.equals(book.getBookName()))
                return book;
        }
        System.out.println("We don´t have this book");
        return null;
    }

    public void showAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable())
                book.getInfo();
        }
    }
    void showLoanedBooks() {
        System.out.println("Borrowed books: \n");
        for (Book book : books) {
            if (!book.isAvailable())
                book.getInfo();
        }

    }

    public Book isBookAvailable(String bookName) {
        Book book = getBook(bookName);
        if (book != null) {
            if (book.isAvailable()) {
                return book;
            }
        }
        System.out.println("This Book is borrowed");
        return null;
    }

    public Book findBookWithAuthor(String name) {
        ArrayList<Book> authors = new ArrayList<>(books);
        for (Book author : authors) {
            if (author.getAuthor().contains(name)) {
                return author;
            }
        }
        System.out.println("We don`nt have this Author");
        return null;
    }

    public Book findBookWithBookName(String name) {
        ArrayList<Book> names = new ArrayList<>(books);
        for (Book bookName : names) {
            if (bookName.getBookName().contains(name)) {
                return bookName;
            }
        }
        System.out.println("This book is not available");
        return null;

    }





    public ArrayList<Book> getBooks() {
        return books;
    }
}





