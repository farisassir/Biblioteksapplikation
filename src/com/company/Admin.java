package com.company;


import java.io.Serializable;

public class Admin extends Person implements Serializable {

    public Admin(String name, String userName, String password) {
        super(name, userName, password);
    }

    @Override
    public void getInfo() {
        System.out.printf("\nName: %s\n Username: %s \n", getName(), getUserName());

    }
}

