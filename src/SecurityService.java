package com.club.service;
import java.util.Date;
import java.util.Random;
// Service class to handle security-related checks like age validation
public class SecurityService {
   // Validates if the member's age is 21 or above
   public void validateAge(Member m) throws AgeRestrictionException {
      if (m.age < 21) {
         throw new AgeRestrictionException("Must be 21+.");
      }
      System.out.println("Age validated.");
   }

   // Returns the current system date
   public Date getCurrentDate() {
      return new Date(); 
   }
   // Performs a random check that returns true ~20% of the time
   public boolean randomCheck() {
      return new Random().nextInt(10) > 7; 
   }
}
