package com.club.service;

public class Utils {
    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z ]+");
    }

    public static void printLine() {
        System.out.println("-".repeat(50));
    }
}
