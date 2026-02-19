package com.example.Testing1;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public String getMessage() {
        return "Gokul";
    }

    public boolean check1() {
        return true;
    }

    public String getException(int age) {
        if (age < 18) {
            throw new RuntimeException("Age Restricted");
        }
        return "Access Accepted";
    }

    public int check2(int number) {
        return number % 2;
    }
}

