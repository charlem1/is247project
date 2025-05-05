package com.club.service;
/**
 * The {@code Member} class represents a club member with a unique member ID and VIP status.
 * It extends the {@link Person} class and includes additional attributes relevant to club members.
 *
 * <p>Each member is automatically assigned a unique ID starting from 1000.
 * VIP status can be used to give special privileges or faster check-ins.</p>
 *
 * @author
 */
public class Member extends Person {

  /** Static counter used to generate unique member IDs. */
  private static int idCounter = 1000;

  /** Unique ID assigned to each member. */
  private final int memberId;

  /** Indicates whether the member has VIP status. */
  private final boolean isVIP;
  public int age;


  /**
   * Constructs a new {@code Member} with the specified name, age, and VIP status.
   *
   * @param name  the name of the member
   * @param age   the age of the member
   * @param isVIP true if the member is a VIP; false otherwise
   */
  public Member(String name, int age, boolean isVIP) {
    super(name, age);
    this.memberId = idCounter++;
    this.isVIP = isVIP;
  }
  /**
   * Returns the unique ID of the member.
   *
   * @return the member's unique ID
   */
  public int getMemberId() {
    return this.memberId;
  }
  /**
   * Returns whether the member is a VIP.
   *
   * @return {@code true} if the member is a VIP, {@code false} otherwise
   */
  public boolean isVIP() {
    return isVIP;
  }
  /**
   * Displays member information to the console, including ID, name, age, and VIP status.
   * Overrides the {@code displayInfo} method from {@link Person}.
   */
  @Override
  public void displayInfo() {
    String status = isVIP ? "🌟 VIP" : "Regular";
    Object name = null;
    Object age = null;
    System.out.printf("👤 Member ID: %d | Name: %s | Age: %d | Status: %s\n",
            memberId, name, age, status);
  }
}
