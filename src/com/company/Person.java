package com.company;

import javax.swing.*;

public abstract class Person {

    private String name;
    private String userName;
    private String code;


    public Person(String name, String code, String userName) {
        this.name = name;
        this.userName = userName;
        this.code = code;

    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }


    public String getCode() {
        return code;
    }

  public abstract void getInfo();
}
