package com.example.employeeapp;

import java.io.Serializable;

class Company implements Serializable {
    String name;

    public Company(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return name;
    }
}
