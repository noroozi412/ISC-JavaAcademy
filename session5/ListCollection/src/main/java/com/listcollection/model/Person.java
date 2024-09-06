package com.listcollection.model;

import jakarta.persistence.Entity;

public class Person {
    public Person(String name, String fname, int age, Address address) {
        this.name = name;
        this.fname = fname;
        this.age = age;
        this.address = address;
    }

    private String name;
    private String fname;
    private int age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
