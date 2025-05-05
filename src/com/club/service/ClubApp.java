package com.club.service;

import java.util.*;
/**
 * The {@code ClubApp} class serves as the entry point for the club management system.
 * It handles member registration, purchase tracking, report generation, and age validation.
 * <p>
 * It uses services such as {@link TabService} and {@link SecurityService}, and supports features
 * like VIP status, logs, and tab purchases.
 * </p>
 *
 * <p>This application runs in a console loop offering interactive menu options.</p>
 *
 * @author
 */
public class ClubApp {
    /** Scanner for user input. */
    private static final Scanner scanner = new Scanner(System.in);

    /** List to store all registered club members. */
    private static final List<Member> members = new ArrayList<>();

    /** Logs of major events such as registration and purchases. */
    private static final List<String> logs = new ArrayList<>();

    /** Service for handling purchases (tabs). */
    private static final TabService tabService = new TabService();

    /** Service for validating age and enforcing security rules. */
    private static final SecurityService securityService = new SecurityService();
    /**
     * Main entry point of the application. Presents a menu and responds to user input.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        while (true) {
            Utils.printLine();
            System.out.println("""
                🎉 Club Menu:
                1. Register Member
                2. Show All Members
                3. Add Purchase
                4. View Purchases
                5. Generate Report
                6. Validate Age
                0. Exit
                """);
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> registerMember();
                case 2 -> showAllMembers();
                case 3 -> addPurchase();
                case 4 -> viewPurchases();
                case 5 -> tabService.printReport(logs);
                case 6 -> validateAge();
                case 0 -> {
                    System.out.println("👋 Exiting ClubApp.");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }

    /**
     * Registers a new member by collecting name, age, and VIP status.
     * Validates name and stores the member in the list.
     */
    private static void registerMember() {
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (!Utils.isValidName(name)) {
            System.out.println("❌ Invalid name.");
            return;
        }
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Is VIP? (true/false): ");
        boolean isVIP = scanner.nextBoolean();

        Member member = new Member(name, age, isVIP);
        members.add(member);
        System.out.println("✅ Member registered!");
        logs.add("Registered: " + member.getMemberId());
    }
    /**
     * Displays all registered members. If the list is empty, notifies the user.
     */
    private static void showAllMembers() {
        if (members.isEmpty()) {
            System.out.println("🚫 No members yet.");
            return;
        }
        members.forEach(Member::displayInfo);
    }
    /**
     * Finds a member by their ID.
     *
     * @param id the unique member ID
     * @return the {@code Member} if found, otherwise {@code null}
     */
    private static Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        System.out.println("❌ Member not found.");
        return null;
    }
    /**
     * Adds a purchase item to a specific member's tab.
     * Prompts for Member ID and item name.
     */
    private static void addPurchase() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Member m = findMemberById(id);
        if (m != null) {
            System.out.print("Enter item: ");
            String item = scanner.nextLine();
            tabService.addPurchase(m, item);
            logs.add("Purchase: " + item + " by " + m.name);
        }
    }
    /**
     * Views the list of purchases made by a specific member.
     * Prompts for Member ID.
     */
    private static void viewPurchases() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        Member m = findMemberById(id);
        if (m != null) tabService.showPurchases(m);
    }
    /**
     * Validates the age of a member using the {@code SecurityService}.
     * Prompts for Member ID and handles age-related exceptions.
     */
    private static void validateAge() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        Member m = findMemberById(id);
        if (m != null) {
            try {
                securityService.validateAge(m);
            } catch (com.club.service.AgeRestrictionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
