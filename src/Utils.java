package com.club.service;

public class Utils {

    // Private constructor to prevent instantiation (encapsulation)
    private Utils() {}

    // Validates name and contains only letters and spaces
    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z ]+");
    }

    // Prints a separator line
    public static void printLine() {
        System.out.println("-".repeat(50));
    }

    // Checks for overloaded printLine with custom character
    public static void printLine(char ch) {
        System.out.println(String.valueOf(ch).repeat(50));
    }

    // Checks for overloaded printLine with length and character
    public static void printLine(char ch, int length) {
        System.out.println(String.valueOf(ch).repeat(length));
    }

    // Capitalizes the first letter of each word in a name
    public static String formatName(String name) {
        if (name == null || name.isBlank()) return "";
        String[] parts = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1).toLowerCase())
                    .append(" ");
        }
        return sb.toString().trim();
    }

    // Checks if the age is valid (non-negative and within a typical adult range)
    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }
}
