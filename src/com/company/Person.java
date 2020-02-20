package com.company;

import javax.swing.*;
import java.io.Serializable;

public abstract class Person implements Serializable {

    private String name;
    private String userName;
    private String password;

    public Person(String name, String userName, String password) {
        this.name=name;
        this.userName=userName;
        this.password=password;

    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public abstract void getInfo();
}
