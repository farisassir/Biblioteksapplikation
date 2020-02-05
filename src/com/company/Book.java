package com.company;


import java.io.Serializable;

public class Book implements Serializable {

   private String bookName;
   private String author;
   private String description;
   private boolean available;



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

   public void setAvailable(boolean available) {
      this.available = available;
   }

   public Book(String bookName, String author, String description, boolean available) {
      this.bookName = bookName;
      this.author = author;
      this.description = description;
      this.available = available;
   }

   public void getInfo(){
      System.out.println(" Book name : "+getBookName() +" \n Author: "+getAuthor()+ " \n "+getDescription()+"\n "+isAvailable() +" \n");

   }
}
