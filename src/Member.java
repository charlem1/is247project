package com.club.service;

public class Member extends Person {
  private static int idCounter = 1000;
  private final int memberId;
  private final boolean isVIP;

  public Member(String name, int age, boolean isVIP) {
    super(name, age); 
    this.memberId = idCounter++;
    this.isVIP = isVIP;
  }

  public int getMemberId() {
    return this.memberId;
  }

  public boolean isVIP() {
    return isVIP;
}
  @Override
  public void displayInfo() {
    String status = isVIP ? "🌟 VIP" : "Regular";
    System.out.printf("👤 Member ID: %d | Name: %s | Age: %d | Status: %s\n",
                      memberId, name, age, status);
  }
}
