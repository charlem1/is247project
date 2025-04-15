package com.club.service;

import java.util.*;

public class ClubApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Member> members = new ArrayList<>();
    private static final List<String> logs = new ArrayList<>();
    private static final TabService tabService = new TabService();
    private static final SecurityService securityService = new SecurityService();

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

    // Overloaded method
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

    private static void showAllMembers() {
        if (members.isEmpty()) {
            System.out.println("🚫 No members yet.");
            return;
        }
        members.forEach(Member::displayInfo);
    }

    private static Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        System.out.println("❌ Member not found.");
        return null;
    }

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

    private static void viewPurchases() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        Member m = findMemberById(id);
        if (m != null) tabService.showPurchases(m);
    }

    private static void validateAge() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        Member m = findMemberById(id);
        if (m != null) {
            try {
                securityService.validateAge(m);
            } catch (AgeRestrictionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

