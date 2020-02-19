package com.company;

import javax.swing.*;

public abstract class Person {

    private String name;
    private String userName;
    private String password;


    public Person(String name, String password, String userName) {
        this.name = name;
        this.userName = userName;
        this.password = password;

    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

  public abstract void getInfo();
}
