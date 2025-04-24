package com.club.service;
import java.util.Date;
import java.util.Random;
public class SecurityService {
   public void validateAge(Member m) throws AgeRestrictionException{
      if(m.age<21){
         throw new AgeRestrictionException(" Must be 21+.");
      }
      System.out.println("Age validated.");
   }
   public Date getCurrentDate(){
      return new Data();
      public boolen randomCheck(){
         return new Random().nextInt (bound:10)>7;
      }
   }
