package com.company;


import java.io.Serializable;

public class Book implements Serializable {

   private String bookName;
   private String author;
   private String description;
   private boolean available;
   private String loaner;



   public Book(String bookName, String author, String description, boolean available, String loaner) {
      this.bookName = bookName;
      this.author = author;
      this.description = description;
      this.available = available;
      this.loaner = loaner;
   }

   public String getLoaner() {
      return loaner;
   }

   public void setLoaner(String loaner) {
      this.loaner=loaner;
   }

   public String getBookName() {
      return bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public boolean isAvailable() {
      return available;
   }

   public boolean setAvailable(boolean available) {
      this.available = available;
      return available;
   }



   public void getInfo(){
      System.out.println(" Book name : "+getBookName() +" \n Author: "+getAuthor()+ " \n "+getDescription()+"\n "+isAvailable() +" \n" + "Book loaned by: "+ getLoaner() + "\n");

   }
}
