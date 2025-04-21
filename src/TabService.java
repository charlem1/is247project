package com.club.service;
import java.util.HashMap;
import java.util.Map;
/** This class manages bar tabs for customers in the club.
 * Each customer is identified by a unique user ID (e.g., wristband or app ID).
 */
public class TabService {

    // Stores each user's current tab balance
    private Map<String, Double> tabRecords = new HashMap<>();

    /** Opens a new tab for a user if they don't already have one.
     * @param userId The unique ID of the user.
     */
    public void openTab(String userId) {
        tabRecords.putIfAbsent(userId, 0.0); // only adds if not already present
    }

    /**
     * Adds a charge to the user's tab.
     * If the user doesn't have a tab, one is created automatically.
     * @param userId The unique ID of the user.
     * @param amount The amount to add to their tab.
     */
    public void addToTab(String userId, double amount) {
        if (!tabRecords.containsKey(userId)) {
            openTab(userId); // ensures user has a tab
        }
        double newTotal = tabRecords.get(userId) + amount;
        tabRecords.put(userId, newTotal); // update with new total
    }

    /**
     * Retrieves the current balance of a user's tab.
     * @param userId The unique ID of the user.
     * @return The amount owed, or 0.0 if no tab exists.
     */
    public double getBalance(String userId) {
        return tabRecords.getOrDefault(userId, 0.0);
    }

    /**
     * Closes the user's tab and returns the final amount owed.
     * The user is removed from the system after checkout.
     * @param userId The unique ID of the user.
     * @return The total amount that was on their tab.
     */
    public double closeTab(String userId) {
        return tabRecords.remove(userId); // remove and return balance
    }

    /**Notifies the user if they have an unpaid balance.
     * This could be triggered during check-out.
     * @param userId The unique ID of the user.
     */
    public void alertOutstandingBalance(String userId) {
        double balance = getBalance(userId);
        if (balance > 0) {
            System.out.println("Outstanding balance for user " + userId + ": $" + balance);
            System.out.println(" Interest will begin accruing in 24 hours if not paid.");
        }
    }
}

