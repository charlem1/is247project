package com.club.service;

public abstract class Person {
    // Encapsulated fields
    public String name;
    public int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method to enforce subclass implementation
    public abstract void displayInfo();

    // Getter for name
    public String getName() {
        return name;
    }

    // Sets name
    public void setName(String name) {
        if (Utils.isValidName(name)) {
            this.name = name;
        }
    }

    // Gets ages
    public int getAge() {
        return age;
    }

    // Sets ages
    public void setAge(int age) {
        if (Utils.isValidAge(age)) {
            this.age = age;
        }
    }
}
