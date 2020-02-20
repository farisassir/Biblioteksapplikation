package com.company;



public class Admin extends Person {

    public Admin(String name, String userName, String password) {
        super(name, userName, password);
    }

    @Override
    public void getInfo() {
        System.out.printf("\nName: %s\n Username: %s \n", getName(), getUserName());

    }
}

