package com.example.employeeapp;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String website;
  //  private Company company;

    // private Address address;

    public Employee(String id, String name, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}
